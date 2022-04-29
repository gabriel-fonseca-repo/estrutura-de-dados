package br.fonseca.ED.estruturas.lista;

import java.util.Arrays;

public class ListaString {

	private String[] Strings;
	private int tamanhoMax;
	private int ultimaPosLivre;

	public ListaString(int tamanho) {
		this.Strings = new String[tamanho];
		this.tamanhoMax = tamanho;
		this.ultimaPosLivre = 0;
	}

	public boolean listaVazia() {
		return this.ultimaPosLivre <= 0;
	}

	private boolean listaCheia() {
		return this.ultimaPosLivre > tamanhoMax - 1;
	}

	public void adicionar(String e, int index) {
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
			this.Strings[i] = this.Strings[i - 1];
		this.Strings[index - 1] = e;
		this.ultimaPosLivre++;
	}

	public void adicionar(String... e) {
		for (String i : e) {
			if (listaCheia())
				this.aumentarLista();
			this.Strings[this.ultimaPosLivre] = i;
			this.ultimaPosLivre++;
		}
	}

	public void adicionar(ListaString l) {
		for (String i : l.getStrings()) {
			if (listaCheia())
				this.aumentarLista();
			this.Strings[this.ultimaPosLivre] = i;
			this.ultimaPosLivre++;
		}
	}

	private void adicionarInicio(String e) {
		if (listaCheia())
			this.aumentarLista();
		for (int i = this.ultimaPosLivre; i >= 1; i--)
			this.Strings[i] = this.Strings[i - 1];
		this.Strings[0] = e;
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
			this.Strings[i - 1] = this.Strings[i];
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
			this.Strings[i] = this.Strings[i + 1];
		this.ultimaPosLivre--;
	}

	private void removerRepetido() {
		ListaString aux = new ListaString(5);
		for (int i = 0; i < this.getUltimaPosLivre(); i++)
			if (!aux.contem(this.pegar(i)))
				aux.adicionar(this.pegar(i));
		this.zerar();
		for (int i = 0; i < aux.getUltimaPosLivre(); i++)
			this.adicionar(aux.pegar(i));
	}

	public boolean contem(String o) {
		if (o == null)
			return false;
		for (int i = 0; i < index(); i++)
			if (o.equals(this.getStrings()[i]))
				return true;
		return false;
	}

	public String pegar(String o) {
		for (int i = 0; i < index(); i++)
			if (o.equals(this.getStrings()[i]))
				return this.getStrings()[i];
		return "";
	}

	public String pegar(int index) {
		if (this.ultimaPosLivre <= 0) {
			return this.Strings[0];
		}
		return index <= 0 ? this.Strings[0]
				: index >= this.ultimaPosLivre ? this.Strings[this.index()] : this.Strings[index];
	}

	public String pegarMeio() {
		if (this.ultimaPosLivre <= 0)
			throw new ArrayIndexOutOfBoundsException("Indice fora dos limites do array!");
		return (this.ultimaPosLivre) % 2 == 0 ? this.Strings[((this.index()) / 2) + 1]
				: this.Strings[((this.index()) / 2)];
	}

	private int index() {
		return this.ultimaPosLivre - 1;
	}

	public void trocarFimComeco() {
		int valorMin = 0;
		int valorMax = this.getTamanhoMax() + 1;
		String ultimo = this.pegar(valorMax);
		String primeiro = this.pegar(valorMin);
		this.substituir(0, ultimo);
		this.substituir(this.index(), primeiro);
	}

	public void substituir(int index, String o) {
		this.Strings[index] = o;
	}

	public void inverterLista() {
		ListaString listaAux = new ListaString(5);
		for (int i = (this.index()); i >= 0; i--) {
			listaAux.adicionar(this.Strings[i]);
		}
		this.Strings = Arrays.copyOf(listaAux.Strings, this.tamanhoMax);
	}

	private void aumentarLista() {
		String[] novoArray = new String[this.tamanhoMax * 2];
		for (int i = 0; i < this.Strings.length; i++)
			novoArray[i] = this.Strings[i];
		this.tamanhoMax = this.tamanhoMax * 2;
		this.Strings = novoArray;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.ultimaPosLivre; i++)
			str.append(String.format("INDEX: %d POS: %d Objeto: %s \n", i, (i + 1), this.Strings[i]));
		str.append(String.format("Ultimo INDEX Livre: %d \n", this.ultimaPosLivre));
		return str.toString();
	}

	public String[] getStrings() {
		return Strings;
	}

	public void setStrings(String[] Strings) {
		this.Strings = Strings;
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

	public int size() {
		return this.Strings.length;
	}

	public void sortPorTamanho() {
		int n = this.Strings.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (this.Strings[j].length() > this.Strings[j + 1].length()) {
					String temp = this.Strings[j];
					this.Strings[j] = this.Strings[j + 1];
					this.Strings[j + 1] = temp;
				}
			}
		}
	}
}
