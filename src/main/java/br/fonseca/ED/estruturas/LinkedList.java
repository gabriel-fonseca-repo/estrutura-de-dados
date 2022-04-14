package br.fonseca.ED.estruturas;

public class LinkedList {

	private int qtdElementos = 0;

	private boolean primeiraPosicao;

	private Node primeiro;
	private Node ultimo;

	public LinkedList() {
		this.primeiraPosicao = true;
	}

	public void adicionar(Object... conteudo) {
		for (Object obj : conteudo) {
			Node novaCelula = new Node(null, obj);
			if (isPrimeiraPosicao()) {
				this.setPrimeiro(novaCelula);
				this.setUltimo(novaCelula);
				this.setPrimeiraPosicao(false);
			} else {
				this.ultimo.setProximo(novaCelula);
				this.ultimo = novaCelula;
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

		Node aux = this.primeiro;
		int contador;

		for (contador = 1; contador < index && aux != null; contador++) {
			aux = aux.getProximo();
		}

		if (aux == null) {
			adicionarFinal(conteudo);
		} else {
			Node novaCelula = new Node(aux.getProximo(), conteudo);
			aux.setProximo(novaCelula);
		}
	}

	private void adicionarInicio(Object conteudo) {
		Node novaCelula = new Node(primeiro, conteudo);
		this.primeiro = novaCelula;
	}

	private void adicionarFinal(Object conteudo) {
		Node novaCelula = new Node(null, conteudo);
		this.ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
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

		Node aux = this.primeiro;
		Node removido = aux;
		int contador;

		for (contador = 1; contador <= index && aux != null; contador++) {
			aux = removido;
			removido = removido.getProximo();
		}

		if (removido == null) {
			removerFinal();
		} else {
			aux.setProximo(removido.getProximo());
		}
	}

	private void removerFinal() {
		Node aux = this.getPrimeiro();
		Node removido = aux;
		while (removido.getProximo() != null) {
			aux = removido;
			removido = removido.getProximo();
		}
		aux.setProximo(null);
	}

	private void removerInicio() {
		this.primeiro = this.getPrimeiro().getProximo();
	}

	public void eliminarPrimeiro() {
		this.primeiro = this.primeiro.getProximo();
	}

	public void inverterLista() {
		Node anterior = null;
		Node atual = this.getPrimeiro();
		Node proxima = null;
		while (atual != null) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proxima;
		}
		this.setPrimeiro(anterior);
	}

	public void imprimirListaAoContrario() {
		this.inverterLista();
		System.out.println(this);
		this.inverterLista();
	}

	private boolean isPrimeiraPosicao() {
		return primeiraPosicao;
	}

	private void setPrimeiraPosicao(boolean primeiraPosicao) {
		this.primeiraPosicao = primeiraPosicao;
	}

	private Node getPrimeiro() {
		return primeiro;
	}

	private void setPrimeiro(Node primeiro) {
		this.primeiro = primeiro;
	}

	private Node getUltimo() {
		return ultimo;
	}

	private void setUltimo(Node ultimo) {
		this.ultimo = ultimo;
	}

	private int getQtdElementos() {
		return qtdElementos;
	}

	private void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		Node aux = this.getPrimeiro();
		int i = 0;
		while (aux != null) {
			str.append("INDEX: " + i + " CONTEUDO: " + aux + "\n");
			i++;
			aux = aux.getProximo();
		}
		return str.toString();
	}

	public String imprimirEsquerdaDireita() {
		StringBuilder str = new StringBuilder("");
		Node aux = this.getPrimeiro();

		str.append(aux);
		aux = aux.getProximo();

		while (aux != null) {
			str.append(", " + aux);
			aux = aux.getProximo();
		}

		return str.toString();
	}

}