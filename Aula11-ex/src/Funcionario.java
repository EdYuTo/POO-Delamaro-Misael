/**
 * Classe base com metodos calculaSalario() e verificaCPF()
 * Armazena nome, cpf e salario base;
 * @author Edson Toma - 9791305
 */
public abstract class Funcionario {
	private String nome;
	private String CPF;
	private double salarioBase;
	
/**
 * Construtor da classe
 * @param nome - nome do funcionario
 * @param cpf - cpf do funcionario
 * @param salarioBase - salario base
 */
	public Funcionario(String nome, String cpf, double salarioBase) {
		this.nome = nome;
		CPF = cpf;
		this.salarioBase = salarioBase;
	}
	
/**
 * 	Getters and Setters
 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

/**
 * Retorna o salario...OBS: Sera sobreescrito nas classes filhas
 */
	public abstract double calculaSalario();

/**
 * Funcao que verifica se o cpf e valido
 * @param cpf - string com cpf
 * @return - true (valido) ou false (invalido)
 */
	public static boolean verificaCPF(String cpf) {
		if (cpf != null && !cpf.isEmpty() && cpf.length() > 10 && cpf.length() < 16) { 
			String sub[] = cpf.split("\\D"); //tudo menos numero
			String numerocpf = "";
			int digitos[] = new int[11];
			
			for (int i = 0; i < sub.length; i++)
				numerocpf += sub[i];
			if (numerocpf.length() != 11) return false;
			
			for (int i = 0; i < digitos.length; i++)
				digitos[i] = Integer.parseInt(numerocpf.substring(i, i+1));
			
			int soma = 0, verificador1, verificador2;
			
			for (int i = 0; i < 9; i++)
				soma += (10-i) * digitos[i];
			verificador1 = 11 - (soma % 11) < 10 ? 11 - (soma % 11) : 0; //checagem do digito 0
			
			soma = 0;
			for (int i = 0; i < 10; i++)
				soma += (11-i) * digitos[i];
			verificador2 = 11 - (soma % 11) < 10 ? 11 - (soma % 11) : 0; //checagm do digito 0
			
			return digitos[9] == verificador1 && digitos[10] == verificador2 ? true : false; //checagem dos digitos
		}
		return false; //erro
	}
}
