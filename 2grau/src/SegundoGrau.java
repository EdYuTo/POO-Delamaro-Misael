
public class SegundoGrau {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		double a = EntradaTeclado.leDouble();
		double b = EntradaTeclado.leDouble();
		double c = EntradaTeclado.leDouble();

		double d = Math.sqrt(b*b - (4*a*c));
		
		if ( a != 0) {
			if (d >= 0) {
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
