import java.io.FileReader;
import java.util.HashMap;

public class ContaPalavra {
	private File;
	private HashMap<String, Integer> palavras;
	
	public ContaPalavra(String nome) {
		try {
			FileReader file = new FileReader(nome);
			texto += file.toString();
			palavras = new HashMap<String, Integer>();
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void criaMapa() {
		
	}
	
	public void verMapa() {
		
	}
}
