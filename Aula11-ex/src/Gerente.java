/**
 * Classe que representa o gerente
 * Implementa o metodo do salario do gerente
 * @author Edson Toma - 9791305
 */
public class Gerente extends Funcionario {
	
/**
 * Construtor da classe Gerente	
 * @param nome - nome do gerente
 * @param cpf - cpf do gerente
 * @param salarioBase - salario base
 */
	public Gerente(String nome, String cpf, double salarioBase) {
		super(nome, cpf, salarioBase);
	}
/**
 * Funcao que retorna o salario do gerente
 */
	public double calculaSalario() {
		return 2 * getSalarioBase();
	}
}
