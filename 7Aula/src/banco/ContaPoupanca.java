package banco;

public class ContaPoupanca extends ContaBancaria {
	private int dia;
	
	public int getDia() {
		return dia;
	}

	public ContaPoupanca(String nome, int numero, int dia) {
		super(nome, numero);
		this.dia = dia;
	}
	
	public void atualiza(double taxaR, int diaAtual) {
		if(diaAtual == dia)
			setSaldo(getSaldo()*(1 + taxaR));
	}
}
