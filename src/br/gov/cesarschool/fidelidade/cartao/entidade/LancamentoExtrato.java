import java.time.LocalDateTime;
public class LancamentoExtrato{
	
    private long numeroCartao;
    private int quantidadePontos;
    private LocalDateTime dataHoraLancamento;
    
	public long getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public int getQuantidadePontos() {
		return quantidadePontos;
	}
	public void setQuantidadePontos(int quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}
	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	public void setDataHoraLancamento(LocalDateTime dataHoraLancamento) {
		this.dataHoraLancamento = dataHoraLancamento;
	}

}