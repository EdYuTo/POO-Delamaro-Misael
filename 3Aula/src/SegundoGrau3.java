
public class SegundoGrau3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		double a = 0, b = 0, c = 0;
		while (!flag) {
			try {
				a = EntradaTeclado.leDouble();
				flag = true;
			} catch (Exception e){
				flag =  false;
			}
		}
		while (flag) {
			try {
				b = EntradaTeclado.leDouble();
				flag = false;
			} catch (Exception e){
				flag =  true;
			}
		}
		while (!flag) {
			try {
				c = EntradaTeclado.leDouble();
				flag = true;
			} catch (Exception e){
				flag =  false;
			}
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
