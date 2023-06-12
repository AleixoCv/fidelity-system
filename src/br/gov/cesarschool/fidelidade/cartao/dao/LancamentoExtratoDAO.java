package br.gov.cesarschool.fidelidade.cartao.dao;

import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.fidelidade.geral.dao.DAOGenerico;

public class LancamentoExtratoDAO {
	
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "lancamento" + FILE_SEP;
	
	private DAOGenerico<LancamentoExtrato> daoEncapsulado;
	
	public LancamentoExtratoDAO() {
		daoEncapsulado = new DAOGenerico<>(DIR_BASE);
	}

	public boolean incluir(LancamentoExtrato extrato) {
		return daoEncapsulado.incluir(extrato);
	}
	
	public LancamentoExtrato[] buscarTodos() {
		return daoEncapsulado.buscarTodos();
	}
	
}
