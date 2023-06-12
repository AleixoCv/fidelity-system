package br.gov.cesarschool.fidelidade.cartao.relatorios;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.fidelidade.cartao.entidade.RetornoConsultaExtrato;
import br.gov.cesarschool.fidelidade.cartao.negocio.CartaoFidelidadeMediator;
import br.gov.cesarschool.fidelidade.util.ExcecaoDadoInvalido;

public class RelatorioExtrato {
	private CartaoFidelidadeMediator cartaoFidelidadeMediator;

    public void gerarRelatorioExtratos(String numeroCartao, LocalDateTime inicio, LocalDateTime fim) {
    	try {
    		RetornoConsultaExtrato retorno = cartaoFidelidadeMediator.consultaEntreDatas(numeroCartao, inicio, fim);
    		
            LancamentoExtrato[] lancamentos = retorno.getLancamentos();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DecimalFormat decimalFormat = new DecimalFormat("##,###.00");

            for (LancamentoExtrato lancamento : lancamentos) {
                String dataHora = dateFormat.format(lancamento.getDataHoraLancamento());
                String valor = decimalFormat.format(lancamento.getquantidadePontos());
                String tipo = lancamento.getIdentificadorTipo();

                String relatorio = dataHora + " - " + valor + " - " + tipo;
                System.out.println(relatorio);
            }
            
    	}catch (ExcecaoDadoInvalido e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        RelatorioExtrato relatorioExtrato = new RelatorioExtrato();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Número do cartão fidelidade: ");
        String numeroCartao = scanner.nextLine();

        System.out.print("Data e hora de início (formato dd/MM/yyyy HH:mm:ss): ");
        String inicioStr = scanner.nextLine();
        LocalDateTime inicio = LocalDateTime.parse(inicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        System.out.print("Data e hora de fim (formato dd/MM/yyyy HH:mm:ss): ");
        String fimStr = scanner.nextLine();
        LocalDateTime fim = LocalDateTime.parse(fimStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        scanner.close();

        relatorioExtrato.gerarRelatorioExtratos(numeroCartao, inicio, fim);
    }
}
