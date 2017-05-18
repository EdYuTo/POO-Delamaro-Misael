package grafo.grafo;

import java.util.Iterator;
import java.util.TreeSet;
import grafo.vertice.Vertice;
import grafo.aresta.Aresta;

public class Grafo extends TreeSet<Aresta> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6913966047160131711L;

	public Vertice[] dijkstra(String origem, String destino) {
		if (origem != null && destino != null) {
			int tam = Integer.MAX_VALUE;
			Iterator<Aresta> iterator = super.iterator();
			if (iterator.next().getOrigem().getNome() == origem && iterator.next().getValor() < tam)
				//faz ate achar menor caminho depois tem q fazer ate achar o caminho ate o destino...
		}
		return null;//erro
	}
}
