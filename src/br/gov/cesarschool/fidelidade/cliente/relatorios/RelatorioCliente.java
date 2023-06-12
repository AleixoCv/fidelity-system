package br.gov.cesarschool.fidelidade.cliente.relatorios;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import br.gov.cesarschool.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.fidelidade.cliente.negocio.ClienteMediator;

public class RelatorioCliente {
	private ClienteMediator clienteMediator;

    public void gerarRelatorioClientes() {
        Cliente[] clientes = clienteMediator.consultarClientesOrdenadosPorNome();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("##,###.00");

        for (Cliente cliente : clientes) {
            String nome = cliente.getNomeCompleto();
            String dataNascimento = dateFormat.format(cliente.getDataNascimento());
            String renda = decimalFormat.format(cliente.getRenda());

            String relatorio = nome + " - " + dataNascimento + " - " + renda;
            System.out.println(relatorio);
        }
    }

    public static void main(String[] args) {
        RelatorioCliente relatorioCliente = new RelatorioCliente();
        relatorioCliente.gerarRelatorioClientes();
    }
}
