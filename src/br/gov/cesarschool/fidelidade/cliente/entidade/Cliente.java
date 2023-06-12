package br.gov.cesarschool.fidelidade.cliente.entidade;

import java.util.Calendar;
import java.util.Date;

import br.gov.cesarschool.fidelidade.geral.entidade.Comparavel;
import br.gov.cesarschool.fidelidade.geral.entidade.Endereco;
import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;
import br.gov.cesarschool.fidelidade.geral.entidade.Sexo;
import lombok.ToString;

@SuppressWarnings("serial")
public class Cliente extends Identificavel implements Comparavel {
	private String cpf;
	private	String nomeCompleto;
	private Sexo sexo;
	@ToString.Exclude
	private Date dataNascimento;
	private double renda;
	private Endereco endereco;
	
	 public Cliente(String cpf, String nomeCompleto, Sexo sexo, Date dataNascimento, double renda, Endereco endereco) {
	        this.cpf = cpf;
	        this.nomeCompleto = nomeCompleto;
	        this.sexo = sexo;
	        this.dataNascimento = dataNascimento;
	        this.renda = renda;
	        this.endereco = endereco;
	 }
	 
	 public String getCpf() {
	        return cpf;
	    }

	    public String getNomeCompleto() {
	        return nomeCompleto;
	    }

	    public Sexo getSexo() {
	        return sexo;
	    }

	    public Date getDataNascimento() {
	        return dataNascimento;
	    }

	    public double getRenda() {
	        return renda;
	    }

	    public Endereco getEndereco() {
	        return endereco;
	    }

	    public void setNomeCompleto(String nomeCompleto) {
	        this.nomeCompleto = nomeCompleto;
	    }

	    public void setSexo(Sexo sexo) {
	        this.sexo = sexo;
	    }

	    public void setDataNascimento(Date dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }

	    public void setRenda(double renda) {
	        this.renda = renda;
	    }

	    public void setEndereco(Endereco endereco) {
	        this.endereco = endereco;
	    }
	    
	    public int obterIdade() {
	        Calendar hoje = Calendar.getInstance();
	        Calendar dataNascimento = Calendar.getInstance();
	        dataNascimento.setTime(this.dataNascimento);
	        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
	        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH) || (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH))) {
	            idade--;
	        }
	        return idade;
	    }

		@Override
		public String obterChave() {
			return (this.getCpf()+"");
		}

		@Override
		public int comparar(Comparavel comparavel) {
			Cliente clienteComp = (Cliente)comparavel;
			int result = this.getNomeCompleto().compareTo(clienteComp.getNomeCompleto());
			
			if(result > 0) {
				return -1;
			}else if(result == 0) {
				return 0;
			}else{
				return 1;
			}
	
		}
}
