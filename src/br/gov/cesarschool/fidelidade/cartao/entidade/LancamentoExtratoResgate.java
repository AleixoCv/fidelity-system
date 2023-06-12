package br.gov.cesarschool.fidelidade.cartao.entidade;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class LancamentoExtratoResgate extends LancamentoExtrato {

	public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, LocalDateTime dataHoraLancamento) {
	    super(numeroCartao, quantidadePontos, dataHoraLancamento);
	}
	
	@Override
	public String obterChave() {
		return (this.getNumeroCartao()+"");
	}

	@Override
	public String getIdentificadorTipo() {
		return "R";
	}
}
