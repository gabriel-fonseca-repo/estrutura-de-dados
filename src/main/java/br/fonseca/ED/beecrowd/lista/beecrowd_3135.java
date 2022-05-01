package br.fonseca.ED.beecrowd.lista;

import java.io.File;
import java.util.Scanner;

import br.fonseca.ED.estruturas.lista.Lista;
import br.fonseca.ED.estruturas.lista.ListaOrdenada;

public class beecrowd_3135 {
	public static void main(String[] args) throws Exception {
		Lista aux = new Lista(100);
		ListaOrdenada colunas = new ListaOrdenada();

		Scanner in = new Scanner(new File("in.txt"));

		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			colunas.adicionar3135(in.next());
		}

		while (colunas.tamanho() != 0) {
			for (int i = 1; i <= colunas.maiorPalavra().length(); i++) {
				if (colunas.palavraDesseTamanho(i)) {
					String palavraDesseTamanho = colunas.acharPalavraPorTamanho(i);
					aux.adicionar(palavraDesseTamanho);
					colunas.remover(palavraDesseTamanho);
				}
			}
			aux.print();
			System.out.println();
			aux.zerar();
		}
		in.close();
	}
}
