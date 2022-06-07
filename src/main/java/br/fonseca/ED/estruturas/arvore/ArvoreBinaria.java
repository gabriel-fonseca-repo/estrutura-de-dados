package br.fonseca.ED.estruturas.arvore;

public class ArvoreBinaria {

	private NodeBinaria raiz;

	public boolean arvoreVazia() {
		return getRaiz() == null;
	}

	public NodeBinaria buscarElemento(Integer obj) {
		if (arvoreVazia()) {
			return null;
		} else {
			Pilha pilha = new Pilha(999);
			pilha.empilhar(getRaiz());
			while (!pilha.pilhaVazia()) {
				NodeBinaria aux = pilha.desempilhar();
				if (aux.getElemento().equals(obj)) {
					return aux;
				}
				if (aux.getFilhoEsq() != null) {
					pilha.empilhar(aux.getFilhoEsq());
				}
				if (aux.getFilhoDir() != null) {
					pilha.empilhar(aux.getFilhoDir());
				}
			}
		}
		return null;
	}

	public void adicionarEsquerda(Integer obj, Integer node) {
		NodeBinaria nodeBin = new NodeBinaria();
		nodeBin.setElemento(obj);
		if (!arvoreVazia()) {
			NodeBinaria nodePai = buscarElemento(node);
			if (nodePai != null) {
				if (nodePai.getFilhoEsq() == null) {
					nodePai.setFilhoEsq(nodeBin);
				} else {
					System.out.println("Node " + nodePai + " já possui filho à esquerda");
				}
			} else {
				System.out.println("Elemento " + node + " inexistente na árvore");
			}
		} else {
			setRaiz(nodeBin);
		}
	}

	public void adicionarDireita(Integer obj, Integer node) {
		NodeBinaria nodeBin = new NodeBinaria();
		nodeBin.setElemento(obj);
		if (!arvoreVazia()) {
			NodeBinaria nodePai = buscarElemento(node);
			if (nodePai != null) {
				if (nodePai.getFilhoDir() == null) {
					nodePai.setFilhoDir(nodeBin);
				} else {
					System.out.println("Node " + nodePai + " já possui filho à esquerda");
				}
			} else {
				System.out.println("Elemento " + node + " inexistente na árvore");
			}
		} else {
			setRaiz(nodeBin);
		}
	}

	public NodeBinaria removerElemento(Integer obj) {
		NodeBinaria removido = null;
		if (!arvoreVazia()) {
			removido = buscarElemento(obj);
			if (removido != null) {
				NodeBinaria esquerda = removido.getFilhoEsq();
				NodeBinaria direita = removido.getFilhoDir();
				NodeBinaria pai = buscarPai(obj);
				if (esquerda == null && direita == null) {
					if (pai.getFilhoEsq().equals(removido)) {
						pai.setFilhoEsq(null);
					} else {
						pai.setFilhoDir(null);
					}
				} else if (esquerda != null && direita != null) {
					if (pai.getFilhoEsq().equals(removido)) {
						pai.setFilhoEsq(esquerda);
						while (esquerda.getFilhoEsq() != null) {
							esquerda = esquerda.getFilhoEsq();
						}
						esquerda.setFilhoEsq(direita);
					} else {
						pai.setFilhoDir(direita);
						while (direita.getFilhoDir() != null) {
							direita = direita.getFilhoDir();
						}
						direita.setFilhoEsq(esquerda);
					}
				} else {
					if (pai.getFilhoEsq().equals(removido)) {
						if (esquerda == null) {
							pai.setFilhoEsq(direita);
						} else {
							pai.setFilhoEsq(esquerda);
						}
					} else {
						if (direita == null) {
							pai.setFilhoDir(esquerda);
						} else {
							pai.setFilhoDir(direita);
						}
					}
				}
			}
		} else {
			System.out.println("Estrutura vazia!");
		}
		return removido;
	}

	public NodeBinaria buscarPai(Integer obj) {
		if (arvoreVazia()) {
			return null;
		} else {
			Pilha pilha = new Pilha(999);
			pilha.empilhar(getRaiz());
			while (!pilha.pilhaVazia()) {
				NodeBinaria aux = pilha.desempilhar();
				if (aux.getFilhoDir().getElemento().equals(obj) || aux.getFilhoEsq().getElemento().equals(obj)) {
					return aux;
				}
				if (aux.getFilhoEsq() != null) {
					pilha.empilhar(aux.getFilhoEsq());
				}
				if (aux.getFilhoDir() != null) {
					pilha.empilhar(aux.getFilhoDir());
				}
			}
		}
		return null;
	}

	public Lista varreduraLargura() {
		Lista lista = new Lista(999);
		if (arvoreVazia()) {
			return null;
		} else {
			Fila fila = new Fila(999);
			fila.enfileirar(getRaiz());
			while (!fila.filaVazia()) {
				NodeBinaria aux = fila.desenfileirar();
				lista.adicionar(aux);
				if (aux.getFilhoEsq() != null) {
					fila.enfileirar(aux.getFilhoEsq());
				}
				if (aux.getFilhoDir() != null) {
					fila.enfileirar(aux.getFilhoDir());
				}
			}
		}
		return lista;
	}

	public Lista varreduraProfundidadeVlr() {
		Lista lista = new Lista(999);
		if (arvoreVazia()) {
			return null;
		} else {
			Pilha pilha = new Pilha(999);
			pilha.empilhar(getRaiz());
			while (!pilha.pilhaVazia()) {
				NodeBinaria aux = pilha.desempilhar();
				lista.adicionar(aux);
				if (aux.getFilhoEsq() != null) {
					pilha.empilhar(aux.getFilhoEsq());
				}
				if (aux.getFilhoDir() != null) {
					pilha.empilhar(aux.getFilhoDir());
				}
			}
		}
		return lista;
	}

	public Lista varreduraProfundidadeLvr() {
		Lista lista = new Lista(999);
		if (arvoreVazia()) {
			return null;
		} else {
			Pilha pilha = new Pilha(999);
			NodeBinaria aux = getRaiz();
			pilha.empilhar(aux);
			while (!pilha.pilhaVazia()) {
				aux = pilha.desempilhar();
				if (aux.getFilhoEsq() != null) {
					pilha.empilhar(aux.getFilhoEsq());
				}
				if (aux != null && !lista.contem(aux)) {
					pilha.empilhar(aux.getFilhoEsq());
					lista.adicionar(0, aux);
					if (aux.getFilhoDir() != null) {
						pilha.empilhar(aux.getFilhoDir());
						aux = aux.getFilhoDir();
					}
				}
			}
		}
		return lista;
	}

	public NodeBinaria getRaiz() {
		return raiz;
	}

	public void setRaiz(NodeBinaria raiz) {
		this.raiz = raiz;
	}

}
