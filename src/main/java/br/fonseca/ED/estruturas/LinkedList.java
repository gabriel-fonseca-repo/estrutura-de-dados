package br.fonseca.ED.estruturas;

public class LinkedList {

	public static void main(String[] args) {
		LinkedList lista = new LinkedList();

		lista.adicionar(17);
		lista.adicionar(13);
		lista.adicionar(12);
		lista.adicionar(45);
		lista.adicionar(65);
		lista.adicionar(0);
		lista.adicionar(99);

		lista.adicionarInicio(999);

		System.out.print(lista);
		System.out.println();

		lista.eliminarPrimeiro();

		System.out.print(lista);
		System.out.println();

		System.out.println(lista.imprimirEsquerdaDireita());
		System.out.println();

		lista.imprimirListaAoContrario();
	}

	private int qtdElementos = 0;

	private boolean primeiraPosicao;

	private Node primeiro;
	private Node ultimo;

	public LinkedList() {
		this.primeiraPosicao = true;
	}

	public void adicionar(Object conteudo) {
		Node novaCelula = new Node(null, conteudo);
		if (isPrimeiraPosicao()) {
			this.setPrimeiro(novaCelula);
			this.setUltimo(novaCelula);
			this.setPrimeiraPosicao(false);
		} else {
			this.ultimo.setProximo(novaCelula);
			this.ultimo = novaCelula;
		}
		this.qtdElementos++;
	}

	public void adicionarInicio(Object conteudo) {
		Node novaCelula = new Node(primeiro, conteudo);
		this.primeiro = novaCelula;
	}

	public void eliminarPrimeiro() {
		this.primeiro = this.primeiro.getProximo();
	}

	public void inverterLista() {
		Node anterior = null;
		Node atual = this.getPrimeiro();
		Node proxima = null;
		while (atual != null) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proxima;
		}
		this.setPrimeiro(anterior);
	}

	public void imprimirListaAoContrario() {
		this.inverterLista();
		System.out.println(this);
		this.inverterLista();
	}

	private boolean isPrimeiraPosicao() {
		return primeiraPosicao;
	}

	private void setPrimeiraPosicao(boolean primeiraPosicao) {
		this.primeiraPosicao = primeiraPosicao;
	}

	private Node getPrimeiro() {
		return primeiro;
	}

	private void setPrimeiro(Node primeiro) {
		this.primeiro = primeiro;
	}

	private Node getUltimo() {
		return ultimo;
	}

	private void setUltimo(Node ultimo) {
		this.ultimo = ultimo;
	}

	private int getQtdElementos() {
		return qtdElementos;
	}

	private void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		Node aux = this.getPrimeiro();
		int i = 0;
		while (aux != null) {
			str.append("INDEX: " + i + " CELULA: " + aux + "\n");
			i++;
			aux = aux.getProximo();
		}
		return str.toString();
	}

	public String imprimirEsquerdaDireita() {
		StringBuilder str = new StringBuilder("");
		Node aux = this.getPrimeiro();
		while (aux != null) {
			str.append(aux + ", ");
			aux = aux.getProximo();
		}
		str.replace(str.toString().length() - 2, str.toString().length(), "");
		return str.toString();
	}

}

class Node {

	private Node proximo;
	private Object conteudo;

	public Node(Node proximo, Object conteudo) {
		this.proximo = proximo;
		this.conteudo = conteudo;
	}

	public Node getProximo() {
		return proximo;
	}

	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

	public Object getConteudo() {
		return conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return this.getConteudo().toString();
	}

}
