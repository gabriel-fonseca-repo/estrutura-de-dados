package br.fonseca.ED.estruturas.lista;

import br.fonseca.ED.estruturas.NodeDE;

public class ListaDinamicaDE {

	private int qtdElementos;

	private boolean primeiraPosicao;

	private NodeDE primeiro;
	private NodeDE ultimo;

	public ListaDinamicaDE() {
		this.primeiraPosicao = true;
		this.qtdElementos = 0;
	}

	public void adicionar(Object... conteudo) {
		for (Object obj : conteudo) {
			NodeDE novaCelula = new NodeDE(null, null, obj);
			if (isPrimeiraPosicao()) {
				this.setPrimeiro(novaCelula);
				this.setUltimo(novaCelula);
				this.setPrimeiraPosicao(false);
			} else {
				this.getUltimo().setProximo(novaCelula);
				novaCelula.setAnterior(this.getUltimo());
				this.setUltimo(novaCelula);
			}
			this.qtdElementos++;
		}
	}

	public NodeDE achar(int index) {
		if (index <= 0) {
			return this.getPrimeiro();
		}
		if (index >= this.getQtdElementos()) {
			return this.getUltimo();
		}

		NodeDE aux = this.getPrimeiro();
		int i = 0;

		while (aux != null && i < index) {
			aux = aux.getProximo();
			i++;
		}

		return aux;
	}

	public Object acharPorObjeto(Object obj) {
		NodeDE aux = this.getPrimeiro();
		int index = 1;
		while (aux != null) {
			if (aux.getConteudo().equals(obj)) {
				return index;
			}
			index++;
			aux = aux.getProximo();
		}
		return -1;
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
		NodeDE aux = this.primeiro;
		for (int contador = 1; contador < index && aux != null; contador++) {
			aux = aux.getProximo();
		}
		if (aux == null) {
			adicionarFinal(conteudo);
		} else {
			NodeDE novaCelula = new NodeDE(aux.getAnterior(), aux, conteudo);
			aux.getAnterior().setProximo(novaCelula);
			aux.setAnterior(novaCelula);
			this.qtdElementos++;
		}
	}

	private void adicionarInicio(Object conteudo) {
		NodeDE novaCelula = new NodeDE(null, this.getPrimeiro(), conteudo);
		this.getPrimeiro().setAnterior(novaCelula);
		this.setPrimeiro(novaCelula);
		this.qtdElementos++;
	}

	private void adicionarFinal(Object conteudo) {
		NodeDE novaCelula = new NodeDE(this.getUltimo(), null, conteudo);
		this.getUltimo().setProximo(novaCelula);
		this.setUltimo(novaCelula);
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

		NodeDE aux = this.primeiro;
		NodeDE removido = aux;
		int contador;

		for (contador = 1; contador <= index && aux != null; contador++) {
			aux = removido;
			removido = removido.getProximo();
		}

		if (removido == null) {
			removerFinal();
		} else {
			aux.setProximo(removido.getProximo());
			removido.getProximo().setAnterior(aux);
			this.qtdElementos--;
		}
	}

	private void removerFinal() {
		NodeDE aux = this.getPrimeiro();
		NodeDE removido = aux;
		while (removido.getProximo() != null) {
			aux = removido;
			removido = removido.getProximo();
		}
		aux.setProximo(null);
		this.setUltimo(aux);
		this.qtdElementos--;
	}

	private void removerInicio() {
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.getPrimeiro().setAnterior(null);
		this.qtdElementos--;
	}

	public void eliminarPrimeiro() {
		this.setPrimeiro(this.getPrimeiro().getProximo());
		this.getPrimeiro().setAnterior(null);
		this.qtdElementos--;
	}

	public void removerMeio() {
		this.remover(this.getQtdElementos() / 2);
	}

	public boolean repetidos() {
		NodeDE aux = this.getPrimeiro();
		while (aux.getProximo() != null) {
			NodeDE aux2 = aux.getProximo();
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

	public void maisRepetido() {
		NodeDE aux = this.getPrimeiro();
		NodeDE elementoMaisRepetido = null;
		int qtdMaior = 0;
		while (aux != null) {
			int qtdRepetidaAtual = 0;
			NodeDE aux2 = aux.getProximo();
			while (aux2 != null) {
				if (aux.equals(aux2)) {
					qtdRepetidaAtual++;
				}
				aux2 = aux2.getProximo();
			}
			if (qtdRepetidaAtual > qtdMaior) {
				qtdMaior = qtdRepetidaAtual;
				elementoMaisRepetido = aux;
			}
			aux = aux.getProximo();
		}
		System.out.println(
				"Elemento mais repetido: " + elementoMaisRepetido + " Quantidade de repetições: " + (qtdMaior + 1));
	}

	public void inverterLista() {
		NodeDE anterior = null;
		NodeDE atual = this.getPrimeiro();
		NodeDE proxima = null;
		this.setUltimo(atual);
		while (atual != null) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			atual.setAnterior(proxima);
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
		NodeDE aux = this.getPrimeiro();
		int i = 0;
		while (aux != null) {
			str.append("INDEX: " + i + " CONTEUDO: " + aux + " ANTERIOR: " + aux.getAnterior() + "\n");
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
		NodeDE aux = this.getPrimeiro();

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

	private NodeDE getPrimeiro() {
		return primeiro;
	}

	private void setPrimeiro(NodeDE primeiro) {
		this.primeiro = primeiro;
	}

	private NodeDE getUltimo() {
		return ultimo;
	}

	private void setUltimo(NodeDE ultimo) {
		this.ultimo = ultimo;
	}

	public int getQtdElementos() {
		return qtdElementos;
	}

	public void removerRepetido() {

	}

}