package br.fonseca.ED.main;

import br.fonseca.ED.estruturas.Fila;
import br.fonseca.ED.modelo.Aluno;

public class MainFila {
    public static void main(String[] args) {

        Fila fila = new Fila(5);
        Aluno aluno0 = new Aluno("Samuel");
        Aluno aluno1 = new Aluno("Rodrigues");
        Aluno aluno2 = new Aluno("Yasmim");
        Aluno aluno3 = new Aluno("Lucca");
        Aluno aluno4 = new Aluno("Gustavo");
        Aluno aluno5 = new Aluno("Alejandro");
        Aluno aluno6 = new Aluno("Pedro");
        Aluno aluno7 = new Aluno("Matheus");
        Aluno aluno8 = new Aluno("Ronaldo");

        System.out.println(fila.filaVazia());

        System.out.println("Testanto enfileiramento: ");
        fila.enfileirar(aluno0, aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8);
        System.out.println(fila);

        System.out.println("Testando retorno do comecoo da fila: ");
        System.out.println(fila.retornarComeco());
        System.out.println(fila.retornarComeco() + "\n");

        System.out.println("Testando desenfileiramento: ");
        fila.desenfileirar();
        fila.desenfileirar();
        fila.desenfileirar();
        System.out.println(fila);

        System.out.println("Testando quantidade: ");
        System.out.println(fila.quantidade());
        System.out.println();

        System.out.println("Testando inversao com pilha: ");
        System.out.println(fila);
        fila.inverterFilaComPilha();
        System.out.println(fila);

        System.out.println("Testando inversao com fila: ");
        System.out.println(fila);
        fila.inverterFilaComFila();
        System.out.println(fila);

        System.out.println("Testando impressao inversa: ");
        fila.imprimirFilaAoContrario();

        System.out.println("Testando remocao de cauda: ");
        fila.removerCauda(4);
        System.out.println(fila);

    }

}
