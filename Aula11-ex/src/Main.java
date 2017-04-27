
public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Digite o numero de funcionarios");
		int n = EntradaTeclado.leInt();
		Funcionario funcionarios[] = new Funcionario[n];
		double salarioBase;
		String nome = "", cpf = "", tipo = "";
		
		try {
			System.out.println("Digite o salario base dos funcionarios:");
			salarioBase = EntradaTeclado.leDouble();
		} catch (Exception e) {
			System.out.println("erro");
			return;
		}
		
		for (int i = 0; i < n;) {
			try {
				System.out.println("Qual o tipo de funcionario? gerente, assistente ou vendedor?");
				tipo = EntradaTeclado.leString();
				System.out.println("Digite o nome:");
				nome = EntradaTeclado.leString();
				System.out.println("Digite o cpf:");
				cpf = EntradaTeclado.leString();
				tipo = tipo.toLowerCase();
			} catch (Exception e) {
				System.out.println("erro");
			}
			if (Funcionario.verificaCPF(cpf)) {
				if (tipo.equals("gerente"))
					funcionarios[i++] = new Gerente(nome, cpf, salarioBase);
				else if (tipo.equals("assistente"))
					funcionarios[i++] = new Assistente(nome, cpf, salarioBase);
				else if (tipo.equals("vendedor")) {
					System.out.println("Digite o valor da comissao:");
					funcionarios[i++] = new Vendedor(nome, cpf, salarioBase, EntradaTeclado.leDouble());
				}
			} else
				System.out.println("cpf invalido");
		}
		
		for (int i = 0; i < n; i++) {
			if (funcionarios[i] != null) {
				System.out.println("-----");
				System.out.println(funcionarios[i].getNome());
				System.out.println(funcionarios[i].calculaSalario());
				System.out.println("-----");
			}
		}
	}
}
