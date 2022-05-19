package br.fonseca.ED.beecrowd.pilha;

import java.util.Scanner;

public class beecrowd_1068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = "";
		while (sc.hasNextLine()) {
			string = sc.nextLine();
			Pilha pilha = new Pilha(string.length());
			for (int i = 0; i < string.length(); i++) {
				char atual = string.charAt(i);
				if (possui(atual)) {
					if (encher(pilha.topoX(), atual)) {
						pilha.desempilhar();
					} else {
						pilha.empilhar(atual);
					}
				}
			}
			if (pilha.topoX() != ' ') {
				System.out.println("incorrect");
			} else {
				System.out.println("correct");
			}

		}
		sc.close();
	}

	public static class Pilha {
		private int topo;
		private char[] pilhaDeChar;

		public Pilha(int n) {
			this.topo = 0;
			this.pilhaDeChar = new char[n];
		}

		public int topo() {
			return topo - 1;
		}

		public void empilhar(char i) {
			pilhaDeChar[topo++] = i;

		}

		public char topoX() {
			return topo == 0 ? ' ' : pilhaDeChar[topo - 1];
		}

		public void desempilhar() {
			topo--;
		}

		@Override
		public String toString() {
			String print = "";
			for (int i = 0; i < topo; i++) {
				print += pilhaDeChar[i] + " ";
			}
			return print;
		}

	}

	public static boolean possui(char c) {
		char[] agrupadores = { '{', '}', '(', ')', '[', ']' };
		for (int i = 0; i < agrupadores.length; i++) {
			if (c == agrupadores[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean encher(char c, char h) {
		if (c == '{' && h == '}' || c == '(' && h == ')' || c == '[' && h == ']') {
			return true;
		}
		return false;
	}

}
