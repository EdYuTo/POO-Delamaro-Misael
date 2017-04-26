
public class TerceiraAula {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		double a, b, c;
		try {
			a = EntradaTeclado.leDouble();
			b = EntradaTeclado.leDouble();
			c = EntradaTeclado.leDouble();
		} catch (Exception e){
			System.out.println("O valor digitado não é um double");
			return;
		}
		
		double d = b*b - (4*a*c);
		
		if ( a != 0) {
			if (d >= 0) {
				d = Math.sqrt(b*b - (4*a*c));
				System.out.println((-b+d)/2*a);
				System.out.println((-b-d)/2*a);
			} else {
				System.out.println("Sem raízes reais");
			}
		} else {
			System.out.println("Não é equação do 2 grau");
		}
	}

}
