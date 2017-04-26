
public class Factorial {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int a = -1, fac = 1;
		
		while (a < 0) {
			try {
				a = EntradaTeclado.leInt();
			} catch (Exception e){
				a = -1;
			}		
		}
		while (a > 0) {
			fac *= a--;	
		}
		System.out.printf("%d\n", fac);
	}
}
