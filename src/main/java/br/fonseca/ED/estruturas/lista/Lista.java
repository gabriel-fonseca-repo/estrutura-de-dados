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

	public void adicionar(int index, Object obj) {
		if (arrayCheio()) {
			Object[] aux = new Object[index + 1];
			for (int i = 0; i < this.getUltimaPosLivre(); i++) {
				aux[i] = this.objects[i];
			}
			aux[index] = obj;
			this.ultimaPosLivre++;
			this.objects = aux;
		} else {
			for (int i = this.ultimaPosLivre - 1; i >= index; i++) {
				this.objects[i + 1] = this.objects[i];
			}
			this.objects[index] = obj;
			this.ultimaPosLivre++;
		}
	}

	public void adicionar(Object obj) {
		if (arrayCheio() && !contem(obj)) {
			Object[] aux = new Object[objects.length * 2];
			for (int i = 0; i < this.getUltimaPosLivre(); i++) {
				aux[i] = this.objects[i];
			}
			aux[this.ultimaPosLivre] = obj;
			this.ultimaPosLivre++;
			this.objects = aux;
		} else if (!contem(obj)) {
			this.objects[this.ultimaPosLivre] = obj;
			this.ultimaPosLivre++;
		}
	}

	public void zerar() {
		this.objects = new Object[this.getUltimaPosLivre()];
		this.ultimaPosLivre = 0;
	}

	public boolean arrayCheio() {
		return this.getUltimaPosLivre() == objects.length;
	}

	public void remove(Object obj) {
		for (int i = pegarIndice(obj); i < this.ultimaPosLivre; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.ultimaPosLivre--;
	}

	public void removerRepetido() {
		Lista aux = new Lista(5);
		for (int i = 0; i < this.getUltimaPosLivre(); i++)
			if (!aux.contem((int) this.pegar(i)))
				aux.adicionar(this.pegar(i));
		this.zerar();
		for (int i = 0; i < aux.getUltimaPosLivre(); i++)
			this.adicionar(aux.pegar(i));
	}

	public int pegarIndice(Object obj) {
		int index = 0;
		for (int i = 0; this.objects[i] != obj; i++) {
			index++;
		}
		return index;
	}

	public boolean contem(Object o) {
		for (int i = 0; i < this.ultimaPosLivre; i++) {
			if (this.objects[i].equals(o))
				return true;
		}
		return false;
	}

	public Object pegar(int index) {
		return index <= 0 ? this.objects[0]
				: index >= this.ultimaPosLivre ? this.objects[this.index()] : this.objects[index];
	}

	public Object pegarMeio() {
		if (this.ultimaPosLivre <= 0)
			throw new ArrayIndexOutOfBoundsException("Indice fora dos limites do array!");
		return (this.ultimaPosLivre) % 2 == 0 ? this.objects[((this.index()) / 2) + 1]
				: this.objects[((this.index()) / 2)];
	}

	private int index() {
		return this.ultimaPosLivre <= 0 ? this.ultimaPosLivre : this.ultimaPosLivre - 1;
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
		return this.ultimaPosLivre;
	}

	public void setUltimaPosLivre(int ultimaPosLivre) {
		this.ultimaPosLivre = ultimaPosLivre;
	}

	public void print() {
		for (int i = 0; i < this.ultimaPosLivre; i++) {
			if (i < this.ultimaPosLivre - 1) {
				System.out.print(this.objects[i] + ", ");
			} else {
				System.out.print(this.objects[i]);
			}
		}
	}

}