package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.LinkedList;

public class MainLinkedList {
	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		lista.adicionar(17);
		lista.adicionar(13);
		lista.adicionar(12);
		lista.adicionar(45);
		lista.adicionar(65);
		lista.adicionar(0);
		lista.adicionar(99);

		lista.adicionarInicio(999);

		System.out.print(lista);
		System.out.println();

		lista.eliminarPrimeiro();

		System.out.print(lista);
		System.out.println();

		System.out.println(lista.imprimirEsquerdaDireita());
		System.out.println();

		lista.imprimirListaAoContrario();

	}
}
