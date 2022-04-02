package br.fonseca.ED.estruturas;

public class Fila {
	private Object[] objects;
	private int tamanhoMax;
	private int ultimaPosLivre;

	public Fila(int tamanhoMax) {
		this.objects = new Object[tamanhoMax];
		this.tamanhoMax = tamanhoMax;
		this.ultimaPosLivre = 0;
	}

	public Object retornarComeco() {
		return this.objects[0];
	}

	public void enfileirar(Object... o) {
		for (Object i : o) {
			if (filaCheia())
				this.aumentarFila();
			this.objects[this.ultimaPosLivre] = i;
			this.ultimaPosLivre++;
		}
	}

	public void desenfileirar() {
		for (int i = 0; i < this.ultimaPosLivre - 1; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.ultimaPosLivre--;
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

	public void inverterFilaComPilha() {
		PilhaFila pilha = new PilhaFila(this.tamanhoMax);
		int qtd = this.ultimaPosLivre;
		for (int i = 0; i < qtd; i++) {
			pilha.empilhar(this.retornarComeco());
			this.desenfileirar();
		}
		for (int i = 0; i < qtd; i++) {
			this.enfileirar(pilha.pegarUltimo());
			pilha.desempilhar();
		}
	}

	public void inverterFilaComFila() {
		Object[] obj = new Object[this.ultimaPosLivre];
		int qtd = this.ultimaPosLivre;
		for (int i = qtd - 1; i >= 0; i--) {
			obj[i] = this.retornarComeco();
			this.desenfileirar();
		}
		this.objects = obj;
		this.ultimaPosLivre = qtd;
	}

	public void imprimirFilaAoContrario() {
		this.inverterFilaComPilha();
		System.out.println(this);
		this.inverterFilaComPilha();
	}

	public void removerCauda(int qtdRemover) {
		if (qtdRemover > this.ultimaPosLivre) {
			throw new ArrayIndexOutOfBoundsException("Ã�ndice maior que a quantidade de itens no array!");
		}
		this.inverterFilaComPilha();
		for (int i = 0; i < qtdRemover; i++) {
			this.desenfileirar();
		}
		this.inverterFilaComPilha();
	}

	private void aumentarFila() {
		Object[] novoArray = new Object[this.tamanhoMax * 2];
		for (int i = 0; i < this.objects.length; i++)
			novoArray[i] = this.objects[i];
		this.tamanhoMax = this.tamanhoMax * 2;
		this.objects = novoArray;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.ultimaPosLivre; i++) {
			str.append(String.format("INDEX: %d POS: %d %s \n", i, (i + 1), this.objects[i]));
		}
		str.append(String.format("Ãšltimo INDEX Livre: %d \n", this.ultimaPosLivre));
		return str.toString();
	}

	static class PilhaFila {

		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < this.ultimaPosLivre; i++) {
				str.append(String.format("INDEX: %d POS: %d %s \n", i, (i + 1), this.objects[i]));
			}
			str.append(String.format("Ãšltimo INDEX Livre: %d \n", this.ultimaPosLivre));
			return str.toString();
		}

		private Object[] objects;
		private int tamanhoMax;
		private int ultimaPosLivre;

		public PilhaFila(int tamanho) {
			this.objects = new Object[tamanho];
			this.tamanhoMax = tamanho;
			this.ultimaPosLivre = 0;
		}

		public Object pegarUltimo() {
			return this.objects[this.ultimaPosLivre - 1];
		}

		private boolean pilhaVazia() {
			return this.ultimaPosLivre <= 0;
		}

		private boolean pilhaCheia() {
			return this.ultimaPosLivre > tamanhoMax - 1;
		}

		private int quantidade() {
			return this.ultimaPosLivre;
		}

		public void empilhar(Object... e) {
			for (Object i : e) {
				if (pilhaCheia())
					this.aumentarPilha();
				this.objects[this.ultimaPosLivre] = i;
				this.ultimaPosLivre++;
			}
		}

		public void desempilhar() {
			if (pilhaVazia()) {
				System.out.println("Lista vazia!");
				return;
			}
			this.objects[this.ultimaPosLivre - 1] = null;
			this.ultimaPosLivre--;
		}

		private void aumentarPilha() {
			Object[] novoArray = new Object[this.tamanhoMax * 2];
			for (int i = 0; i < this.objects.length; i++)
				novoArray[i] = this.objects[i];
			this.tamanhoMax = this.tamanhoMax * 2;
			this.objects = novoArray;
		}

	}

}