package br.fonseca.ED.estruturas;

class Node {

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
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

}