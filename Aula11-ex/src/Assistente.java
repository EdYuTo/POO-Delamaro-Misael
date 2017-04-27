/**
 * Classe que representa o assistente
 * Implementa o metodo do salario do assistente
 * @author Edson Toma - 9791305
 */
public class Assistente extends Funcionario {
	
/**
 * Construtor da classe Assistente	
 * @param nome - nome do assistente
 * @param cpf - cpf do assistente
 * @param salarioBase - salario base
 */
	public Assistente(String nome, String cpf, double salarioBase) {
		super(nome, cpf, salarioBase);
	}
	
/**
 * Funcao que retorna o salario do assistente
 */
	public double calculaSalario() {
		return getSalarioBase();
	}
}