package grafo.grafo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import grafo.aresta.Aresta;
import grafo.vertice.Vertice;

public class GrafoTeste {

	@Test
	public void testDijkstra() throws IOException {
		int arestas;
		double valor;
		String origem, destino, saida;
		Grafo grafo = new Grafo();
		FileInputStream file = new FileInputStream(new File("1.in"));
		PrintStream out = new PrintStream(new File("1.out"));
	    Scanner entrada = new Scanner(file);
	
		arestas = entrada.nextInt();
		entrada.nextLine();//pega o '\n' q sobra do valor lido
		
		for (int i = 0; i < arestas; i++) {
			origem = entrada.nextLine();
			origem = origem.toLowerCase();//unificar
			
			destino = entrada.nextLine();
			destino = destino.toLowerCase();//unificar
			
			valor = entrada.nextDouble();
			entrada.nextLine();//pega o '\n' q sobra do valor lido
			
			grafo.add(new Aresta(new Vertice(origem), new Vertice(destino), valor));
		}
		
		origem = entrada.nextLine();
		origem = origem.toLowerCase();//unificar
		
		destino = entrada.nextLine();
		destino = destino.toLowerCase();//unificar
		
		System.setOut(out);
		System.out.print(grafo);
		System.out.print("Caminho: ");
		grafo.dijkstra(origem, destino);
		entrada.close();
		System.setOut(System.out);
		
		entrada = new Scanner(new File("1.out"));
		saida = entrada.useDelimiter("\\Z").next();//arquivo gerado pelo codigo
		entrada.close();
		
		assertEquals("[(Origem: a; Destino: b; Valor: 7.0), " +
				"(Origem: a; Destino: c; Valor: 9.0), " +
				"(Origem: b; Destino: c; Valor: 10.0), " +
				"(Origem: c; Destino: d; Valor: 11.0), " +
				"(Origem: a; Destino: f; Valor: 14.0), " +
				"(Origem: b; Destino: d; Valor: 15.0), " +
				"(Origem: c; Destino: f; Valor: 2.0), " +
				"(Origem: d; Destino: e; Valor: 6.0), " +
				"(Origem: f; Destino: e; Valor: 9.0)]" + "Caminho: a b c f e ", saida);
	}
}
