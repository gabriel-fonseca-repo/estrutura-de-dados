package br.fonseca.ED.estruturas;

public class ListaDinamica {

	private int qtdElementos;

	private boolean primeiraPosicao;

	private Node primeiro;
	private Node ultimo;

	public ListaDinamica() {
		this.primeiraPosicao = true;
		this.qtdElementos = 0;
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

	public Node achar(int index) {
		if (index <= 0) {
			return this.getPrimeiro();
		}
		if (index >= this.getQtdElementos()) {
			return this.getUltimo();
		}

		Node aux = this.getPrimeiro();
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
			this.qtdElementos++;
		}
	}

	private void adicionarInicio(Object conteudo) {
		Node novaCelula = new Node(primeiro, conteudo);
		this.primeiro = novaCelula;
		this.qtdElementos++;
	}

	private void adicionarFinal(Object conteudo) {
		Node novaCelula = new Node(null, conteudo);
		this.ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
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
			this.qtdElementos--;
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
		this.setUltimo(aux);
		this.qtdElementos--;
	}

	private void removerInicio() {
		this.primeiro = this.getPrimeiro().getProximo();
		this.qtdElementos--;
	}

	public void eliminarPrimeiro() {
		this.primeiro = this.primeiro.getProximo();
		this.qtdElementos--;
	}

	public boolean repetidos() {
		Node aux = this.getPrimeiro();

		while (aux.getProximo() != null) {

			Node aux2 = aux.getProximo();

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
		Node anterior = null;
		Node atual = this.getPrimeiro();
		Node proxima = null;
		this.setUltimo(atual);
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
		str.append("QTD DE ELEMENTOS: " + this.qtdElementos + "\n");
		str.append("Primeiro elemento: " + this.getPrimeiro() + "\n");
		str.append("Ultimo elemento: " + this.getUltimo() + "\n");
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

	/* Getters and setters */

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

}