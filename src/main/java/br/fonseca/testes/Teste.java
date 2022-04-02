package br.fonseca.testes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import br.fonseca.ED.estruturas.ListaString;

class Teste {
	public static void main(String[] args) throws IOException {
		File input = new File("in.txt");
		Scanner sc = new Scanner(input);
		int nTestes = Integer.parseInt(sc.nextLine());

		ListaString listaNomes = new ListaString(nTestes);

		while (sc.hasNextLine()) {
			String nome = sc.nextLine();
			listaNomes.adicionar(nome);
		}
		listaNomes.sortPorTamanho();

		int tamanhoString = 0;
		StringBuilder bdr = new StringBuilder("");

		ListaString listaAnterior = new ListaString(5);

		for (int i = 0; i < listaNomes.size(); i++) {
			ListaString listaAux = new ListaString(5);
			for (int j = 0; j < listaNomes.size(); j++) {
				if (listaNomes.pegar(j).length() > tamanhoString && !(listaAnterior.contem(listaAux.pegar(j)))) {
					tamanhoString = listaNomes.pegar(j).length();
					listaAux.adicionar(listaNomes.pegar(j));
				}
			}
			for (String u : listaAux.getStrings()) {
				bdr.append(u).append(", ");
			}
			listaAnterior = listaAux;
			tamanhoString = 0;
			System.out.println(bdr);
		}
		sc.close();
	}
}