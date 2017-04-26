package geometrico;

public class Retangulo {
	private boolean filled;
	private double base, altura, perimetro, area;
	private String cor;
	
	public Retangulo(double base, double altura, String cor, boolean filled) {
		this.filled = filled;
		this.base = base;
		this.altura = altura;
		this.cor = cor;
		this.perimetro = 2*base + 2*altura;
		this.area = base*altura;
	}

	public boolean isFilled() {
		return filled;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
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
