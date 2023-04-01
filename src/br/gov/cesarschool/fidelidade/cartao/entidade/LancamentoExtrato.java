import java.time.LocalDateTime;
public class LancamentoExtrato{
    private long numeroCartao;
    private int quantidadePontos;
    private long dataHoraLancamento = LocalDateTime.now();

    public LancamentoExtrato(long numeroCartao, int quantidadePontos, long dataHoraLancamento){
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
        dataHoraLancamento - LocalDateTime.now();
        return dataHoraLancamento.now(); //aqui eu estou em dúvida de now ou date
    }

}