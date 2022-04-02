package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.Lista;

public class MainLista {
	public static void main(String[] args) {

//        ListaString lista = new ListaString(5);
//
//        System.out.println(lista.getStrings().length);
//        System.out.println(lista.getUltimaPosLivre());
//
//        String aluno0 = "Samuel";
//        String aluno1 = "Rodrigues";
//        String aluno2 = "Yasmim";
//        String aluno3 = "Lucca";
//        String aluno4 = "Gustavo";
//        String aluno5 = "Alejandro";
//        String aluno6 = "Pedro";
//        String aluno7 = "Matheus";
//        String aluno8 = "Ronaldo";
//
//        System.out.println("Testando adição de objetos: ");
//        lista.adicionar(aluno0, aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8);
//        System.out.println(lista);
//
//        System.out.println("Testando adicionar no meio da lista: ");
//        lista.adicionar("Vicitória", 3);
//        lista.adicionar("Ricardo", 5);
//        lista.adicionar("Jadlog", 7);
//        lista.adicionar("João", 10);
//        System.out.println(lista);
//
//        System.out.println("Testando remoção do ultimo: ");
//        lista.remover(89);
//        System.out.println(lista);
//
//        System.out.println("Testando remoção do primero: ");
//        lista.remover(-89);
//        System.out.println(lista);
//
//        System.out.println("Testando adição no primeiro indice: ");
//        lista.adicionar("Quinhas", -89);
//        lista.adicionar("Lucas", -89);
//        lista.adicionar("Bararagas", -89);
//        lista.adicionar("Klemensov", -89);
//        System.out.println(lista);
//
//        System.out.println("Testando retorno de meio: ");
//        System.out.println(lista.pegarMeio());
//        System.out.println();
//
//        System.out.println("Testando troca de ultimo com primeiro: ");
//        lista.trocarFimComeco();
//        System.out.println(lista);
//        System.out.println();
//
//        System.out.println("Testando inversão de lista: ");
//        lista.inverterLista();
//        System.out.println(lista);

		Lista lista = new Lista(5);
		System.out.println(lista.getObjects().length);
		lista.adicionar(2, 2323);
		System.out.println(lista.getObjects().length);
		lista.adicionar(5, 98234);
		System.out.println(lista);
		lista.adicionar(100, 4);
		System.out.println(lista);
		lista.adicionar(50, 3);
		System.out.println(lista);
		lista.adicionar(4, 0);
		System.out.println(lista);

	}
}
