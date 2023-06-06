package br.gov.cesarschool.fidelidade.cartao.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;


public abstract class LancamentoExtrato extends Identificavel{
    private static final String EXT = ".dat";
    private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "lancamento" + FILE_SEP;
	private long numeroCartao;
	private double quantidadePontos;
	private LocalDateTime dataHoraLancamento = LocalDateTime.now();
	
	public LancamentoExtrato(long numeroCartao, double quantidadePontos, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCartao = numeroCartao;
		this.quantidadePontos = quantidadePontos;
		this.dataHoraLancamento = dataHoraLancamento;
	}
	
	public String obterChave(String tipo) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		String chaveLancamento = tipo + this.getNumeroCartao() + timestamp;
		String chave = DIR_BASE + chaveLancamento + EXT;
		return chave;
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

}
