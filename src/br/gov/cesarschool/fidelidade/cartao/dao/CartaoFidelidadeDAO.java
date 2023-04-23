import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CartaoFidelidadeDAO {
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP 
			+ "cartao" + FILE_SEP; 
	private static final String EXT = ".dat";
	public CartaoFidelidadeDAO() {
		File diretorio = new File(DIR_BASE);
		if (!diretorio.exists()) {
			diretorio.mkdir();			
		}
	}
	private File getArquivo(long numero) {
		String nomeArq = DIR_BASE + numero + EXT;
		return new File(nomeArq);		
	}

	private void incluirAux(CartaoFidelidade cartaoFidelidade, File arq) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(arq);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(cartaoFidelidade);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao incluir CartaoFidelidade");
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}			
		} 		
	}
	public boolean incluir(CartaoFidelidade cartaoFidelidade) {
		File arq = getArquivo(cartaoFidelidade.getNumero());
		if (arq.exists()) {
			return false; 
		}
		incluirAux(cartaoFidelidade, arq);
		return true; 
	}
	public boolean alterar(CartaoFidelidade cartaoFidelidade) {
		File arq = getArquivo(cartaoFidelidade.getNumero());
		if (!arq.exists()) {
			return false; 
		}		
		if (!arq.delete()) {
			return false;
		}
		incluirAux(cartaoFidelidade, arq);
		return true;
	}
	public boolean excluir(long numero) {
		File arq = getArquivo(numero);
		if (!arq.exists()) {
			return false; 
		}				
		return arq.delete();
	}
	public CartaoFidelidade buscar(long numero) {
		File arq = getArquivo(numero);
		if (!arq.exists()) {
			return null; 
		}				
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(arq);
			ois = new ObjectInputStream(fis);
			return (CartaoFidelidade)ois.readObject(); 
		} catch (Exception e) {
			throw new RuntimeException("Erro ao ler cartao fidelidade");
		} finally {
			try {
				ois.close(); 
			} catch (Exception e) {}
			try {
				fis.close(); 
			} catch (Exception e) {}			
		}
	}
}