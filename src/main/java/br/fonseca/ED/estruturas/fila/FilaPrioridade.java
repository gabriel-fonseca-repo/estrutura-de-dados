package br.fonseca.ED.estruturas.fila;

import br.fonseca.ED.estruturas.NodeP;

public class FilaPrioridade {
	private NodeP primeiro;
	private NodeP ultimo;
	private int qtdElementos;
	private int indices;

	public FilaPrioridade() {
		this.setPrimeiro(null);
		this.setUltimo(null);
		setQtdElementos(0);
		setIndices(-1);
	}

	public void enfileirar(Object obj, int level) {
		NodeP newData = new NodeP(obj, level);

		if (getPrimeiro() == null) {
			this.setPrimeiro(this.setUltimo(newData));
		} else {
			if (newData.prioridade >= this.getPrimeiro().prioridade) {
				newData.setProximo(this.getPrimeiro());
				this.setPrimeiro(newData);
			} else if (newData.prioridade < this.getUltimo().prioridade) {
				this.getUltimo().setProximo(newData);
				this.setUltimo(newData);
			} else {
				NodeP aux = this.getPrimeiro();
				while (newData.prioridade < aux.getProximo().prioridade) {
					aux = aux.getProximo();
				}
				newData.setProximo(aux.getProximo());
				aux.setProximo(newData);
			}
		}
		increasePositionRef();
	}

	public Object desenfileirar() {
		if (!isEmpty()) {
			Object dequeue = this.getPrimeiro().conteudo;
			this.setPrimeiro(this.getPrimeiro().getProximo());
			decreasePositionRef();

			return dequeue;
		}
		return null;
	}

	public Object frente() {
		return this.getPrimeiro().conteudo;
	}

	public void printToString() {
		if (!isEmpty()) {
			NodeP aux = this.getPrimeiro();
			for (int i = 0; i < getIndices(); i++) {
				System.out.print(aux.conteudo + ", ");
				aux = aux.getProximo();
			}
			System.out.println(aux.conteudo);
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		NodeP aux = this.getPrimeiro();
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

	public Object achar(int pos) {
		NodeP aux = this.getPrimeiro();
		for (int i = 0; i < pos; i++) {
			aux = aux.getProximo();
		}
		return aux.conteudo;
	}

	public int acharPrioridade(int pos) {
		NodeP aux = this.getPrimeiro();
		for (int i = 0; i < pos; i++) {
			aux = aux.getProximo();
		}
		return aux.prioridade;
	}

	public void remover(Object obj) {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			int objIndex = indexOf(obj);

			if (objIndex != -1) {
				NodeP aux = this.getPrimeiro();

				if (objIndex == 0) {
					this.setPrimeiro(getPrimeiro().getProximo());
					decreasePositionRef();
				} else if (objIndex < this.getIndices()) {
					for (int i = 0; i < objIndex - 1; i++) {
						aux = aux.getProximo();
					}
					aux.setProximo(aux.getProximo().getProximo());
					decreasePositionRef();
				} else {
					for (int i = 0; i < objIndex - 1; i++) {
						aux = aux.getProximo();
					}
					this.setUltimo(aux);
					getUltimo().setProximo(null);
					decreasePositionRef();
				}
			}
		}
	}

	public void clear() {
		zerarFila();
	}

	public boolean isEmpty() {
		return getQtdElementos() == 0;
	}

	public int indexOf(Object obj) {
		NodeP aux = getPrimeiro();
		int cnt = 0;

		while (aux != null) {
			if (aux.conteudo.equals(obj)) {
				return cnt;
			}
			cnt++;
			aux = aux.getProximo();
		}
		return -1;
	}

	public void decreasePositionRef() {
		this.setQtdElementos(this.getQtdElementos() - 1);
		this.setIndices(this.getIndices() - 1);
	}

	public void increasePositionRef() {
		this.setQtdElementos(this.getQtdElementos() + 1);
		this.setIndices(this.getIndices() + 1);
	}

	public int size() {
		return getQtdElementos();
	}

	public void zerarFila() {
		this.setPrimeiro(null);
		this.setUltimo(null);
		this.setQtdElementos(0);
		this.setIndices(-1);
	}

	public NodeP getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(NodeP primeiro) {
		this.primeiro = primeiro;
	}

	public NodeP getUltimo() {
		return ultimo;
	}

	public NodeP setUltimo(NodeP ultimo) {
		this.ultimo = ultimo;
		return ultimo;
	}

	public int getIndices() {
		return indices;
	}

	public void setIndices(int indices) {
		this.indices = indices;
	}

	public int getQtdElementos() {
		return qtdElementos;
	}

	public void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}

}
