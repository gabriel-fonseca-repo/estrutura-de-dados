package br.fonseca.ED.estruturas;

public class FilaDinamica {

	private int qtdElementos;

	private boolean primeiraPosicao;

	private NodeSE primeiro;
	private NodeSE ultimo;

	public FilaDinamica() {
		this.primeiraPosicao = true;
		this.qtdElementos = 0;
	}

	public void enqueue(Object... conteudo) {
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

	public void enqueue(Object conteudo) {
		NodeSE novaCelula = new NodeSE(null, conteudo);
		this.getUltimo().setProximo(novaCelula);
		this.setUltimo(novaCelula);
		this.qtdElementos++;
	}

	public Object dequeue() {
		NodeSE retorno = this.getPrimeiro();
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.qtdElementos--;
		return retorno.getConteudo();
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