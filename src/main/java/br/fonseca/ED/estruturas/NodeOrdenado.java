package br.fonseca.ED.estruturas;

public class NodeOrdenado {

	private String conteudo;
	private NodeOrdenado proximo;

	public NodeOrdenado(String conteudo) {
		this.setConteudo(conteudo);
		this.setProximo(null);
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public NodeOrdenado getProximo() {
		return proximo;
	}

	public void setProximo(NodeOrdenado proximo) {
		this.proximo = proximo;
	}

}