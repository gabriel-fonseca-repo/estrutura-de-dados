package br.fonseca.ED.algoritmos;

public class Recursividade {

    public static int cont = 0;

    public static void main(String[] args) {
        System.out.println(fib(25));
    }

    public static int fib(int a) {
        System.out.println(cont++);
        return a == 1 ? 1 : a == 0 ? 0 : fib(a-1) + fib(a-2);
    }

    public static int fatorial(int n) {
        return n == 1 ? 1 : (n * fatorial(n-1));
    }

    public static int mdc(int a, int b) {
        return b == 0 ? a : mdc(b, (a%b));
    }
}