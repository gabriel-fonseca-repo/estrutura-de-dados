package br.fonseca.ED.estruturas.lista;

import java.util.Arrays;

public class Lista {

    private Object[] objects;
    private int tamanhoMax;
    private int ultimaPosLivre;

    public Lista(int tamanho) {
        this.objects = new Object[tamanho];
        this.tamanhoMax = tamanho;
        this.ultimaPosLivre = 0;
    }

    private boolean listaVazia() {
        return this.ultimaPosLivre <= 0;
    }

    private boolean listaCheia() {
        return this.ultimaPosLivre > tamanhoMax - 1;
    }

    public void adicionar(Object e, int index) {
        if (listaCheia())
            this.aumentarLista();
        if (index <= 0) {
            this.adicionarInicio(e);
            return;
        } else if (index >= this.ultimaPosLivre) {
            this.adicionar(e);
            return;
        }
        for (int i = this.ultimaPosLivre; i >= index; i--)
            this.objects[i] = this.objects[i - 1];
        this.objects[index - 1] = e;
        this.ultimaPosLivre++;
    }

    public void adicionar(Object... e) {
        for (Object i : e) {
            if (listaCheia())
                this.aumentarLista();
            this.objects[this.ultimaPosLivre] = i;
            this.ultimaPosLivre++;
        }
    }

    public void adicionar(Lista l) {
        for (Object i : l.getObjects()) {
            if (listaCheia())
                this.aumentarLista();
            this.objects[this.ultimaPosLivre] = i;
            this.ultimaPosLivre++;
        }
    }

    private void adicionarInicio(Object e) {
        if (listaCheia())
            this.aumentarLista();
        for (int i = this.ultimaPosLivre; i >= 1; i--)
            this.objects[i] = this.objects[i - 1];
        this.objects[0] = e;
        this.ultimaPosLivre++;
    }

    private void zerar() {
        int cont = 0;
        while (!this.listaVazia()) {
            this.remover(cont++);
        }
    }

    public void remover(int index) {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
            return;
        }
        if (index <= 0) {
            this.removerInicio();
            return;
        } else if (index >= this.getUltimaPosLivre()) {
            this.removerFinal();
            return;
        }
        for (int i = index; i <= this.getUltimaPosLivre(); i++)
            this.objects[i - 1] = this.objects[i];
        this.ultimaPosLivre--;
    }

    private void removerFinal() {
        if (listaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        this.ultimaPosLivre--;
    }

    private void removerInicio() {
        if (listaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        for (int i = 0; i < this.getUltimaPosLivre(); i++)
            this.objects[i] = this.objects[i + 1];
        this.ultimaPosLivre--;
    }

    private void removerRepetido() {
        Lista aux = new Lista(5);
        for (int i = 0; i < this.getUltimaPosLivre(); i++)
            if (!aux.contem((int) this.pegar(i))) aux.adicionar(this.pegar(i));
        this.zerar();
        for (int i = 0; i < aux.getUltimaPosLivre(); i++)
            this.adicionar(aux.pegar(i));
    }

    public boolean contem(Object o) {
        for (int i = 0; i < index(); i++)
            if (o.equals(this.getObjects()[i])) return true;
        return false;
    }

    public boolean contem(int inteiro) {
        for (int i = 0; i < this.getUltimaPosLivre(); i++)
            if (inteiro == (int) (this.getObjects()[i])) return true;
        return false;
    }

    public Object pegar(int index) {
        return index <= 0 ? this.objects[0] :
                index >= this.ultimaPosLivre ?
                        this.objects[this.index()] :
                        this.objects[index];
    }

    public Object pegarMeio() {
        if (this.ultimaPosLivre <= 0)
            throw new ArrayIndexOutOfBoundsException("Indice fora dos limites do array!");
        return (this.ultimaPosLivre) % 2 == 0 ?
                this.objects[((this.index()) / 2) + 1] :
                this.objects[((this.index()) / 2)];
    }

    private int index() {
        return this.ultimaPosLivre - 1;
    }

    public void trocarFimComeco() {
        int valorMin = 0;
        int valorMax = this.getTamanhoMax() + 1;
        Object ultimo = this.pegar(valorMax);
        Object primeiro = this.pegar(valorMin);
        this.substituir(0, ultimo);
        this.substituir(this.index(), primeiro);
    }

    public void substituir(int index, Object o) {
        this.objects[index] = o;
    }

    public void inverterLista() {
        Lista listaAux = new Lista(5);
        for (int i = (this.index()); i >= 0; i--) {
            listaAux.adicionar(this.objects[i]);
        }
        this.objects = Arrays.copyOf(listaAux.objects, this.tamanhoMax);
    }

    private void aumentarLista() {
        Object[] novoArray = new Object[this.tamanhoMax * 2];
        for (int i = 0; i < this.objects.length; i++)
            novoArray[i] = this.objects[i];
        this.tamanhoMax = this.tamanhoMax * 2;
        this.objects = novoArray;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.ultimaPosLivre; i++)
            str.append(String.format("INDEX: %d POS: %d Objeto: %s \n", i, (i + 1), this.objects[i]));
        str.append(String.format("Ultimo INDEX Livre: %d \n", this.ultimaPosLivre));
        return str.toString();
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int getTamanhoMax() {
        return tamanhoMax;
    }

    public void setTamanhoMax(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    public int getUltimaPosLivre() {
        return ultimaPosLivre;
    }

    public void setUltimaPosLivre(int ultimaPosLivre) {
        this.ultimaPosLivre = ultimaPosLivre;
    }
}