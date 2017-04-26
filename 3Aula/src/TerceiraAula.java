
public class TerceiraAula {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		double a, b, c;
		try {
			a = EntradaTeclado.leDouble();
			b = EntradaTeclado.leDouble();
			c = EntradaTeclado.leDouble();
		} catch (Exception e){
			System.out.println("O valor digitado n�o � um double");
			return;
		}
		
		double d = b*b - (4*a*c);
		
		if ( a != 0) {
			if (d >= 0) {
				d = Math.sqrt(b*b - (4*a*c));
				System.out.println((-b+d)/2*a);
				System.out.println((-b-d)/2*a);
			} else {
				System.out.println("Sem ra�zes reais");
			}
		} else {
			System.out.println("N�o � equa��o do 2 grau");
		}
	}

}
