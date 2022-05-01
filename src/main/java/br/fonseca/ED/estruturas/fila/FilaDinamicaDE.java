package br.fonseca.ED.estruturas.fila;

import br.fonseca.ED.beecrowd.NodeDE;

public class FilaDinamicaDE {

	private int contador = 0;
	private NodeDE primeiro = null;
	private NodeDE ultimo = null;

	public int tamanho() {
		return contador;
	}

	public void enfileirar(int dado) {
		NodeDE novo = new NodeDE(dado);

		if (tamanho() == 0) {
			setPrimeiro(novo);
			setUltimo(novo);
		} else {
			getUltimo().setProximo(novo);
			novo.setAnterior(getUltimo());
			setUltimo(novo);
		}
		contador++;
	}

	public void desenfileirar() {
		if (tamanho() == 1) {
			setPrimeiro(null);
			setUltimo(null);
		} else if (tamanho() == 2) {
			getUltimo().setAnterior(null);
			setPrimeiro(getUltimo());
		} else {
			getPrimeiro().getProximo().setAnterior(null);
			setPrimeiro(getPrimeiro().getProximo());
		}
		contador--;
	}

	public Object topo() {
		return getPrimeiro().getDado();
	}

	public void zerar() {
		setPrimeiro(null);
		setUltimo(null);
		contador = 0;
	}

	public void print() {
		NodeDE aux = getPrimeiro();
		while (aux != null) {
			System.out.print(aux.getDado() + " ");
			aux = aux.getProximo();
		}
	}

	public NodeDE getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NodeDE primeiro) {
		this.primeiro = primeiro;
	}

	public NodeDE getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodeDE ultimo) {
		this.ultimo = ultimo;
	}
}