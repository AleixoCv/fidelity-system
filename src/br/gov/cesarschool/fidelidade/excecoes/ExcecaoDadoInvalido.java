package br.gov.cesarschool.fidelidade.excecoes;

@SuppressWarnings("serial")
public class ExcecaoDadoInvalido extends Exception {
    public ExcecaoDadoInvalido(String message) {
        super(message);
    }
}