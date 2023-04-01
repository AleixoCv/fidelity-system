import br.gov.cesarschool.poo.fidelidade.geral.entidade.Endereco;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.Sexo;
import java.util.Date;

public class Cliente {
    private String cpf;
    private String nomeCompleto;
    private Sexo sexo;
    private Date dataNascimento;
    private double renda;
    private Endereco endereco;
   
    /* Alterei para Getters e Setters individuais
     * Manter os metodos desta forma ajuda a fazer alterações na classe no futuro
     * Já que pode existir a necessidade de alterar apenas um único elemento, ou alterar alguns, porém nao todos
     * E no caso de ser necessario alterar todos os valores teremos um metodo para cada elemento que pode ser utilizado*/
    
    public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	@SuppressWarnings("deprecation")
	public int obterIdade() {
        Date dataAtual = new Date();
        int idade = dataAtual.getYear() - dataNascimento.getYear();
        if (dataAtual.getMonth() < dataNascimento.getMonth()
                || (dataAtual.getMonth() == dataNascimento.getMonth() 
                && dataAtual.getDate() < dataNascimento.getDate())) {
        	
            idade--;
        }
        return idade;
    }
}    