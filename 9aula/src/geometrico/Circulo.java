package geometrico;

public class Circulo {
	private boolean filled;
	private double raio, perimetro, area;
	private String cor;
	
	public Circulo(double raio, String cor, boolean filled) {
		this.filled = filled;
		this.raio = raio;
		this.cor = cor;
		this.perimetro = 2 * Math.PI * raio;
		this.area = Math.PI * raio * raio;
	}

	public boolean isFilled() {
		return filled;
	}

	public double getRaio() {
		return raio;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public double getArea() {
		return area;
	}

	public String getCor() {
		return cor;
	}
	
}
