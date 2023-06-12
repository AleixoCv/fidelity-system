package br.gov.cesarschool.fidelidade.util;

import br.gov.cesarschool.fidelidade.geral.entidade.Comparavel;

public class Ordenador {
	
	public static void ordenar(Comparavel[] array) {
		int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (array[i].comparar(array[k]) > 0) {
                    Comparavel temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
	}

}
