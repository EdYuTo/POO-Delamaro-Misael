
public class Exercicio1 {

	public static void main(String[] args) throws Exception {
		System.out.print("Digite um numero inteiro para 1 semente\n");
		int semente1 = EntradaTeclado.leInt();
		System.out.print("Digite um numero inteiro para 2 semente\n");
		int semente2 = EntradaTeclado.leInt();
		
		Random r1 = new Random(semente1);
		Random r2 = new Random(semente2);
		int a = 0, b = 1, count;
				
		for (count = 0; a != b; count++) {
			a = r1.getIntRand(501);//de [0 a 500]
			b = r2.getIntRand(501);
		}
		System.out.printf("Numero: %d em [%d] iteracoes\n", a, count);
	}
	
}
