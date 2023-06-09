package br.gov.cesarschool.fidelidade.geral.entidade;

import java.io.Serializable;

public enum Sexo implements Serializable {
	FEMININO(1, "Feminino"),
	MASCULINO(2, "Masculino");
	
	private int codigo;
	private String descricao;
	
	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}	
}
