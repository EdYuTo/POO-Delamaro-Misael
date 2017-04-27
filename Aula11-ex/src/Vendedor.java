/**
 * Classe que reprsenta o Vendedor
 * Implementa o metodo do salario do vendedor
 * @author Edson Toma - 9791305
 */
public class Vendedor extends Funcionario {
	private double comissao;

/**
 * Construtor da classe Vendedor
 * @param nome - nome do vendedor
 * @param cpf - cpf do vendedor
 * @param salarioBase - salario base
 * @param comissao - valor da comissao que o vendedor recebeu
 */
	public Vendedor(String nome, String cpf, double salarioBase, double comissao) {
		super(nome, cpf, salarioBase);
		this.comissao = comissao;
	}
	
/**
 * Funcao que retorna o salario do vendedor
 */
	public double calculaSalario() {
		return getSalarioBase() + comissao;
	}
}
