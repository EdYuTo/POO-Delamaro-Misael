/**
 * Classe desenhada para se comportar como um baralho de 52 cartas.
 * Ela implementa metodos para distribuir cartas, embaralhar e trocar cartas com o baralho
 * @author Bruno Flavio - 9791330
 */
public class Baralho {
	private Carta cartas[] = new Carta[52];
	private int pos = 0; // Marca quais posições do baralho ja foram entregues

	/**
	 * Construtor do Baralho, inicializa todas as cartas do baralho em sequencia
	 * de 2 a As e de ouros a paus
	 */
	public Baralho() {
		int i = 0;

		//Com esses dois laços são adicionados em sequencia uma carta de cada naipe
		for (int naipe = 0; naipe < 4; naipe++) {
			for (int valor = 2; valor <= 14; valor++) {
				cartas[i] = new Carta(valor, naipe);
				i++;
			}
		}

	}

	/**
	 * Metodo que reinicia o baralho (recolhe as cartas) e embaralha
	 */
	public void embaralhar() {
		Random r = new Random();
		pos = 0; //Recolhe o baralho

		//Percorre todo baralho trocando a carta com uma posição aleatória
		for (int i = 0; i < 52; i++) {
			int rpos = r.getIntRand(52);
			// Swap
			Carta aux = cartas[rpos];
			cartas[rpos] = cartas[i];
			cartas[i] = aux;
		}
	}

	/**
	 * Metodo que distribui as cartas do baralho
	 * @param n - Inteiro com o numero de cartas a ser distribuido
	 * @return Carta[] - Vetor com as cartas distribuidas
	 * @throws IllegalArgumentException - Se o parametro n for maior que a capacidade atual do baralho
	 */
	private Carta[] darCartas(int n) throws IllegalArgumentException{
		Carta ret[] = new Carta[n];

		if(n > 52 - pos) throw new IllegalArgumentException("O baralho não possui cartas suficientes");

		for (int i = 0; i < n; i++) {
			ret[i] = cartas[pos]; //Coloca no vetor a proxima carta do baralho
			pos++;
		}

		return ret;
	}

	/**
	 * Metodo que distribui 5 cartas do baralho para uma Mao
	 * @param m - Mao que recebera as cartas
	 * @throws IllegalArgumentException - Se o baralho nao tiver cartas suficientes
	 */
	public void darCartas(Mao m) throws IllegalArgumentException{
		m.setCartas(darCartas(5));
	}

	/**
	 * Metodo que recolhe ao baralho um vetor de cartas e as trocam com novas cartas
	 * @param cartas - Vetor do tipo Carta, que contem as cartas a serem trocadas
	 */
	public void trocarCartas(Carta[] cartas){
	    //Percorre o vetor recebido e troca as cartas com as proximas do baralho
		for(int i = 0; i < cartas.length; i++){
			cartas[i] = this.cartas[pos]; //Coloca a proxima carta do baralho no vetor
			pos++;
		}
	}

	/**
	 * Metodo usado somente para debug
	 * @param args - Sem utilidade
	 */
	public static void main(String[] args) throws Exception {
		Baralho b = new Baralho();
		Carta cartas[] = b.darCartas(52);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
			System.out.println(cartas[i].toString());
		}

		b.embaralhar();
		b.trocarCartas(cartas);

		for (int i = 0; i < 52; i++) {
			System.out.println(cartas[i].getValor() + " " + cartas[i].getNaipe());
		}

	}

}
