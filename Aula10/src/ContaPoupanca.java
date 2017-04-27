

public class ContaPoupanca extends ContaBancaria {
	private int dia;
	
	public int getDia() {
		return dia;
	}

	public ContaPoupanca(String nome, int dia) {
		super(nome);
		this.dia = dia;
	}
	
	public void atualiza(double taxaR, int diaAtual) {
		if(diaAtual == dia)
			setSaldo(getSaldo()*(1 + taxaR));
	}
}
//fazer conta ouro e simples taxa da ouro + 1.5 e simples + 1, sendo subclasses e essa a super. usar abstract
