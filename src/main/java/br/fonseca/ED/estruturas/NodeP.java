package br.fonseca.ED.estruturas;

public class NodeP {

	public NodeP proximo;
	public Object conteudo;
	public Integer prioridade;

	public NodeP(Object conteudo, Integer prioridade) {
		this.conteudo = conteudo;
		this.prioridade = prioridade;
	}

	public NodeP getProximo() {
		return proximo;
	}

	public void setProximo(NodeP proximo) {
		this.proximo = proximo;
	}

	public Object getConteudo() {
		return conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

}