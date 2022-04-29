package br.fonseca.ED.beecrowd.fila;

import java.io.File;
import java.util.Scanner;

import br.fonseca.ED.estruturas.fila.FilaDinamica;

public class beecrowd_2460 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("in.txt"));
		FilaDinamica fila = new FilaDinamica();

		int n = Integer.parseInt(in.nextLine());
		String[] aux = in.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			fila.enfileirar(aux[i]);
		}

		int m = Integer.parseInt(in.nextLine());
		String[] aux2 = in.nextLine().split(" ");

		for (int i = 0; i < m; i++) {
			fila.remover(aux2[i]);
		}

		fila.printBeecrowd();

		in.close();
	}
}
