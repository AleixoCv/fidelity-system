package br.gov.cesarschool.fidelidade.geral.entidade;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Identificavel implements Serializable{

	public abstract String obterChave();

}