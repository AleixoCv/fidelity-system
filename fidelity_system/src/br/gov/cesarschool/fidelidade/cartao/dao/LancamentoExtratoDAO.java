package br.gov.cesarschool.fidelidade.cartao.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtratoPontuacao;
import br.gov.cesarschool.fidelidade.cartao.entidade.LancamentoExtratoResgate;

public class LancamentoExtratoDAO {
	
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "lancamento" + FILE_SEP;
	private static final String EXT = ".dat";
	
	public LancamentoExtratoDAO() {
		File diretorio = new File(DIR_BASE);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
	}
	
	private File getArquivo(long numero, String tipo) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		String chaveLancamento = tipo + numero + timestamp; 
        String nomeArq = DIR_BASE + chaveLancamento + EXT;
        return new File(nomeArq);
    }

	private void incluirAux(LancamentoExtrato extrato, String tipo) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File arq = getArquivo(extrato.getNumeroCartao(), tipo);
		try {
			fos = new FileOutputStream(arq);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(extrato);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao incluir lan�amento");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}			
		}
	}
	
	public boolean incluir(LancamentoExtratoPontuacao pontuacao) {
        incluirAux(pontuacao, "P");
		return true;
	}
	
	public boolean incluir(LancamentoExtratoResgate resgate) {
		incluirAux(resgate, "R");
		return true; 
	}
}
