package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.FilaDinamica;

public class MainFilaDinamica {
	public static void main(String[] args) {
		FilaDinamica fila = new FilaDinamica();

		System.out.println(fila);
		int i = 0;
		while (i < 4) {
			fila.desenfileirar();
			i++;
		}

		System.out.println(fila);

	}
}
