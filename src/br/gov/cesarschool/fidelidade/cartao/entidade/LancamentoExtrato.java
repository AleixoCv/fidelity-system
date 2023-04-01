import java.util.DateTime
public class LancamentoExtrato{
    private long numeroCartao;
    private int quantidadePontos;
    private DateTime dataHoraLancamento;

    public LancamentoExtrato(long numeroCartao, int quantidadePontos, DateTime dataHoraLancamento){
        this.numeroCartao = numeroCartao;
        this.quantidadePontos = quantidadePontos;
        this.dataHoraLancamento = dataHoraLancamento;
    }
    
    public long getNumeroCartao(){
        return numeroCartao;
    }
    public long getQuantidadePontos(){
        return quantidadePontos;
    }
    public long getDataHoraLancamento(){
        return dataHoraLancamento.Now(); //aqui eu estou em dúvida de now ou date
    }

}