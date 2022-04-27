package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.ListaDinamicaCircular;

public class MainLinkedListCircular {
	public static void main(String[] args) {
		ListaDinamicaCircular lista = new ListaDinamicaCircular();

		System.out.println("Testando adicicao de itens normais");
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

		System.out.println("Testando remocao do primeiro item");
		lista.eliminarPrimeiro();
		System.out.print(lista);
		System.out.println();

		System.out.println("Testando impressao da esquerda pra direita");
		System.out.println(lista.imprimirEsquerdaDireita());
		System.out.println();

		System.out.println("Imprimindo a lista ao contrario");
		lista.imprimirListaAoContrario();

		System.out.println("Testando adicao de itens com indice");
		lista.adicionar(2000, 4);
		lista.adicionar(2001, -1);
		lista.adicionar(2002, 0);
		lista.adicionar(2003, 198237123);
		System.out.println(lista);

		System.out.println("Testando adicao de multiplos itens");
		lista.adicionar(123123, 123123, 1, 23232);
		System.out.println(lista);

		System.out.println("Testando remocao de itens nos extremos da lista");
		lista.remover(0);
		lista.remover(-2);
		lista.remover(-3);
		lista.remover(123123);
		System.out.println(lista);

		System.out.println("Testando remocao de itens no meio da lista");
		lista.remover(3);
		lista.remover(5);
		System.out.println(lista);

		System.out.println("Testando metodos de achar o ultimo e penultimo");
		System.out.println("Penultimo elemento: " + lista.acharPenultimo());
		System.out.println("Ultimo elemento: " + lista.acharUltimo());
		System.out.println();

		System.out.println("Testando metodos de inversao de lista referencialmente");
		lista.inverterLista();
		System.out.println(lista);

		System.out.println("Testando metodos para verificacao de itens repetidos");
		System.out.println(lista);
		System.out.println(lista.repetidos() + "\n");
		lista.remover(2);
		System.out.println(lista);
		System.out.println(lista.repetidos());

	}
}
