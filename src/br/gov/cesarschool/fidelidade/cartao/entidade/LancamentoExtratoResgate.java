public class LancamentoExtratoResgate extends LancamentoExtrato{
    private TipoResgate tipoResgate;
    
    public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, LocalDateTime dataHoraLancamento) {
        super(numeroCartao, quantidadePontos, dataHoraLancamento);
    }
    public TipoResgate getTipoResgate(){
        return tipoResgate;
    }
}