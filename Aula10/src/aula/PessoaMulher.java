package aula;


public class PessoaMulher extends Pessoa {
	
	public PessoaMulher (double peso, double altura, int idade) {
		super(peso, altura, idade);
	}
	
	public String classificaObesidade() {
		double imc = getIMC();
		if (imc < 19.1)
			return "Abaixo do peso";
		else if (imc < 25.8)
			return "Peso normal";
		else if (imc < 27.3)
			return "Marginalmente acima do peso";
		else if (imc < 31.1)
			return "Acima do peso";
		else
			return "Obeso";
	}
}
