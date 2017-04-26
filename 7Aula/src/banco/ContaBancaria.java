package banco;

public class ContaBancaria {
	private String nome;
	private int numero;
	private double saldo;
	
	public ContaBancaria(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
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
		pessoa += "Nome: " + getNome() + "\n";
		pessoa += "Numero da Conta: " + Integer.toString(getNumero()) + "\n";
		pessoa += "Saldo: " + Double.toString(getSaldo());
		return pessoa;
	}
}
