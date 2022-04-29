package br.fonseca.ED.beecrowd.fila;

import java.io.File;
import java.util.Scanner;

import br.fonseca.ED.estruturas.fila.FilaDinamica;
import br.fonseca.ED.estruturas.fila.FilaPrioridade;

public class beecrowd_1548 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("in.txt"));

		int n = Integer.parseInt(in.nextLine());

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int m = Integer.parseInt(in.nextLine());
			FilaDinamica fd = new FilaDinamica();
			FilaPrioridade fp = new FilaPrioridade();

			String[] aux = in.nextLine().split(" ");
			for (int j = 0; j < m; j++) {
				fd.enfileirar(Integer.parseInt(aux[j]));
				fp.enfileirar(j, Integer.parseInt(aux[j]));
			}

			for (int j = 0; j < m; j++) {
				if ((int) fd.achar(j) == fp.acharPrioridade(j)) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}
		in.close();
	}
}
