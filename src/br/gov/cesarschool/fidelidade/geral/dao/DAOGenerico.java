package br.gov.cesarschool.fidelidade.geral.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.gov.cesarschool.fidelidade.geral.entidade.Identificavel;

public class DAOGenerico<T extends Identificavel> {
    private String baseDirectory;
    private static final String EXT = ".dat";

    public DAOGenerico(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        File directory = new File(this.baseDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private File getArquivo(String key) {
        String directory = baseDirectory + key + EXT;
        return new File(directory);
    }

    private File getArquivo(T ident) {
        String key = ident.obterChave();
        return getArquivo(key);
    }

    private void incluirAux(T ident, File arq) {
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

    public boolean incluir(T ident) {
        File arq = getArquivo(ident);
        if (arq.exists()) {
            return false;
        }
        incluirAux(ident, arq);
        return true;
    }

    public boolean alterar(T ident) {
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

    @SuppressWarnings("unchecked")
	public T buscar(String key) {
        File arq = getArquivo(key);
        if (!arq.exists()) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(arq);
            ois = new ObjectInputStream(fis);
            return (T) ois.readObject();
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

    @SuppressWarnings("unchecked")
	public T[] buscarTodos() {
        File directory = new File(baseDirectory);

        if (!directory.exists()) {
            return null;
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".dat"));

            if (files.length == 0) {
                return (T[]) new Identificavel[0];
            }

            T[] ident = (T[]) new Identificavel[files.length];

            int cont = 0;

            for (File file : files) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                ident[cont] = (T) ois.readObject();

                cont += 1;
            }
            return ident;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler chave" + e.getMessage());
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