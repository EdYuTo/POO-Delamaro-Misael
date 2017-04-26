package banco;

public class ContaEspecial extends ContaBancaria {
	private double limite;
	
	public ContaEspecial(double limite, String nome, int numero) {
		super(nome, numero);
		this.limite = limite;
	}
	
@Override
	public boolean saca(double valor) {
		if (getSaldo() - valor >= -limite) {
			setSaldo(getSaldo()-valor);
			return true;
		}
		return false;
	}

}
