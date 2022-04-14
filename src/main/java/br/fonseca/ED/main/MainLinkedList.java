package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.LinkedList;

public class MainLinkedList {
	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		System.out.println("Testando adicição de itens normais");
		lista.adicionar(17);
		lista.adicionar(13);
		lista.adicionar(12);
		lista.adicionar(45);
		lista.adicionar(65);
		lista.adicionar(0);
		lista.adicionar(99);
		lista.adicionar(999);
		System.out.print(lista);
		System.out.println();

		System.out.println("Testando remoção do primeiro item");
		lista.eliminarPrimeiro();
		System.out.print(lista);
		System.out.println();

		System.out.println("Testando impressão da esquerda pra direita");
		System.out.println(lista.imprimirEsquerdaDireita());
		System.out.println();

		System.out.println("Imprimindo a lista ao contrário");
		lista.imprimirListaAoContrario();

		System.out.println("Testando adição de itens com índice");
		lista.adicionar(2000, 4);
		lista.adicionar(2001, -1);
		lista.adicionar(2002, 0);
		lista.adicionar(2003, 198237123);
		System.out.println(lista);

		System.out.println("Testando adição de múltiplos itens");
		lista.adicionar(123123, 123123, 1, 23232);
		System.out.println(lista);

		System.out.println("Testando remoção de itens nos extremos da lista");
		lista.remover(0);
		lista.remover(-2);
		lista.remover(-3);
		lista.remover(123123);
		System.out.println(lista);

		System.out.println("Testando remoção de itens no meio da lista");
		lista.remover(3);
		lista.remover(5);
		System.out.println(lista);

	}
}
