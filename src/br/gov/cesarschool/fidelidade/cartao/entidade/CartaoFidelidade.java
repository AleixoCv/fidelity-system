import java.util.Date;

public class CartaoFidelidade {

    private long numero;
    private double saldo;
    private Date dataHoraAtualizacao;

	public cartaoFidelidade(long numero) {
        this.numero = numero;
		this.dataHoraAtualizacao = new Date();
    }

	public void creditar(double valor) {
        this.saldo += valor;
        this.dataHoraAtualizacao = new Date();
    }

    public void debitar(double valor) {
        this.saldo -= valor;
        this.dataHoraAtualizacao = new Date();
    }

	public long getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
    
}
