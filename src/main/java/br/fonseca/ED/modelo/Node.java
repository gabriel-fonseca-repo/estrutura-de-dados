package br.fonseca.ED.modelo;

public class Node {

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

}
