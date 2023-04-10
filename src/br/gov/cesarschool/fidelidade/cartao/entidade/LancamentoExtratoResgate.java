public class LancamentoExtratoResgate extends LancamentoExtrato{

	
=======
    private TipoResgate tipoResgate;
    
    public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, LocalDateTime dataHoraLancamento) {
        super(numeroCartao, quantidadePontos, dataHoraLancamento);
    }
    public TipoResgate getTipoResgate(){
        return tipoResgate;
    }
>>>>>>> 7c2b4b689b6e51636f3c0393f2107d3207a26bda
}