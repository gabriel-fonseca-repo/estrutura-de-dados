package br.fonseca.testes;

import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner dado = new Scanner(System.in);
		Fila linhaA = new Fila();
		Pilha estacao = new Pilha();

		int n = Integer.parseInt(dado.nextLine());

		while (n != 0) {
			String linha = dado.nextLine();
			while (!Objects.equals(linha, "0")) {
				for (int i = 1; i <= n; i++) {
					linhaA.enqueue(i);
				}

				boolean possivel = true;
				String[] vagoesB = linha.split(" ");
				Fila linhaB = new Fila();
				for (int i = 0; i < vagoesB.length; i++) {
					linhaB.enqueue(Integer.parseInt(vagoesB[i]));
				}

				while (linhaB.size() != 0 && possivel) {
					if (estacao.size() == 0) {
						estacao.push(linhaA.front());
						linhaA.dequeue();
					}
					while (estacao.top() != linhaB.front() && possivel) {
						if (linhaA.size() != 0) {
							estacao.push(linhaA.front());
							linhaA.dequeue();
						} else {
							possivel = false;
						}
					}
					if (possivel) {
						estacao.pop();
						linhaB.dequeue();
					}
				}
				if (possivel) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
				linha = dado.nextLine();
			}
			System.out.println();
			n = Integer.parseInt(dado.nextLine());
		}
		dado.close();
	}
}

class Fila {
	private int contador = 0;
	Node primeiro = null;
	Node ultimo = null;

	public int size() {
		return contador;
	}

	public void enqueue(int elemento) { // o elemento novo sempre vai pra última posição
		Node novo = new Node(elemento);
		if (primeiro == null) {
			primeiro = novo;
			ultimo = novo;
		} else {
			ultimo.proximo = novo;
			novo.anterior = ultimo;
			ultimo = novo;
		}
		contador++;

	}

	public void dequeue() { // o primeiro sempre será o removido para ser atendido
		if (size() > 2) {
			primeiro.proximo.anterior = null;
			primeiro = primeiro.proximo;
		} else if (size() == 2) {
			primeiro.proximo.anterior = null;
			primeiro = primeiro.proximo;
			ultimo = primeiro;
		} else {
			primeiro = null;
			ultimo = null;
		}

		contador--;
	}

	public int front() { // o get sempre irá pegar o primeiro da fila para ser atendido
		return primeiro.dado;
	}
}

class Pilha {

	private int contador = 0;
	Node primeiro = null;
	Node ultimo = null;

	public int size() {
		return contador;
	}

	public void push(int elemento) { // adiciona no final
		Node novo = new Node(elemento);
		if (primeiro == null) {
			primeiro = novo;
			ultimo = novo;
		} else {
			ultimo.proximo = novo;
			novo.anterior = ultimo;
			ultimo = novo;
		}
		contador++;
	}

	public void pop() { // o último sempre será removido primeiro
		if (size() > 1) {
			ultimo = ultimo.anterior;
			ultimo.proximo = null;
		} else {
			primeiro = null;
			ultimo = null;
		}

		contador--;
	}

	public int top() {
		return ultimo.dado;
	}
}

class Node {

	public int dado;
	public Node proximo;
	public Node anterior;

	Node(int dado) {
		this.dado = dado;
		this.proximo = null;
		this.anterior = null;
	}

}