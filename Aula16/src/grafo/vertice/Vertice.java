package grafo.vertice;

public class Vertice implements Comparable<Vertice> {
	private String nome;
	
	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int compareTo(Vertice outro) {
		return this.nome.compareTo(outro.nome);
	}
	
@Override
	public String toString() {
		return (nome);
	}
}
