package br.fonseca.testes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Main2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String l;
        String[] linhaSplit;
        int N, atual, primeiroLinha;
        boolean firstTest = true;
        while (!(l = in.readLine()).equals("0")) {
            N = Integer.parseInt(l);
            if (firstTest) {
                firstTest = false;
            } else {
                out.println();
            }
            while (!(l = in.readLine()).equals("0")) {
                Stack<Integer> pilha = new Stack<>();
                linhaSplit = l.split("\\s");
                atual = 0;
                primeiroLinha = Integer.parseInt(linhaSplit[atual]);
                for (int i = 1; i <= N; i++) {
                    pilha.push(i);

                    while (!pilha.isEmpty() && primeiroLinha == pilha.lastElement()) {
                        if (++atual < N) {
                            primeiroLinha = Integer.parseInt(linhaSplit[atual]);
                        }
                        pilha.pop();
                    }
                }
                out.println(pilha.isEmpty() ? "Yes" : "No");
            }
        }
        out.println();
        out.close();
    }

}