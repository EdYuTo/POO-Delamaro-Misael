
public class Exercicio2 {

	public static void main(String[] args) throws Exception {
		Random r1 = new Random();
		Random r2 = new Random();
		int a = 0, b = 1, count;
				
		for (count = 0; a != b; count++) {
			a = r1.getIntRand(501);//de [0 a 500]
			b = r2.getIntRand(501);
		}
		System.out.printf("Numero: %d em [%d] iteracoes\n", a, count);
	}
}
