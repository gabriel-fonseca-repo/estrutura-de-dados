package br.fonseca.ED.estruturas.fila;

import br.fonseca.ED.estruturas.NodeSE;

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

	public Object achar(int pos) {
		NodeSE aux = this.getPrimeiro();
		for (int i = 0; i < pos; i++) {
			aux = aux.getProximo();
		}
		return aux.getConteudo();
	}

	public int acharIndex(Object obj) {
		NodeSE aux = this.getPrimeiro();
		int cnt = 0;
		while (aux != null) {
			if (aux.getConteudo().equals(obj)) {
				return cnt;
			}
			cnt++;
			aux = aux.getProximo();
		}
		return -1;
	}

	public void remover(Object obj) {
		int objIndex = acharIndex(obj);

		if (objIndex != -1) {
			NodeSE aux = this.getPrimeiro();

			if (objIndex == 0) {
				this.setPrimeiro(getPrimeiro().getProximo());
				this.qtdElementos--;
			} else if (objIndex < this.getQtdElementos() - 1) {
				for (int i = 0; i < objIndex - 1; i++) {
					aux = aux.getProximo();
				}
				aux.setProximo(aux.getProximo().getProximo());
				this.qtdElementos--;
			} else {
				for (int i = 0; i < objIndex - 1; i++) {
					aux = aux.getProximo();
				}
				this.setUltimo(aux);
				getUltimo().setProximo(null);
				this.qtdElementos--;
			}
		}
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

	public void printBeecrowd() {
		if (!filaVazia()) {
			NodeSE aux = this.getPrimeiro();
			for (int i = 0; i < this.getQtdElementos() - 1; i++) {
				System.out.print(aux.getConteudo() + " ");
				aux = aux.getProximo();
			}
			System.out.println(aux.getConteudo());
		}
	}

	public boolean filaVazia() {
		return this.qtdElementos == 0;
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