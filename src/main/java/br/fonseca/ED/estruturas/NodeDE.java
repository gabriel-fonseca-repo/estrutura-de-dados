package br.fonseca.ED.estruturas;

class NodeDE {

	private NodeDE anterior;
	private NodeDE proximo;
	private Object conteudo;

	public NodeDE(NodeDE anterior, NodeDE proximo, Object conteudo) {
		this.anterior = anterior;
		this.proximo = proximo;
		this.conteudo = conteudo;
	}

	public NodeDE getProximo() {
		return this.proximo;
	}

	public void setProximo(NodeDE proximo) {
		this.proximo = proximo;
	}

	public Object getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeDE other = (NodeDE) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (proximo == null) {
			if (other.proximo != null)
				return false;
		} else if (!proximo.equals(other.proximo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getConteudo().toString();
	}

	public NodeDE getAnterior() {
		return anterior;
	}

	public void setAnterior(NodeDE anterior) {
		this.anterior = anterior;
	}

}