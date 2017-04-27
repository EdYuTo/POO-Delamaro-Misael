package bozo.dados;

public class RolaDados {
	private Dado dados[];
	
	//rola todos os dados
	public int[] rolar() {
		int valores[] = new int[dados.length];
		
		for (int i = 0; i < dados.length; i++) {
			valores[i] = dados[i].rolar();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				;
			}
		}
		
		return valores;
	}
	
	public int[] rolar(boolean[] quais) {
		int valores[] = new int[dados.length];
		
		for (int i = 0; i < dados.length; i++) {
			if (quais[i]) {
				dados[i].rolar();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					;
				}
			}
			valores[i] = dados[i].getLado();
		}
		return valores;
	}

	public int[] rolar(String s) throws IllegalArgumentException {
		boolean quais[] = new boolean[dados.length];
		for (int i = 0; i < dados.length; i++)   //a principio nenhum sera rodado
			quais[i] = false;
		
		if (s != null && !s.isEmpty()) {   //se a string estiver vazia presume-se que nenhum dado sera rodado!
			String[] numeros = s.split("\\s");
				
			for (int i = 0; i < numeros.length; i++) {   //os dados sao representados de 1 para cima
				if (Integer.parseInt(numeros[i]) - 1 < dados.length && Integer.parseInt(numeros[i]) > 0)
					quais[Integer.parseInt(numeros[i]) - 1] = true;   //e as posicoes a partide de 0, por isso o -1
				//coloca true na posicao q representa o dado a ser rodado
				else throw new IllegalArgumentException("Posicçao inválida!");
			}
		}
		return rolar(quais);
	}

	public RolaDados(int n) {
		dados = new Dado[n];
		for (int i = 0; i < n; i++)
			dados[i] = new Dado();
	}
	
@Override 
	public String toString() {
		String s0 = "+-----+", s1 = "     ", s2 = "|     |", s3 = "|  *  |", s4 = "|*    |", s5 = "|    *|", 
				s6 = "|*   *|";
		String full = "";
		
		for (int i = 0; i < 6; i++) {   //cada linha dos dados
			for (int j = 0; j < dados.length; j++) {   //cada dado
				if (i == 0 && j == 0) {
					for (int k = 0; k < dados.length; k++) {
						full += "   ";
						full += Integer.toString(k+1);
						full += "   ";
						full += s1;
					}
				}
				else if (i == 1 || i == 5)   //1 e ultima linha dos dados
					full += s0;
				else if (i != 0) {
					if ((dados[j].getLado() == 1 || dados[j].getLado() == 3 || dados[j].getLado() == 5) && i == 3)
						full += s3;
					else if (dados[j].getLado() == 1 || ((dados[j].getLado() == 2 || dados[j].getLado() == 4) && i == 3))
						full += s2;
					else if ((dados[j].getLado() == 2 || dados[j].getLado() == 3) && i == 2)
						full += s4;
					else if ((dados[j].getLado() == 2 || dados[j].getLado() == 3) && i == 4)
						full += s5;
					else 
						full += s6;
				}
				if (j != dados.length - 1)
					full += s1;   //espaco entre os dados
			}
			full += "\n";
		}
		return full;
	}
/**
 *	+-----+     +-----+     +-----+     +-----+     +-----+     +-----+
 *  |     |     |*    |     |*    |     |*   *|     |*   *|     |*   *|
 *  |  *  |     |     |     |  *  |     |     |     |  *  |     |*   *|
 *  |     |     |    *|     |    *|     |*   *|     |*   *|     |*   *|
 *	+-----+     +-----+     +-----+     +-----+     +-----+     +-----+
 */
}
