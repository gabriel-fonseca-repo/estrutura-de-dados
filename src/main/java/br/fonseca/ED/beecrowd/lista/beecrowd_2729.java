package br.fonseca.ED.beecrowd.lista;

import java.io.File;
import java.util.Scanner;

import br.fonseca.ED.estruturas.lista.ListaOrdenada;

public class beecrowd_2729 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("in.txt"));
		int n = Integer.parseInt(sc.nextLine());
		ListaOrdenada listaStrings = new ListaOrdenada();

		for (int i = 0; i < n; i++) {
			listaStrings.clear();
			String lista = sc.nextLine();
			String[] words = lista.split(" ");
			for (int j = 0; j < words.length; j++) {
				listaStrings.adicionar(words[j]);
			}
			listaStrings.printBEECROWD();
		}

		sc.close();
	}
}
