package br.gov.cesarschool.fidelidade.cartao.entidade;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class LancamentoExtratoPontuacao extends LancamentoExtrato{

	public LancamentoExtratoPontuacao(long numeroCartao, double quantidadePontos, LocalDateTime dataHoraLancamento) {
		super(numeroCartao, quantidadePontos, dataHoraLancamento);
	}

	@Override
	public String obterChave() {
		return (this.getNumeroCartao()+"");
	}

	@Override
	public String getIdentificadorTipo() {
		return "P";
	}
	
}
