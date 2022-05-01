package br.fonseca.ED.beecrowd.lista;

import java.util.Scanner;

import br.fonseca.ED.estruturas.lista.Lista;

public class beecrowd_2174 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int nPokemons = sc.nextInt();
		Lista lista = new Lista(nPokemons);
		String atual;
		for (int i = 0; i < nPokemons; i++) {
			atual = sc.next().trim();
			if (!lista.contem(atual)) {
				lista.adicionar(atual);
			}
		}
		int restoPokemons = 151 - lista.getUltimaPosLivre();
		System.out.println("Falta(m) " + restoPokemons + " pomekon(s).");
		sc.close();
	}
}
