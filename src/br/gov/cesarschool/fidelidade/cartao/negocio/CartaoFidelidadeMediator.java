package br.gov.cesarschool.fidelidade.cartao.negocio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.cesarschool.fidelidade.cartao.dao.CartaoFidelidadeDAO;
import br.gov.cesarschool.fidelidade.cartao.dao.LancamentoExtratoDAO;
import br.gov.cesarschool.fidelidade.cartao.entidade.CartaoFidelidade;
import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtratoPontuacao;
import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtratoResgate;
import br.gov.cesarschool.fidelidade.cartao.entidade.RetornoConsultaExtrato;
import br.gov.cesarschool.fidelidade.cartao.entidade.TipoResgate;
import br.gov.cesarschool.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.fidelidade.excecoes.ExcecaoDadoInvalido;
import br.gov.cesarschool.fidelidade.util.Ordenador;
import br.gov.cesarschool.fidelidade.util.StringUtil;
import br.gov.cesarschool.fidelidade.util.ValidadorCPF;

public class CartaoFidelidadeMediator {

	private static final String ERRO_AO_INCLUIR_LANCAMENTO = "Erro ao incluir lan�amento";
	private static final String ERRO_NA_ALTERACAO_DO_CARTAO = "Erro na altera��o do cart�o";
	private static final String CARTAO_INEXISTENTE = "Cart�o n�o existe";
	private static final String QUANTIDADE_DE_PONTOS_MENOR_QUE_ZERO = "Quantidade de pontos menor que zero";
	private static CartaoFidelidadeMediator instance;
	private CartaoFidelidadeDAO repositorioCartao;
	private LancamentoExtratoDAO repositorioLancamento;
	
	
	private CartaoFidelidadeMediator() {
		repositorioCartao = new CartaoFidelidadeDAO();
		repositorioLancamento = new LancamentoExtratoDAO();
	}
	
	public static CartaoFidelidadeMediator getInstance() {
		if (instance == null) {	
			instance = new CartaoFidelidadeMediator();
		}
		return instance;
	}
	
	public long gerarCartao(Cliente cliente) {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");		
		String cpf = cliente.getCpf();		
		if (ValidadorCPF.ehCpfValido(cpf) == false) {
			return 0;
		}		
		String cpfSemDigitosVerificadores = cpf.substring(0, cpf.length() - 2);		
		String cartao = cpfSemDigitosVerificadores + date.format(new Date()); 
		long cardZinho = Long.parseLong(cartao);		
		CartaoFidelidade card = new CartaoFidelidade(cardZinho);		
		repositorioCartao.incluir(card);				
		return cardZinho;
	}

	private String processarAlteracaoCartaoInclusaoLancamento(CartaoFidelidade card, 
			int qtdPontos, TipoResgate tipo) {
		boolean res = repositorioCartao.alterar(card);
		if (!res) {
			return ERRO_NA_ALTERACAO_DO_CARTAO;
		}
		LocalDateTime now = LocalDateTime.now();
		if (tipo == null) {
			res = repositorioLancamento.incluir(new LancamentoExtratoPontuacao(
					card.getNumeroFidelidade(), qtdPontos, now));
		} else {
			res = repositorioLancamento.incluir(new LancamentoExtratoResgate(card.getNumeroFidelidade(), qtdPontos, now));			
		}		
		if (!res) {
			return ERRO_AO_INCLUIR_LANCAMENTO;
		}
		return null;
	}
	
	public String pontuar(long numeroCartao, int qtdPontos) {
		if (qtdPontos <= 0 ) {
			return QUANTIDADE_DE_PONTOS_MENOR_QUE_ZERO;
		}		
		CartaoFidelidade card = repositorioCartao.buscar(Long.toString(numeroCartao));		
		if(card == null) {
			return CARTAO_INEXISTENTE;
		}		
		card.creditar(qtdPontos);
		return processarAlteracaoCartaoInclusaoLancamento(card, 
				qtdPontos, null);
	}
	
	public String resgatar(long numeroCartao, int qtdPontos, TipoResgate tipo) {		
		if (qtdPontos <= 0) {
			return QUANTIDADE_DE_PONTOS_MENOR_QUE_ZERO;
		}		
	    CartaoFidelidade card = repositorioCartao.buscar(Long.toString(numeroCartao));
	    if (card == null) {
	        return CARTAO_INEXISTENTE;
	    }
	    if (card.getSaldo() < qtdPontos) {
	        return "Saldo insuficiente para realizar o resgate.";
	    }	        
        card.debitar(qtdPontos);
		return processarAlteracaoCartaoInclusaoLancamento(card, 
				qtdPontos, null);
	}
	
	public CartaoFidelidade buscarCartao(String numeroCartao) {
	    CartaoFidelidade cartao = repositorioCartao.buscar(numeroCartao);
	    return cartao;
	}
	
	public RetornoConsultaExtrato consultaEntreDatas(String numeroCartao, LocalDateTime inicio, LocalDateTime fim) throws ExcecaoDadoInvalido {
		LancamentoExtrato[] lancamentos = null;
        if (StringUtil.ehNuloOuBranco(numeroCartao)) {
        	throw new ExcecaoDadoInvalido("Número do cartão inválido");
        }
        
        // Validar inicio
        if (inicio == null) {
        	throw new ExcecaoDadoInvalido("Data de início inválida");
        }
        
        // Validar fim
        if (fim != null && fim.isBefore(inicio)) {
        	throw new ExcecaoDadoInvalido("Data de início inválida");
        }
        
        lancamentos = repositorioLancamento.buscarTodos();
        
        List<LancamentoExtrato> lancamentosFiltrados = Arrays.stream(lancamentos)
                .filter(lancamento -> Long.toString(lancamento.getNumeroCartao()).equals(numeroCartao))
                .filter(lancamento -> lancamento.getDataHoraLancamento().isAfter(inicio))
                .filter(lancamento -> fim == null || lancamento.getDataHoraLancamento().isBefore(fim))
                .collect(Collectors.toList());
        
        Ordenador.ordenar(lancamentosFiltrados.toArray(new LancamentoExtrato[0]));
        
        LancamentoExtrato[] lancamentosArray = lancamentosFiltrados.toArray(new LancamentoExtrato[0]);
        
        // Retornar o resultado da consulta
        return new RetornoConsultaExtrato(lancamentosArray, null);
    }

}
