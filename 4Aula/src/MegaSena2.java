
public class MegaSena2 {

	public static void main(String[] args) throws Exception {
		//Random r = new Random();
		
		System.out.print("Digite um numero inteiro para semente\n");
		int semente = EntradaTeclado.leInt();
		Random r = new Random(semente);
		//r.xi = semente;
		//r.setSemente(semente);
		
		for (int i = 0; i < 6; i++) {
			int k = r.getIntRand(60) + 1;
			System.out.printf("%d ", k);
		}
		System.out.printf("\n");
	}
}
