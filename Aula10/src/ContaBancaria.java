public abstract class ContaBancaria {
	private static int conta = 0;
	private String nome;
	private int numero;
	private double saldo;
	
	public ContaBancaria(String nome) {
		this.nome = nome;
		this.numero = conta;
		conta++;
		this.saldo = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public boolean saca(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			return true;
		}
		return false;
	}
	
	public void deposita(double valor) {
		saldo += valor;
	}

@Override
	public String toString() {
		String pessoa = "";
		if (this instanceof ContaPoupanca)
			pessoa += "Conta Poupanca\n";
		else if (this instanceof ContaEspecial)
			pessoa += "Conta Especial\n";
		pessoa += "Nome: " + getNome() + "\n";
		pessoa += "Numero da Conta: " + Integer.toString(getNumero()) + "\n";
		if (this instanceof ContaPoupanca)
			pessoa += "Dia do rendimento: " + Integer.toString(((ContaPoupanca)this).getDia()) + "\n";
		else if (this instanceof ContaEspecial)
			pessoa += "Limite da conta: : " + Double.toString(((ContaEspecial)this).getLimite()) + "\n";
		pessoa += "Saldo: " + Double.toString(getSaldo());
		return pessoa;
	}
}
