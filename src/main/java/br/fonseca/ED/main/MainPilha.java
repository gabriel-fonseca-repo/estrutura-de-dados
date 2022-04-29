package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.pilha.Pilha;
import br.fonseca.ED.modelo.Aluno;

public class MainPilha {
    public static void main(String[] args) {

        Pilha pilha = new Pilha(5);
        Aluno aluno0 = new Aluno("Samuel");
        Aluno aluno1 = new Aluno("Rodrigues");
        Aluno aluno2 = new Aluno("Yasmim");
        Aluno aluno3 = new Aluno("Lucca");
        Aluno aluno4 = new Aluno("Gustavo");
        Aluno aluno5 = new Aluno("Alejandro");
        Aluno aluno6 = new Aluno("Pedro");
        Aluno aluno7 = new Aluno("Matheus");
        Aluno aluno8 = new Aluno("Ronaldo");

        System.out.println("Testando empilhagem de objetos: ");
        pilha.empilhar(aluno0, aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8);
        System.out.println(pilha);

        System.out.println("Testando adicionar na pilha: ");
        pilha.empilhar(new Aluno("Vicitória"),
                new Aluno("Ricardo"),
                new Aluno("Alberto"),
                new Aluno("João"));
        System.out.println(pilha);

        System.out.println("Testando remoção do ultimo (Desempilhar): ");
        Aluno alunoTeste1 = (Aluno) pilha.desempilhar();
        Aluno alunoTeste2 = (Aluno) pilha.desempilhar();
        System.out.println(alunoTeste1 + "\n" + alunoTeste2);
        System.out.println();
        System.out.println(pilha);

        System.out.println("Testando método pegarUltimo e quantidade: ");
        System.out.println(pilha.pegarUltimo());
        System.out.println(pilha.quantidade());
        System.out.println();

        System.out.println("Testando método inverter: ");
        System.out.println("Antes de inverter");
        System.out.println(pilha);
        pilha.inverter();
        System.out.println("Após inverter");
        System.out.println(pilha);

        System.out.println("Testando método de palíndromo: ");
        System.out.println(pilha.palindromo("ABBA"));
        System.out.println();

        System.out.println("Testando método expressão: ");
        System.out.println(pilha.expressao("(awdoiawodkapo)"));

        pilha.zerarPilha();

        pilha.empilhar(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Pilha original: \n" + pilha);
        pilha.eliminarMaiorMenor();
        System.out.println("Pilha após eliminar maior e menor: \n" + pilha);

        System.out.println("Testando método de expressão:");
        System.out.println("A expressão (awpdokawpokdpokaw) é " + pilha.expressao("(awpdokawpokdpokaw)"));
        System.out.println("A expressão (awpdokawpokdpok}aw é " + pilha.expressao("(awpdokawpokdpok}aw"));
        System.out.println("A expressão (awpdo{kawpokdpok}aw) é " + pilha.expressao("(awpdo{kawpokdpok}aw)"));

    }
}
