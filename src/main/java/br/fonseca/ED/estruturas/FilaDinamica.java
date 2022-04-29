package br.fonseca.ED.estruturas;

public class FilaDinamica {

	private int qtdElementos;

	private NodeSE primeiro;
	private NodeSE ultimo;

	public FilaDinamica() {
		this.setQtdElementos(0);
	}

	public void enfileirar(Object conteudo) {
		NodeSE novaCelula = new NodeSE(null, conteudo);
		if (this.getPrimeiro() == null) {
			this.setPrimeiro(novaCelula);
			this.setUltimo(novaCelula);
		} else {
			this.getUltimo().setProximo(novaCelula);
			this.setUltimo(novaCelula);
		}
		this.qtdElementos++;
	}

	public Object desenfileirar() {
		NodeSE retorno = this.getPrimeiro();
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.qtdElementos--;
		return retorno.getConteudo();
	}

	public void print() {
		StringBuilder str = new StringBuilder("");
		NodeSE aux = this.getPrimeiro();
		while (aux != null) {
			if (aux.getProximo() == null) {
				str.append(" ").append(aux);
			} else {
				str.append(" ").append(aux).append(",");
			}
			aux = aux.getProximo();
		}
		System.out.println(str.toString());
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		NodeSE aux = this.getPrimeiro();
		int i = 0;
		while (aux != null) {
			str.append("INDEX: " + i + " CONTEUDO: " + aux + "\n");
			i++;
			aux = aux.getProximo();
		}
		str.append("QTD DE ELEMENTOS: " + this.getQtdElementos() + "\n");
		str.append("Primeiro elemento: " + this.getPrimeiro() + "\n");
		str.append("Ultimo elemento: " + this.getUltimo() + "\n");
		return str.toString();
	}

	/* Getters and setters */

	private NodeSE getPrimeiro() {
		return primeiro;
	}

	private void setPrimeiro(NodeSE primeiro) {
		this.primeiro = primeiro;
	}

	private NodeSE getUltimo() {
		return ultimo;
	}

	private void setUltimo(NodeSE ultimo) {
		this.ultimo = ultimo;
	}

	private int getQtdElementos() {
		return qtdElementos;
	}

	public int size() {
		return this.getQtdElementos();
	}

	public void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}

	public int quantidade() {
		return this.getQtdElementos();
	}

}