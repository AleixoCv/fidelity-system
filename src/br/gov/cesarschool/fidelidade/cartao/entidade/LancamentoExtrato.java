import java.time.LocalDateTime;
public class LancamentoExtrato{
	
    private long numeroCartao;
    private int quantidadePontos;
    private LocalDateTime dataHoraLancamento;
    
    /* Alterei para Getters e Setters individuais
     * Manter os metodos desta forma ajuda a fazer alterações na classe no futuro
     * Já que pode existir a necessidade de alterar apenas um único elemento, ou alterar alguns, porém nao todos
     * E no caso de ser necessario alterar todos os valores teremos um metodo para cada elemento que pode ser utilizado*/
    
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