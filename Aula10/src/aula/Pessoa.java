package aula;


public abstract class Pessoa {
	
	private int idade;
	private double peso, altura;
	
	public Pessoa(double peso, double altura, int idade) {
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getIdade() {
		return idade;
	}
	
	public double getIMC() {
		return peso / (altura * altura);
	}
	
	public abstract String classificaObesidade();
}
