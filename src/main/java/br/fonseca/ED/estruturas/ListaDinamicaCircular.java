package br.fonseca.ED.estruturas;

public class ListaDinamicaCircular {

	private int qtdElementos;

	private boolean primeiraPosicao;

	private NodeSE primeiro;
	private NodeSE ultimo;

	public ListaDinamicaCircular() {
		this.primeiraPosicao = true;
		this.qtdElementos = 0;
	}

	public void adicionar(Object... conteudo) {
		for (Object obj : conteudo) {
			NodeSE novaCelula = new NodeSE(null, obj);
			if (isPrimeiraPosicao()) {
				this.setPrimeiro(novaCelula);
				this.setUltimo(novaCelula);
				this.getUltimo().setProximo(getPrimeiro());
				this.setPrimeiraPosicao(false);
			} else {
				this.getUltimo().setProximo(novaCelula);
				this.setUltimo(novaCelula);
				this.getUltimo().setProximo(getPrimeiro());
			}
			this.qtdElementos++;
		}
	}

	public void adicionar(Object conteudo, int index) {
		if (index <= 0) {
			adicionarInicio(conteudo);
			return;
		}
		if (index >= this.getQtdElementos()) {
			adicionarFinal(conteudo);
			return;
		}
		NodeSE aux = this.getPrimeiro();
		int contador;
		for (contador = 1; contador < index; contador++) {
			aux = aux.getProximo();
		}
		if (aux == null) {
			adicionarFinal(conteudo);
		} else {
			NodeSE novaCelula = new NodeSE(aux.getProximo(), conteudo);
			aux.setProximo(novaCelula);
			this.qtdElementos++;
		}
	}

	private void adicionarInicio(Object conteudo) {
		NodeSE novaCelula = new NodeSE(primeiro, conteudo);
		this.setPrimeiro(novaCelula);
		this.getUltimo().setProximo(novaCelula);
		this.qtdElementos++;
	}

	private void adicionarFinal(Object conteudo) {
		NodeSE novaCelula = new NodeSE(null, conteudo);
		this.getUltimo().setProximo(novaCelula);
		this.setUltimo(novaCelula);
		this.getUltimo().setProximo(getPrimeiro());
		this.qtdElementos++;
	}

	public void remover(int index) {
		if (index <= 0) {
			removerInicio();
			return;
		}
		if (index >= this.getQtdElementos()) {
			removerFinal();
			return;
		}

		NodeSE aux = this.getPrimeiro();
		NodeSE removido = aux;
		int contador;

		for (contador = 1; contador <= index && aux != null; contador++) {
			aux = removido;
			removido = removido.getProximo();
		}

		if (removido == null) {
			removerFinal();
		} else {
			aux.setProximo(removido.getProximo());
			this.qtdElementos--;
		}
	}

	private void removerFinal() {
		NodeSE aux = this.getPrimeiro();
		NodeSE removido = aux;
		int i = 0;
		while (i != this.getQtdElementos()) {
			aux = removido;
			removido = removido.getProximo();
			i++;
		}
		aux.setProximo(getPrimeiro());
		this.setUltimo(aux);
		this.qtdElementos--;
	}

	private void removerInicio() {
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.getUltimo().setProximo(getPrimeiro());
		this.qtdElementos--;
	}

	public void eliminarPrimeiro() {
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.getUltimo().setProximo(getPrimeiro());
		this.qtdElementos--;
	}

	public NodeSE achar(int index) {
		if (index <= 0) {
			return this.getPrimeiro();
		}
		if (index >= this.getQtdElementos()) {
			return this.getUltimo();
		}

		NodeSE aux = this.getPrimeiro();
		int i = 0;

		while (aux != null && i < index) {
			aux = aux.getProximo();
			i++;
		}

		return aux;
	}

	public Object acharPenultimo() {
		return this.achar(this.getQtdElementos() - 2);
	}

	public Object acharUltimo() {
		return this.achar(this.getQtdElementos() - 1);
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

	public void inverterLista() {
		NodeSE anterior = null;
		NodeSE atual = this.getPrimeiro();
		NodeSE proxima = null;
		this.setUltimo(atual);
		int i = 0;
		while (i < this.getQtdElementos()) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proxima;
			i++;
		}
		this.setPrimeiro(anterior);
	}

	public void imprimirListaAoContrario() {
		this.inverterLista();
		System.out.println(this);
		this.inverterLista();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		NodeSE aux = this.getPrimeiro();
		int i = 0;
		while (i != this.getQtdElementos()) {
			str.append("INDEX: " + i + " CONTEUDO: " + aux + "\n");
			i++;
			aux = aux.getProximo();
		}
		str.append("QTD DE ELEMENTOS: " + this.qtdElementos + "\n");
		str.append("Primeiro elemento: " + this.getPrimeiro() + "\n");
		str.append("Ultimo elemento: " + this.getUltimo() + "\n");
		return str.toString();
	}

	public String imprimirEsquerdaDireita() {
		StringBuilder str = new StringBuilder("");
		NodeSE aux = this.getPrimeiro();

		str.append(aux);
		aux = aux.getProximo();
		int i = 1;
		while (i != this.getQtdElementos()) {
			str.append(", " + aux);
			aux = aux.getProximo();
			i++;
		}

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