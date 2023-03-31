// Classe: LancamentoExtratoResgate, deve herdar de LancamentoExtrato
// Pacote: br.gov.cesarschool.poo.fidelidade.cartao.negocio
// Atributos: os herdados e...
// • tipoResgate – br.gov.cesarschool.poo.fidelidade.cartao.negocio.TipoResgate
// Construtor: deve inicializar todos os atributos.
// Métodos: get público para tipoResgate.
public class LancamentoExtratoResgate extends LancamentoExtrato{
    private TipoResgate tipoResgate;
    
    public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, DateTime dataHoraLancamento) {
        super(numeroCartao, quantidadePontos, dataHoraLancamento);
    }
    public TipoResgate getTipoResgate(){
        return tipoResgate;
    }
}