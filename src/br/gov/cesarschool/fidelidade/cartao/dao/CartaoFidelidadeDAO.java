package br.gov.cesarschool.fidelidade.cartao.dao;

import br.gov.cesarschool.fidelidade.cartao.entidade.CartaoFidelidade;
import br.gov.cesarschool.fidelidade.geral.dao.DAOGenerico;

public class CartaoFidelidadeDAO {
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "cartao" + FILE_SEP;
    
    private DAOGenerico<CartaoFidelidade> daoEncapsulado;

    public CartaoFidelidadeDAO() {
        daoEncapsulado = new DAOGenerico<>(DIR_BASE);
    }

    public boolean incluir(CartaoFidelidade cartao) {
        return daoEncapsulado.incluir(cartao);
    }

    public boolean alterar(CartaoFidelidade cartao) {
        return daoEncapsulado.alterar(cartao);
    }

    public CartaoFidelidade buscar(String cartao) {
        return daoEncapsulado.buscar(cartao);
    }
    
    public CartaoFidelidade[] buscarTodos() {
    	return daoEncapsulado.buscarTodos();
    }
}