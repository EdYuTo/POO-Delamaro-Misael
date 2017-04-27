

public class ContaEspecial extends ContaBancaria {
	private double limite;
	
	public double getLimite() {
		return limite;
	}

	public ContaEspecial(double limite, String nome) {
		super(nome);
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
