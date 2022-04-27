package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.PilhaDinamica;

public class MainPilhaDinamica {

	public static void main(String[] args) {
		PilhaDinamica pilha = new PilhaDinamica();

		pilha.push(1, 2, 3, 4, 5, 6, 7, 8, 9);

		System.out.println(pilha);
		int i = 0;
		while (i < 4) {
			pilha.pop();
			i++;
		}

		System.out.println(pilha);

		System.out.println(pilha.peek());
	}

}
