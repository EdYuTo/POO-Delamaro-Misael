package banco;

public class Contas {

	public static void main(String[] args) throws Exception {
		int count = 0;
		ContaBancaria contas[] = new ContaBancaria[100];
		String comando = "";
		
		while (!(comando.equals("sair"))) {
			System.out.println("Digite um comando\n");
			comando = EntradaTeclado.leString();
			comando = comando.toLowerCase();
			if (comando.equals("help"))
				System.out.println("Digite 'add' para incluir uma nova conta\nDigite 'saq' para efetuar um saque\nDigite 'dep' para efetuar um deposito\n"
						+ "Digite 'dia' para atualizar o valor de todas as contas poupacas em um determinado dia\nDigite 'show' para mostrar os valores das contas\n");
			else if (comando.equals("add")) {
				if (count < 100) {
					System.out.println("Que tipo de conta deseja criar? Poupanca ou Especial?\n");
					comando = EntradaTeclado.leString();
					comando = comando.toLowerCase();
					if (comando.equals("poupança") || comando.equals("poupanca")) {
						System.out.println("Digite seu nome:\n");
						comando = EntradaTeclado.leString();
						System.out.println("Digite o numero da conta\n");
						int numero = EntradaTeclado.leInt();
						System.out.println("Digite o dia do rendimento\n");
						contas[count++] = new ContaPoupanca(comando, numero, EntradaTeclado.leInt()); 
					} else if (comando.equals("especial")) {
						System.out.println("Digite seu nome:\n");
						comando = EntradaTeclado.leString();
						System.out.println("Digite limite da conta\n");
						double limite = EntradaTeclado.leDouble();
						System.out.println("Digite o numero da conta\n");
						contas[count++] = new ContaEspecial(limite, comando, EntradaTeclado.leInt());
					}
				}
				else
					System.out.println("Oops, algo deu errado! Talvez nossos bancos não queiram você...\n");
			} else if (comando.equals("dep")) {
				System.out.println("Digite o numero da conta:\n");
				int i, numeroConta = EntradaTeclado.leInt();
				for (i = 0; i < count && contas[i].getNumero() != numeroConta; i++);
				if (i == count)
					System.out.println("Conta não encontrada...\n");
				else {
					System.out.println("Digite e valor do deposito:\n");
					double valor = EntradaTeclado.leDouble();
					contas[i].deposita(valor);
				}
			} else if (comando.equals("saq")) {
				System.out.println("Digite o numero da conta:\n");
				int i, numeroConta = EntradaTeclado.leInt();
				for (i = 0; i < count && contas[i].getNumero() != numeroConta; i++);
				if (i == count)
					System.out.println("Conta não encontrada...\n");
				else {
					System.out.println("Digite e valor do saque:\n");
					double valor = EntradaTeclado.leDouble();
					if (contas[i] instanceof ContaEspecial)
						if (!((ContaEspecial)contas[i]).saca(valor))
							System.out.println("Saldo insuficiente!\n");
					else if (contas[i] instanceof ContaPoupanca)
						if(!contas[i].saca(valor))
							System.out.println("Saldo insuficiente!\n");
				}
			} else if (comando.equals("dia")) {
				System.out.println("Digite o dia:\n");
				int dia = EntradaTeclado.leInt();
				for (int i = 0; i < count; i++)
					if (contas[i] instanceof ContaPoupanca)
						if (dia == ((ContaPoupanca)contas[i]).getDia()) {
							System.out.println("Digite a taxa para conta numero " + contas[i].getNumero());
							((ContaPoupanca)contas[i]).atualiza(EntradaTeclado.leDouble(), dia);
						}
			} else if (comando.equals("show")) {
				for (int i = 0; i < count; i++)
					System.out.println("---------------\n" + contas[i].toString() + "\n---------------\n");
			} else if (!comando.equals("sair"))
				System.out.println("Comando nao encontrado, digite 'help' para ver os comandos...\n");
		}
		
	}

}
