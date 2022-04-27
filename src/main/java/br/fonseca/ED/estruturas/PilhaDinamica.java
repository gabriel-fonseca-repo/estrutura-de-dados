package br.fonseca.ED.estruturas;

public class PilhaDinamica {

	private int qtdElementos;

	private boolean primeiraPosicao;

	private NodeSE primeiro;
	private NodeSE ultimo;

	public PilhaDinamica() {
		this.primeiraPosicao = true;
		this.qtdElementos = 0;
	}

	public Object peek() {
		return this.getUltimo().getConteudo();
	}

	public void push(Object... conteudo) {
		for (Object obj : conteudo) {
			NodeSE novaCelula = new NodeSE(null, obj);
			if (isPrimeiraPosicao()) {
				this.setPrimeiro(novaCelula);
				this.setUltimo(novaCelula);
				this.setPrimeiraPosicao(false);
			} else {
				this.getUltimo().setProximo(novaCelula);
				this.setUltimo(novaCelula);
			}
			this.qtdElementos++;
		}
	}

	public void pop() {
		NodeSE aux = this.getPrimeiro();
		NodeSE removido = aux;
		while (removido.getProximo() != null) {
			aux = removido;
			removido = removido.getProximo();
		}
		aux.setProximo(null);
		this.setUltimo(aux);
		this.qtdElementos--;
	}

	public boolean repetidos() {
		NodeSE aux = this.getPrimeiro();

		while (aux.getProximo() != null) {

			NodeSE aux2 = aux.getProximo();

			while (aux2 != null) {
				if (aux.getConteudo().equals(aux2.getConteudo())) {
					return true;
				}
				aux2 = aux2.getProximo();
			}
			aux = aux.getProximo();
		}
		return false;
	}

	public void inverterPilha() {
		NodeSE anterior = null;
		NodeSE atual = this.getPrimeiro();
		NodeSE proxima = null;
		this.setUltimo(atual);
		while (atual != null) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proxima;
		}
		this.setPrimeiro(anterior);
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
		str.append("QTD DE ELEMENTOS: " + this.qtdElementos + "\n");
		str.append("Primeiro elemento: " + this.getPrimeiro() + "\n");
		str.append("Ultimo elemento: " + this.getUltimo() + "\n");
		return str.toString();
	}

	/* Getters and setters */

	private boolean isPrimeiraPosicao() {
		return primeiraPosicao;
	}

	private void setPrimeiraPosicao(boolean primeiraPosicao) {
		this.primeiraPosicao = primeiraPosicao;
	}

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
}