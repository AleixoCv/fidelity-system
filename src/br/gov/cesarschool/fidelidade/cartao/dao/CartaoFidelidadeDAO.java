public class CartaoFIdelidadeDAO extends CartaoFidelidade{

    public boolean incluir(CartaoFidelidade cartao){
        return false;
    }
    
    public boolean alterar(CartaoFidelidade cartao){
        return false;
    }

    public CartaoFidelidade buscar(long numero){
        return null;
    }
}