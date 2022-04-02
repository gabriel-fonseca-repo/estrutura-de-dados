package br.fonseca.ED.estruturas;

public class Pilha {

    private Object[] objects;
    private int tamanhoMax;
    private int ultimaPosLivre;

    public Pilha(int tamanho) {
        this.objects = new Object[tamanho];
        this.tamanhoMax = tamanho;
        this.ultimaPosLivre = 0;
    }

    public Object pegarUltimo() {
        return this.objects[this.ultimaPosLivre - 1];
    }

    private boolean pilhaVazia() {
        return this.ultimaPosLivre <= 0;
    }

    private boolean pilhaCheia() {
        return this.ultimaPosLivre > tamanhoMax - 1;
    }

    public int quantidade() {
        return this.ultimaPosLivre;
    }

    public Object top() {
        return this.ultimaPosLivre > 0 ? this.objects[this.ultimaPosLivre - 1] : this.objects[0];
    }

    public void zerarPilha() {
        while (!this.pilhaVazia()) {
            this.desempilhar();
        }
    }

    public void eliminarMaiorMenor() {
        Pilha pilhaAux1 = new Pilha(5);
        int menor = (int) this.top();
        int maior = (int) this.top();
        int valor;
        while (!this.pilhaVazia()) {
            valor = (int) this.desempilhar();
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
            pilhaAux1.empilhar(valor);
        }
        while (!pilhaAux1.pilhaVazia()) {
            valor = (int) pilhaAux1.desempilhar();
            if (valor != maior && valor != menor) this.empilhar(valor);
        }
    }

    public boolean expressao(String expressao) {
        Pilha pilha = new Pilha(5);
        for (int i = 0; i < expressao.length(); i++) {
            switch (expressao.charAt(i)) {
                case '(':
                    pilha.empilhar(')');
                    break;
                case '[':
                    pilha.empilhar(']');
                    break;
                case '{':
                    pilha.empilhar('}');
                    break;
                case ')':
                    if (pilha.pilhaVazia() || (char) pilha.desempilhar() != ')')
                        return false;
                    break;
                case ']':
                    if (pilha.pilhaVazia() || (char) pilha.desempilhar() != ']')
                        return false;
                    break;
                case '}':
                    if (pilha.pilhaVazia() || (char) pilha.desempilhar() != '}')
                        return false;
                    break;
            }
        }
        return pilha.pilhaVazia();
    }

    public boolean palindromo(String str) {
        Pilha caracteres = new Pilha(str.length());
        for (int i = 0; i < str.length(); i++) {
            caracteres.empilhar(str.charAt(i));
        }
        StringBuilder strReversa = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            strReversa.append(caracteres.desempilhar());
        }
        return strReversa.toString().equals(str);
    }

    public void empilhar(Object... e) {
        for (Object i : e) {
            if (pilhaCheia())
                this.aumentarPilha();
            this.objects[this.ultimaPosLivre] = i;
            this.ultimaPosLivre++;
        }
    }

    public Object desempilhar() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        Object obj = this.objects[this.ultimaPosLivre - 1];
        this.ultimaPosLivre--;
        return obj;
    }

    public void inverter() {
        Pilha pAux = new Pilha(this.tamanhoMax);
        int posAux = this.ultimaPosLivre;
        while (!this.pilhaVazia())
            pAux.empilhar(this.desempilhar());
        this.ultimaPosLivre = posAux;
        this.objects = pAux.objects;
    }

    private void aumentarPilha() {
        Object[] novoArray = new Object[this.tamanhoMax * 2];
        for (int i = 0; i < this.objects.length; i++)
            novoArray[i] = this.objects[i];
        this.tamanhoMax = this.tamanhoMax * 2;
        this.objects = novoArray;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.ultimaPosLivre; i++) {
            str.append(String.format("INDEX: %d POS: %d %s \n", i, (i + 1), this.objects[i]));
        }
        str.append(String.format("Último INDEX Livre: %d \n", this.ultimaPosLivre));
        return str.toString();
    }
}