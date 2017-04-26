package geometrico;

public class Quadrado {
	private boolean filled;
	private double lado, perimetro, area;
	private String cor;
	
	public Quadrado(double lado, String cor, boolean filled) {
		this.filled = filled;
		this.lado = lado;
		this.cor = cor;
		this.perimetro = 4*lado;
		this.area = lado*lado;
	}

	public boolean isFilled() {
		return filled;
	}

	public double getLado() {
		return lado;
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
