package br.gov.cesarschool.fidelidade.cartao.entidade;

import java.time.LocalDateTime;

import br.gov.cesarschool.fidelidade.geral.entidade.Comparavel;
import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;
import lombok.ToString;

@SuppressWarnings("serial")
public abstract class LancamentoExtrato extends Identificavel implements Comparavel{
	private long numeroCartao;
	private double quantidadePontos;
	@ToString.Exclude
	private LocalDateTime dataHoraLancamento = LocalDateTime.now();
	
	public LancamentoExtrato(long numeroCartao, double quantidadePontos, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCartao = numeroCartao;
		this.quantidadePontos = quantidadePontos;
		this.dataHoraLancamento = dataHoraLancamento;
	}
		
	public long getNumeroCartao() {
		return numeroCartao;
	}
	
	public double getquantidadePontos() {
		return quantidadePontos;
	}
	
	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	
	public abstract String getIdentificadorTipo();
	
	@Override
	public int comparar(Comparavel comparavel) {
		LancamentoExtrato lancamentoComp = (LancamentoExtrato)comparavel;
		
		if(this.getDataHoraLancamento().isBefore(lancamentoComp.getDataHoraLancamento())) {
			return 1;
		}else if(this.getDataHoraLancamento().isAfter(lancamentoComp.getDataHoraLancamento())) {
			return -1;
		}else{
			return 0;
		}

	}

}
