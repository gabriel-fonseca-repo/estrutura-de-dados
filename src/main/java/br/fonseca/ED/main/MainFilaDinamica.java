package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.FilaDinamica;

public class MainFilaDinamica {
	public static void main(String[] args) {
		FilaDinamica fila = new FilaDinamica();

		fila.enqueue(1, 2, 3, 4, 5, 6, 7, 8, 9);

		System.out.println(fila);
		int i = 0;
		while (i < 4) {
			fila.dequeue();
			i++;
		}

		System.out.println(fila);

	}
}
