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

	public int desenfileirar() {
		int retorno = (int) this.objects[0];
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

	public void print() {
		for (int i = 0; i < objects.length && objects[i] != null; i++) {
			System.out.print(this.objects[i] + ", ");
		}
		System.out.println();
	}

}