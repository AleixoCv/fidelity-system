package br.gov.cesarschool.fidelidade.cartao.entidade;

import java.util.Date;

import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;
import lombok.ToString;

@SuppressWarnings("serial")
public class CartaoFidelidade extends Identificavel {
	
	private long numero;
	private double saldo;
	@ToString.Exclude
	private Date dataHoraAtualizacao = new java.util.Date(); 
	
	public CartaoFidelidade(long numero) {
		this.numero = numero;
	}
	public long getNumeroFidelidade() {
    	return numero;
    }
	public double getSaldo() {
		return saldo;
	}
	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	
	public void creditar(double valor) {
		saldo = saldo + valor;
		dataHoraAtualizacao = new Date();
	}
	
	public void debitar(double valor) {	
		saldo = saldo - valor;
		dataHoraAtualizacao = new Date();
	}
	
	@Override
	public String obterChave() {
        return (this.getNumeroFidelidade()+"");
    }
	
}
