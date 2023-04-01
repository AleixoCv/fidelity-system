import java.util.Date;

public class CartaoFidelidade {

    private long numero;
    private double saldo;
    private Date dataHoraAtualizacao;

    public void creditar(double valor) {
        setSaldo(getSaldo() + valor); 
        setDataHoraAtualizacao(new Date());;
    }

    public void debitar(double valor) {
        setSaldo(getSaldo() - valor);
        setDataHoraAtualizacao(new Date());;
    }

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

    
}
