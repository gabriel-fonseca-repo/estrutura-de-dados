package br.fonseca.ED.estruturas.lista;

import br.fonseca.ED.estruturas.NodeOrdenado;

public class ListaOrdenada {

	private int qtdElementos;

	private NodeOrdenado primeiro;
	private NodeOrdenado ultimo;

	public ListaOrdenada() {
		this.qtdElementos = 0;
	}

	public void adicionar(String obj) {
		NodeOrdenado novaCelula = new NodeOrdenado(obj);
		if (this.getPrimeiro() == null) {
			this.setPrimeiro(novaCelula);
			this.setUltimo(novaCelula);
		}
		if (!contem(obj)) {
			if ((novaCelula.getConteudo()).compareToIgnoreCase(this.getPrimeiro().getConteudo()) <= 0) {
				novaCelula.setProximo(this.getPrimeiro());
				this.setPrimeiro(novaCelula);
			} else if (novaCelula.getConteudo().compareToIgnoreCase(this.getUltimo().getConteudo()) >= 0) {
				this.getUltimo().setProximo(novaCelula);
				this.setUltimo(novaCelula);
			} else {
				NodeOrdenado aux1 = this.getPrimeiro();
				NodeOrdenado aux2 = this.getPrimeiro();

				while (novaCelula.getConteudo().compareToIgnoreCase(aux1.getConteudo()) >= 0) {
					aux1 = aux1.getProximo();
				}
				while (aux2.getProximo() != aux1) {
					aux2 = aux2.getProximo();
				}

				aux2.setProximo(novaCelula);
				novaCelula.setProximo(aux1);
			}
		}
		this.qtdElementos++;
	}

	public void adicionar3135(String obj) {
		NodeOrdenado novaCelula = new NodeOrdenado(obj);
		if (this.getPrimeiro() == null) {

			this.setPrimeiro(novaCelula);
			this.setUltimo(novaCelula);

		} else if (novaCelula.getConteudo().length() < this.getPrimeiro().getConteudo().length()) {

			novaCelula.setProximo(this.getPrimeiro());
			this.setPrimeiro(novaCelula);

		} else if (novaCelula.getConteudo().length() >= this.getUltimo().getConteudo().length()) {

			this.getUltimo().setProximo(novaCelula);
			this.setUltimo(novaCelula);

		} else {

			NodeOrdenado aux1 = this.getPrimeiro();
			NodeOrdenado aux2 = this.getPrimeiro();
			while (novaCelula.getConteudo().length() >= aux1.getConteudo().length()) {
				aux1 = aux1.getProximo();
			}
			while (aux2.getProximo() != aux1) {
				aux2 = aux2.getProximo();
			}
			aux2.setProximo(novaCelula);
			novaCelula.setProximo(aux1);

		}
		this.qtdElementos++;
	}

	public String achar(int index) {
		if (!listaVazia()) {
			NodeOrdenado aux = this.getPrimeiro();
			for (int i = 0; i < index && aux.getConteudo() != null; i++) {
				aux = aux.getProximo();
			}
			return aux.getConteudo();
		}
		return "arrayIsEmpty";
	}

	public void remover(int index) {
		if (!listaVazia()) {
			NodeOrdenado aux = this.getPrimeiro();
			if (index == 0) {
				this.setPrimeiro(aux.getProximo());
			} else if (index > 0 && index < indices()) {
				for (int i = 0; i < index - 1; i++) {
					aux = aux.getProximo();
				}
				aux.setProximo(aux.getProximo().getProximo());
			} else if (index == indices()) {
				for (int i = 0; i < index - 1; i++) {
					aux = aux.getProximo();
				}
				this.getUltimo().setProximo(null);
				this.setUltimo(aux);
			}
		}
		this.qtdElementos--;
	}

	public void remover(String obj) {
		int index = indice(obj);
		if (index != -1) {
			NodeOrdenado aux = this.getPrimeiro();
			if (obj == this.getPrimeiro().getConteudo()) {
				this.setPrimeiro(aux.getProximo());
			} else if (index > 0 && index < this.indices()) {
				for (int i = 0; i < index - 1; i++) {
					aux = aux.getProximo();
				}
				aux.setProximo(aux.getProximo().getProximo());
			} else if (index == this.indices()) {
				for (int i = 0; i < index - 1; i++) {
					aux = aux.getProximo();
				}
				this.getUltimo().setProximo(null);
				this.setUltimo(aux);
			}
		}
	}

	public int indice(String obj) {
		if (!listaVazia()) {
			NodeOrdenado aux = this.getPrimeiro();
			for (int i = 0; i < tamanho(); i++) {
				if (aux.getConteudo() == obj)
					return i;
				aux = aux.getProximo();
			}
		}
		return -1;
	}

	public void inverterLista() {
		NodeOrdenado anterior = null;
		NodeOrdenado atual = this.getPrimeiro();
		NodeOrdenado proxima = null;
		this.setUltimo(atual);
		while (atual != null) {
			proxima = atual.getProximo();
			atual.setProximo(anterior);
			anterior = atual;
			atual = proxima;
		}
		this.setPrimeiro(anterior);
	}

	public boolean contem(String obj) {
		NodeOrdenado aux = this.getPrimeiro();
		while (aux != null) {
			if (aux.getConteudo().equals(obj))
				return true;
			aux = aux.getProximo();
		}
		return false;
	}

	public String maiorPalavra() {
		String primeiraPalavra = this.achar(0);
		int maximo = primeiraPalavra.length();
		String maiorPalavra = primeiraPalavra;
		String palavraAtual = "";
		for (int i = 0; i < this.tamanho() - 1; i++) {
			if ((palavraAtual = achar(i)).length() > maximo) {
				maximo = palavraAtual.length();
				maiorPalavra = palavraAtual;
			}
		}
		return maiorPalavra;
	}

	public boolean palavraDesseTamanho(int tamanho) {
		for (int i = 0; i < this.tamanho(); i++) {
			if (achar(i).length() == tamanho)
				return true;
		}
		return false;
	}

	public String acharPalavraPorTamanho(int refLength) {
		String palavra;
		for (int i = 0; true; i++) {
			if ((palavra = achar(i)).length() == refLength)
				return palavra;
		}
	}

	public void clear() {
		this.setPrimeiro(null);
		this.setUltimo(null);
	}

	public boolean indexValido(int index) {
		return index > 0 && index <= indices();
	}

	public boolean listaVazia() {
		return this.getPrimeiro() == null;
	}

	public int indices() {
		return tamanho() - 1;
	}

	public int tamanho() {
		NodeOrdenado aux = this.getPrimeiro();
		int index = 0;

		while (aux != getUltimo().getProximo()) {
			index++;
			aux = aux.getProximo();
			System.out.println(aux);
		}
		System.out.println("-----------------------");
		return index;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		NodeOrdenado aux = this.getPrimeiro();
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

	public void printBEECROWD() {
		if (!listaVazia()) {
			NodeOrdenado currentData = this.getPrimeiro();

			while (currentData != this.getUltimo()) {
				System.out.print(currentData.getConteudo() + " ");
				currentData = currentData.getProximo();
			}
			System.out.println(getUltimo().getConteudo());
		}
	}

	/* Getters and setters */

	public int getQtdElementos() {
		return qtdElementos;
	}

	public NodeOrdenado getUltimo() {
		return ultimo;
	}

	public void setUltimo(NodeOrdenado ultimo) {
		this.ultimo = ultimo;
	}

	public NodeOrdenado getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NodeOrdenado primeiro) {
		this.primeiro = primeiro;
	}

}