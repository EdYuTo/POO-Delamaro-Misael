package grafo.aresta;

import grafo.vertice.Vertice;

public class Aresta {
	private Vertice origem, destino;
	private double valor;
	
	public Aresta(Vertice origem, Vertice destino, double valor) {
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public double getValor() {
		return valor;
	}
}
