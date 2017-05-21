package grafo.main;

import java.util.Scanner;
import grafo.aresta.Aresta;
import grafo.grafo.Grafo;
import grafo.vertice.Vertice;

public class Main {

	public static void main(String[] args) {
		int arestas;
		double valor;
		Grafo grafo = new Grafo();
		String origem = "", destino = "";
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Digite o numero de arestas:");
		if (keyboard.hasNextInt()) {
			arestas = keyboard.nextInt();
			keyboard.nextLine();//pega o '\n' q sobra do valor lido
		} else {
			System.out.println("Digite um inteiro valido.");
			keyboard.close();
			return;
		}
		
		for (int i = 0; i < arestas; i++) {
			System.out.println("Digite a origem da aresta " + i + ":");
			origem = keyboard.nextLine();
			origem = origem.toLowerCase();//unificar
			
			System.out.println("Digite o destino da aresta " + i + ":");
			destino = keyboard.nextLine();
			destino.toLowerCase();//unificar
			
			System.out.println("Digite o valor da aresta " + i + ":");
			valor = keyboard.nextDouble();
			keyboard.nextLine();//pega o '\n' q sobra do valor lido
			
			grafo.add(new Aresta(new Vertice(origem), new Vertice(destino), valor));
		}
		//System.out.println(grafo);
		System.out.println("Digite o vertice origem:");
		origem = keyboard.nextLine();
		origem = origem.toLowerCase();//unificar
		
		System.out.println("Digite o vertice destino:");
		destino = keyboard.nextLine();
		destino = destino.toLowerCase();//unificar
		
		System.out.print("Caminho: ");
		grafo.dijkstra(origem, destino);
		keyboard.close();
	}
}
