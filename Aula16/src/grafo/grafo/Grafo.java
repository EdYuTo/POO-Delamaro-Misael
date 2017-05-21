package grafo.grafo;

import java.util.Iterator;
import java.util.TreeSet;
//import grafo.vertice.Vertice;
import grafo.aresta.Aresta;

public class Grafo extends TreeSet<Aresta> {
	
	private static final long serialVersionUID = 6913966047160131711L; //compilador que pediu...
	
	public void dijkstra(String origem, String destino) {
		if (origem != null && destino != null) {
			System.out.print(origem + " ");
			if (!origem.equals(destino)) {
				double tam = Double.MAX_VALUE;
				String proximo = "";
				Aresta aux;
				Iterator<Aresta> iterator = super.iterator();
				while (iterator.hasNext()) {
					aux = iterator.next();
					if (aux.getOrigem().getNome().equals(origem) && aux.getValor() < tam) {
						tam = aux.getValor();
						proximo = aux.getDestino().getNome();
					}
				}
				if (proximo != null && !proximo.isEmpty())
					this.dijkstra(proximo, destino);
			}
		}
		return;
	}
}
