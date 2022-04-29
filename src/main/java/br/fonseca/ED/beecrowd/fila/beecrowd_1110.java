package br.fonseca.ED.beecrowd.fila;

import java.io.File;
import java.util.Scanner;

import br.fonseca.ED.estruturas.FilaDinamica;

public class beecrowd_1110 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("in.txt"));
		FilaDinamica fila;

		int nCartas;
		while (true) {
			fila = new FilaDinamica();
			nCartas = in.nextInt();

			if (nCartas != 0) {
				for (int contador = 1; contador <= nCartas; contador++) {
					fila.enfileirar(contador);
				}

				FilaDinamica descartadas = new FilaDinamica();
				while (fila.quantidade() >= 2) {
					descartadas.enfileirar(fila.desenfileirar());
					fila.enfileirar(fila.desenfileirar());
				}

				System.out.print("Discarded cards:");
				descartadas.print();
				System.out.print("Remaining card:");
				fila.print();
			} else
				break;
		}
	}
}