package br.fonseca.ED.estruturas.arvore;

public class ArvoreBinariaDeBusca {

	private NodeBinaria raiz;

	public boolean arvoreVazia() {
		return getRaiz() == null;
	}

	public NodeBinaria buscarElemento(Integer obj) {
		if (arvoreVazia()) {
			return null;
		} else {
			NodeBinaria aux = getRaiz();
			while (aux != null) {
				if (aux.getElemento().equals(obj)) {
					return aux;
				} else if (obj < aux.getElemento()) {
					aux = aux.getFilhoEsq();
				} else {
					aux = aux.getFilhoDir();
				}
			}
		}
		return null;
	}

	public void adicionarElemento(Integer obj) {
		NodeBinaria novo = new NodeBinaria();
		novo.setElemento(obj);
		if (!arvoreVazia()) {
			NodeBinaria aux = getRaiz();
			while (aux != null) {
				if (novo.getElemento() < aux.getElemento()) {
					if (aux.getFilhoEsq() == null) {
						aux.setFilhoEsq(novo);
						aux = null;
					} else {
						aux = aux.getFilhoEsq();
					}
				} else {
					if (aux.getFilhoDir() == null) {
						aux.setFilhoDir(novo);
						aux = null;
					} else {
						aux = aux.getFilhoDir();
					}
				}
			}
		} else {
			setRaiz(novo);
		}
	}

	public NodeBinaria removerElemento(Integer obj) {
		NodeBinaria removido = null;
		NodeBinaria folha = null;
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
					folha = removido.getFilhoEsq();
					if (pai.getFilhoEsq() == removido) {
						pai.setFilhoEsq(esquerda);
					} else {
						pai.setFilhoDir(esquerda);
					}
					while (folha.getFilhoDir() != null) {
						folha = folha.getFilhoDir();
					}
					folha.setFilhoDir(removido.getFilhoDir());
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
			NodeBinaria aux = getRaiz();
			while (aux != null) {
				if (aux.getFilhoDir().getElemento().equals(obj) || aux.getFilhoEsq().getElemento().equals(obj)) {
					return aux;
				} else if (obj < aux.getElemento()) {
					aux = aux.getFilhoEsq();
				} else {
					aux = aux.getFilhoDir();
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

class Pilha {

	private NodeBinaria[] objects;
	private Integer tamanhoMax;
	private Integer ultimaPosLivre;

	public Pilha(Integer tamanho) {
		this.objects = new NodeBinaria[tamanho];
		this.tamanhoMax = tamanho;
		this.ultimaPosLivre = 0;
	}

	public NodeBinaria pegarUltimo() {
		return this.objects[this.ultimaPosLivre - 1];
	}

	public boolean pilhaVazia() {
		return this.ultimaPosLivre <= 0;
	}

	private boolean pilhaCheia() {
		return this.ultimaPosLivre > tamanhoMax - 1;
	}

	public Integer quantidade() {
		return this.ultimaPosLivre;
	}

	public NodeBinaria top() {
		return this.ultimaPosLivre > 0 ? this.objects[this.ultimaPosLivre - 1] : this.objects[0];
	}

	public void zerarPilha() {
		while (!this.pilhaVazia()) {
			this.desempilhar();
		}
	}

	public void empilhar(NodeBinaria... e) {
		for (NodeBinaria i : e) {
			if (pilhaCheia())
				this.aumentarPilha();
			this.objects[this.ultimaPosLivre] = i;
			this.ultimaPosLivre++;
		}
	}

	public NodeBinaria desempilhar() {
		if (pilhaVazia()) {
			System.out.println("Pilha vazia!");
			return null;
		}
		NodeBinaria obj = this.objects[this.ultimaPosLivre - 1];
		this.ultimaPosLivre--;
		return obj;
	}

	public void inverter() {
		Pilha pAux = new Pilha(this.tamanhoMax);
		Integer posAux = this.ultimaPosLivre;
		while (!this.pilhaVazia())
			pAux.empilhar(this.desempilhar());
		this.ultimaPosLivre = posAux;
		this.objects = pAux.objects;
	}

	private void aumentarPilha() {
		NodeBinaria[] novoArray = new NodeBinaria[this.tamanhoMax * 2];
		for (Integer i = 0; i < this.objects.length; i++)
			novoArray[i] = this.objects[i];
		this.tamanhoMax = this.tamanhoMax * 2;
		this.objects = novoArray;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Integer i = 0; i < this.ultimaPosLivre; i++) {
			str.append(String.format("INDEX: %d POS: %d %s \n", i, (i + 1), this.objects[i]));
		}
		str.append(String.format("Último INDEX Livre: %d \n", this.ultimaPosLivre));
		return str.toString();
	}
}

class NodeBinaria {

	Integer elemento;

	NodeBinaria filhoEsq;

	NodeBinaria filhoDir;

	public Integer getElemento() {
		return elemento;
	}

	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}

	public NodeBinaria getFilhoEsq() {
		return filhoEsq;
	}

	public void setFilhoEsq(NodeBinaria filhoEsq) {
		this.filhoEsq = filhoEsq;
	}

	public NodeBinaria getFilhoDir() {
		return filhoDir;
	}

	public void setFilhoDir(NodeBinaria filhoDir) {
		this.filhoDir = filhoDir;
	}
}

class Lista {

	private NodeBinaria[] objects;
	private Integer tamanhoMax;
	private Integer ultimaPosLivre;

	public Lista(Integer tamanho) {
		this.objects = new NodeBinaria[tamanho];
		this.tamanhoMax = tamanho;
		this.ultimaPosLivre = 0;
	}

	private boolean listaVazia() {
		return this.ultimaPosLivre <= 0;
	}

	private boolean listaCheia() {
		return this.ultimaPosLivre > tamanhoMax - 1;
	}

	public void adicionar(Integer index, NodeBinaria obj) {
		if (arrayCheio()) {
			NodeBinaria[] aux = new NodeBinaria[index + 1];
			for (Integer i = 0; i < this.getUltimaPosLivre(); i++) {
				aux[i] = this.objects[i];
			}
			aux[index] = obj;
			this.ultimaPosLivre++;
			this.objects = aux;
		} else {
			for (Integer i = this.ultimaPosLivre - 1; i >= index; i++) {
				this.objects[i + 1] = this.objects[i];
			}
			this.objects[index] = obj;
			this.ultimaPosLivre++;
		}
	}

	public void adicionar(NodeBinaria obj) {
		if (arrayCheio()) {
			NodeBinaria[] aux = new NodeBinaria[objects.length * 2];
			for (Integer i = 0; i < this.getUltimaPosLivre(); i++) {
				aux[i] = this.objects[i];
			}
			aux[this.ultimaPosLivre] = obj;
			this.ultimaPosLivre++;
			this.objects = aux;
		} else {
			this.objects[this.ultimaPosLivre] = obj;
			this.ultimaPosLivre++;
		}
	}

	public boolean contem(Integer obj) {
		for (NodeBinaria nd : objects) {
			if (nd.getElemento().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	public void zerar() {
		this.objects = new NodeBinaria[this.getUltimaPosLivre()];
		this.ultimaPosLivre = 0;
	}

	public boolean arrayCheio() {
		return this.getUltimaPosLivre() == objects.length;
	}

	public void remove(NodeBinaria obj) {
		for (Integer i = pegarIndice(obj); i < this.ultimaPosLivre; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.ultimaPosLivre--;
	}

	public Integer pegarIndice(NodeBinaria obj) {
		Integer index = 0;
		for (Integer i = 0; this.objects[i] != obj; i++) {
			index++;
		}
		return index;
	}

	public boolean contem(NodeBinaria o) {
		for (int i = 0; i < this.ultimaPosLivre; i++) {
			if (this.objects[i].equals(o))
				return true;
		}
		return false;
	}

	public NodeBinaria pegar(Integer index) {
		return index <= 0 ? this.objects[0]
				: index >= this.ultimaPosLivre ? this.objects[this.index()] : this.objects[index];
	}

	public NodeBinaria pegarMeio() {
		if (this.ultimaPosLivre <= 0)
			throw new ArrayIndexOutOfBoundsException("Indice fora dos limites do array!");
		return (this.ultimaPosLivre) % 2 == 0 ? this.objects[((this.index()) / 2) + 1]
				: this.objects[((this.index()) / 2)];
	}

	private Integer index() {
		return this.ultimaPosLivre <= 0 ? this.ultimaPosLivre : this.ultimaPosLivre - 1;
	}

	public void trocarFimComeco() {
		Integer valorMin = 0;
		Integer valorMax = this.getTamanhoMax() + 1;
		NodeBinaria ultimo = this.pegar(valorMax);
		NodeBinaria primeiro = this.pegar(valorMin);
		this.substituir(0, ultimo);
		this.substituir(this.index(), primeiro);
	}

	public void substituir(Integer index, NodeBinaria o) {
		this.objects[index] = o;
	}

	private void aumentarLista() {
		NodeBinaria[] novoArray = new NodeBinaria[this.tamanhoMax * 2];
		for (Integer i = 0; i < this.objects.length; i++)
			novoArray[i] = this.objects[i];
		this.tamanhoMax = this.tamanhoMax * 2;
		this.objects = novoArray;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Integer i = 0; i < this.ultimaPosLivre; i++)
			str.append(String.format("INDEX: %d POS: %d Objeto: %s \n", i, (i + 1), this.objects[i]));
		str.append(String.format("Ultimo INDEX Livre: %d \n", this.ultimaPosLivre));
		return str.toString();
	}

	public NodeBinaria[] getObjects() {
		return objects;
	}

	public void setObjects(NodeBinaria[] objects) {
		this.objects = objects;
	}

	public Integer getTamanhoMax() {
		return tamanhoMax;
	}

	public void setTamanhoMax(Integer tamanhoMax) {
		this.tamanhoMax = tamanhoMax;
	}

	public Integer getUltimaPosLivre() {
		return this.ultimaPosLivre;
	}

	public void setUltimaPosLivre(Integer ultimaPosLivre) {
		this.ultimaPosLivre = ultimaPosLivre;
	}

	public void print() {
		for (Integer i = 0; i < this.ultimaPosLivre; i++) {
			if (i < this.ultimaPosLivre - 1) {
				System.out.print(this.objects[i] + ", ");
			} else {
				System.out.print(this.objects[i]);
			}
		}
	}

}

class Fila {
	private NodeBinaria[] objects;
	private int tamanhoMax;
	private int ultimaPosLivre;

	public Fila(int tamanhoMax) {
		this.objects = new NodeBinaria[tamanhoMax];
		this.tamanhoMax = tamanhoMax;
		this.ultimaPosLivre = 0;
	}

	public NodeBinaria retornarComeco() {
		return this.objects[0];
	}

	public void enfileirar(NodeBinaria... o) {
		for (NodeBinaria i : o) {
			if (filaCheia())
				this.aumentarFila();
			this.objects[this.ultimaPosLivre] = i;
			this.ultimaPosLivre++;
		}
	}

	public NodeBinaria desenfileirar() {
		NodeBinaria retorno = this.objects[0];
		for (int i = 0; i < this.getIndex(); i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.ultimaPosLivre--;
		return retorno;
	}

	public int quantidade() {
		return this.ultimaPosLivre;
	}

	public boolean filaVazia() {
		return this.ultimaPosLivre <= 0;
	}

	private boolean filaCheia() {
		return this.ultimaPosLivre > tamanhoMax - 1;
	}

	private int getIndex() {
		return this.ultimaPosLivre - 1;
	}

	private void aumentarFila() {
		NodeBinaria[] novoArray = new NodeBinaria[this.tamanhoMax * 2];
		for (int i = 0; i < this.objects.length; i++)
			novoArray[i] = this.objects[i];
		this.tamanhoMax = this.tamanhoMax * 2;
		this.objects = novoArray;
	}

}