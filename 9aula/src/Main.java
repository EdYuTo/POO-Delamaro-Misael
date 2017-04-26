
public class Main {

	public static void main(String[] args) {
		String comando = "";
		Agenda agenda = new Agenda(200);
		
		System.out.println("Digite 'add' para adicionar um contato.\nDigite 'rem' para remover um contato.\n"
				+ "Digite 'show' para mostrar os contatos.\nDigite 'search' para buscar um contato.\n"
				+ "Digite 'sair' para sair.\nDigite 'help' para mostrar os comandos.\n");
		
		while (!comando.equals("sair")) {
			try {
				comando = EntradaTeclado.leString();
				comando.toLowerCase();
			} catch (Exception e) {
				System.out.println("Erro!\n");
			}
			
			if (comando.equals("add")) {
				try {
					System.out.println("Deseja adicionar uma pessoa fisica ou juridica?\n");
					comando = EntradaTeclado.leString();
					comando.toLowerCase();
					if (agenda.addContato(comando))
						System.out.println("Pessoa adicionada com sucesso!\n");
				} catch (Exception e) {
					System.out.println("Erro!\n");
				}
			} else if (comando.equals("rem")) {
				try {
					System.out.println("Digite o nome ou o cpf do contato a ser removido:\n");
					comando = EntradaTeclado.leString();
					comando.toLowerCase();
					if (agenda.removeContato(comando))
						System.out.println("Contato removido com sucesso.\n");
				} catch (Exception e) {
					System.out.println("Erro!\n");
				}
			} else if (comando.equals("show")) {
				agenda.visualizarContatos();
			} else if (comando.equals("search")) {
				try {
					System.out.println("Digite o nome ou o cpf do contato a ser procurado:\n");
					comando = EntradaTeclado.leString();
					Pessoa aux = agenda.buscaContato(comando);
					if (aux instanceof PessoaFisica)
						System.out.println(((PessoaFisica)aux).toString());
					else if (aux instanceof PessoaJuridica)
						System.out.println(((PessoaJuridica)aux).toString());
					else
						System.out.println(aux.toString());
				} catch (Exception e) {
					System.out.println("Erro!\n");
				}
			} else if (comando.equals("help"))
				System.out.println("Digite 'add' para adicionar um contato.\nDigite 'rem' para remover um contato.\n"
						+ "Digite 'show' para mostrar os contatos.\nDigite 'search' para buscar um contato.\n"
						+ "Digite 'sair' para sair.\nDigite 'help' para mostrar os comandos.\n");
			else if (comando.equals("ord"))
				agenda.ordenarContatos();
			else if (!comando.equals("sair"))
				System.out.println("Comando nao encontrado, digite 'help' para ver a lista de comandos...\n");
		}
	}

}
