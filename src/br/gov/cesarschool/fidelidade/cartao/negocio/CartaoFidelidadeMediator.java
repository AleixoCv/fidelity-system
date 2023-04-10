import java.sql.Date;

public class CartaoFidelidadeMediator {
    
    private CartaoFidelidadeDAO repositorioCartao;
    private LancamentoExtratoDAO repositorioLancamento;
    private static CartaoFidelidadeMediator instance;
    private CartaoFidelidadeMediator(){

    }

    public static CartaoFidelidadeMediator getInstance(){
        if (instance == null){
            instance = new CartaoFidelidadeMediator();
        }
        return instance;
    }

    this.repositorioCartao = new ClienteDAO();
    this.repositorioLancamento = new LancamentoExtratoDAO();

    public long gerarCartao(Cliente cliente){
        Date dataAtual = new Date();
        CartaoFidelidade cartao = new CartaoFidelidade(); 
        long id = (long) cliente.getCpf() + dataAtual.getYear() + dataAtual.getMonth() + dataAtual.getDate();
        cartao.cartaoFidelidade(id);
        repositorioCartao.incluir(cartao);

        return cartao.getNumero();
    }

    public String pontuar(long numeroCartao , double quantidadePontos){
        if (quantidadePontos <= 0){
            return "Quantidade de pontos invalida";
        }
        if (repositorioCartao.buscar(numeroCartao)){
            CartaoFidelidade cartao = repositorioCartao.buscar(numeroCartao);
        } else {
            return "Cartão não encontrado!";
        }

        
    }
}
