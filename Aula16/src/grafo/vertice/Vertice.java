package grafo.vertice;

public class Vertice {
	private String nome;
	private static int quantidade = 0;
	
	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public static int getQuantidade() {
		return quantidade;
	}
}
