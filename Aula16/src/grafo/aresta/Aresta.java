package grafo.aresta;

import grafo.vertice.Vertice;

public class Aresta implements Comparable<Aresta> {
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
	
	public int compareTo(Aresta outra) {
		if (this.origem.compareTo(outra.origem) + this.destino.compareTo(outra.destino) + Double.compare(this.valor, outra.valor) == 0)
			return this.origem.compareTo(outra.origem) - this.destino.compareTo(outra.destino) + Double.compare(this.valor, outra.valor);
		return this.origem.compareTo(outra.origem) + this.destino.compareTo(outra.destino) + Double.compare(this.valor, outra.valor);
	}
	
@Override
	public String toString() {
		return ("(Origem: " + origem.toString() + "; Destino: " + destino.toString() + "; Valor: " + valor + ")");
	}
}
