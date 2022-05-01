package br.fonseca.ED.beecrowd.pilha;

import java.util.Objects;
import java.util.Scanner;

public class beecrowd_1077 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Pilha p1 = new Pilha();
			Pilha p2 = new Pilha();
			String linha = sc.nextLine();
			String[] expressao = linha.split("");
			for (int j = 0; j < expressao.length; j++) {
				if (p2.checaPrecedencia(expressao[j]) == -1) {
					p2.empilhar(expressao[j]);
				} else if (p2.checaPrecedencia(expressao[j]) == 0) {
					p1.empilhar(expressao[j]);
				} else if (p2.checaPrecedencia(expressao[j]) == -2) {
					while (!Objects.equals(p2.topo(), "(")) {
						p1.empilhar(p2.topo());
						p2.desempilhar();
					}
					if (Objects.equals(p2.topo(), "(")) {
						p2.desempilhar();
					}
				} else {
					if (p2.tamanho() == 0) {
						p2.empilhar(expressao[j]);
					} else if (p2.checaPrecedencia(p2.topo()) == -1) {
						p2.empilhar(expressao[j]);

					} else if (p2.checaPrecedencia(p2.topo()) < p2.checaPrecedencia(expressao[j])) {
						p2.empilhar(expressao[j]);
					} else {
						while (p2.topo() != null && p2.checaPrecedencia(p2.topo()) >= p2.checaPrecedencia(expressao[j])
								&& p2.checaPrecedencia(p2.topo()) > 0) {
							p1.empilhar(p2.topo());
							p2.desempilhar();
						}
						p2.empilhar(expressao[j]);
					}
				}
			}
			while (p2.tamanho() != 0) {
				p1.empilhar(p2.topo());
				p2.desempilhar();
			}
			while (p1.tamanho() != 0) {
				p2.empilhar(p1.topo());
				p1.desempilhar();
			}
			p2.mostrar();
		}
		sc.close();
	}
}

class NodeSE {

	private String conteudo;
	private NodeSE proximo;
	NodeSE anterior;

	public NodeSE(String dado) {
		this.setConteudo(dado);
		this.setProximo(null);
		this.anterior = null;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public NodeSE getProximo() {
		return proximo;
	}

	public void setProximo(NodeSE proximo) {
		this.proximo = proximo;
	}

}

class Pilha {
	private int qtdElementos = 0;
	private NodeSE topo = null;

	public int tamanho() {
		return getQtdElementos();
	}

	public void empilhar(String dado) {
		NodeSE novo = new NodeSE(dado);
		if (getTopo() == null) {
			setTopo(novo);
		} else {
			getTopo().setProximo(novo);
			novo.anterior = getTopo();
			setTopo(novo);
		}
		setQtdElementos(getQtdElementos() + 1);
	}

	public void desempilhar() {
		if (tamanho() > 1) {
			getTopo().anterior.setProximo(null);
			setTopo(getTopo().anterior);
		} else {
			setTopo(null);
		}
		setQtdElementos(getQtdElementos() - 1);
	}

	public String topo() {
		if (tamanho() != 0) {
			return getTopo().getConteudo();
		} else {
			return null;
		}

	}

	public void mostrar() {
		NodeSE aux = getTopo();
		while (aux != null) {
			System.out.print(aux.getConteudo());
			aux = aux.anterior;
		}
		System.out.println();

	}

	public int checaPrecedencia(String elemento) {
		if (Objects.equals(elemento, "+") || Objects.equals(elemento, "-")) {
			return 1;
		} else if (Objects.equals(elemento, "/") || Objects.equals(elemento, "*")) {
			return 2;
		} else if (Objects.equals(elemento, "^")) {
			return 3;
		} else if (Objects.equals(elemento, "(")) {
			return -1;
		} else if (Objects.equals(elemento, ")")) {
			return -2;
		} else {
			return 0;
		}
	}

	public int getQtdElementos() {
		return qtdElementos;
	}

	public void setQtdElementos(int qtdElementos) {
		this.qtdElementos = qtdElementos;
	}

	public NodeSE getTopo() {
		return topo;
	}

	public void setTopo(NodeSE topo) {
		this.topo = topo;
	}

}
