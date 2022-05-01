package br.fonseca.ED.beecrowd.pilha;

import java.util.Objects;
import java.util.Scanner;

import br.fonseca.ED.estruturas.fila.FilaDinamicaDE;
import br.fonseca.ED.estruturas.pilha.PilhaDinamicaDE;

public class beecrowd_1062 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while (n != 0) {

			String linha = sc.nextLine();
			while (!Objects.equals(linha, "0")) {
				String[] array = linha.split(" ");
				FilaDinamicaDE saida = new FilaDinamicaDE();
				for (int j = 0; j < array.length; j++) {
					saida.enfileirar(Integer.parseInt(array[j]));
				}

				FilaDinamicaDE entrada = new FilaDinamicaDE();
				for (int i = 1; i <= n; i++) {
					entrada.enfileirar(i);
				}

				PilhaDinamicaDE estacao = new PilhaDinamicaDE();
				boolean possivel = true;
				while (saida.tamanho() != 0 && possivel) {

					if (estacao.tamanho() == 0 && entrada.tamanho() != 0) {
						estacao.empilhar(entrada.topo());
						entrada.desenfileirar();
					}

					if (saida.topo() == estacao.topo()) {
						saida.desenfileirar();
						estacao.desempilhar();
					} else {
						while (saida.topo() != estacao.topo() && possivel) {
							if (entrada.tamanho() == 0) {
								possivel = false;
							} else {
								estacao.empilhar(entrada.topo());
								entrada.desenfileirar();
							}
						}
					}
				}

				if (possivel) {
					System.out.print("Yes");
				} else {
					System.out.print("No");
				}

				estacao.zerar();
				saida.zerar();
				entrada.zerar();

				System.out.println();

				linha = sc.nextLine();

			}
			n = Integer.parseInt(sc.nextLine());

			if (n != 0) {
				System.out.println();
			}
		}
		System.out.println();
		sc.close();
	}
}
