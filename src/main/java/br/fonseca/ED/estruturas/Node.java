package br.fonseca.ED.estruturas;

public class Node {

	private Node proximo;
	private Object conteudo;

	public Node(Node proximo, Object conteudo) {
		this.proximo = proximo;
		this.conteudo = conteudo;
	}

	public Node getProximo() {
		return this.proximo;
	}

	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

	public Object getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return this.getConteudo().toString();
	}

}