
public class PessoaMulher extends Pessoa {
	
	public PessoaMulher (double peso, double altura, int idade) {
		super(peso, altura, idade);
	}
	
	public String classificaObesidade() {
		double imc = getIMC();
		
		return Double.toString(imc);
	}
}
