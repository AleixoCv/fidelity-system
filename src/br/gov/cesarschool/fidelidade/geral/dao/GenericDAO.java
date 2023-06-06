package br.gov.cesarschool.fidelidade.geral.dao;

import java.io.*;
import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;

public class GenericDAO {
	
	private String baseDirectory;
    private static final String EXT = ".dat";

    public void DAOGenerico(String baseDirectory){
    	this.baseDirectory = baseDirectory;
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
        	directory.mkdir();
        }
    }

    private File getArquivo(String key) {
        String directory = baseDirectory + key + EXT;
        return new File(directory);
    }
    
    private File getArquivo(Identificavel ident) {
    	String key = ident.obterChave();
        return getArquivo(key);
    }

    private void incluirAux(Identificavel ident, File arq) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(arq);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ident);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao incluir identificavel");
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean incluir(Identificavel ident) {
        File arq = getArquivo(ident);
        if (arq.exists()) {
            return false;
        }
        incluirAux(ident, arq);
        return true;
    }

    public boolean alterar(Identificavel ident) {
        File arq = getArquivo(ident);
        if (!arq.exists()) {
            return false;
        }
        if (!arq.delete()) {
            return false;
        }
        incluirAux(ident, arq);
        return true;
    }

    public Identificavel buscar(String key) {
        File arq = getArquivo(key);
        if (!arq.exists()) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(arq);
            ois = new ObjectInputStream(fis);
            return (Identificavel) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler identificavel");
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
    }
}
}

}
