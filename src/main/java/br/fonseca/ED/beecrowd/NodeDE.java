package br.fonseca.ED.beecrowd;

public class NodeDE {

	private Object dado;
	private NodeDE anterior;
	private NodeDE proximo;

	public NodeDE(Object dado) {
		this.setDado(dado);
		this.setAnterior(null);
		this.setProximo(null);
	}

	public Object getDado() {
		return dado;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}

	public NodeDE getAnterior() {
		return anterior;
	}

	public void setAnterior(NodeDE anterior) {
		this.anterior = anterior;
	}

	public NodeDE getProximo() {
		return proximo;
	}

	public void setProximo(NodeDE proximo) {
		this.proximo = proximo;
	}
}
