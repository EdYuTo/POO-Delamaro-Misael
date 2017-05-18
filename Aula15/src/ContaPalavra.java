import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContaPalavra {
	private File file;
	private Scanner scanner;
	private HashMap<String, Integer> palavras;
	
	public ContaPalavra(String nome) {
		try {
			file = new File(nome);
			scanner = new Scanner(file);
			palavras = new HashMap<String, Integer>();
			scanner.useDelimiter("\\W");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void criaMapa() {
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();
			if (palavras.containsKey(word)) {
				int count = palavras.get(word);
				palavras.put(word, count+1);
			} else {
				palavras.put(word, 1);
			}
		}
	}
	
	public void verMapa() {
		Set <String> Keys = palavras.keySet();
		TreeSet<String> sortedKeys = new TreeSet<String> (Keys);
		System.out.println("Mapa contem:\nChave\t\tValor");
		for (String key : sortedKeys)
			System.out.printf("%-20s%10d\n", key, palavras.get(key));
	}
	
	public static void main(String[] args) {
		ContaPalavra a = new ContaPalavra("ContaPalavra.class");
		a.criaMapa();
		a.verMapa();
	}
}