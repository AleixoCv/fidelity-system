package br.gov.cesarschool.fidelidade.cartao.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class RetornoConsultaExtrato {
	@Getter @Setter private LancamentoExtrato[] lancamentos;
	@Getter @Setter private String mensagemErro;
}