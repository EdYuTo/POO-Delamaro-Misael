
public class Agenda {
	private Pessoa[] contatos;
	int atual;
	boolean ordenado;
	
	public Agenda (int ncontatos) {
		contatos = new Pessoa[ncontatos];
		atual = 0;
		ordenado = false;
	}
	
	public void visualizarContatos() {
		ordenarContatos();
		for (int i = 0; i < atual; i++) {
			if (contatos[i] instanceof PessoaFisica)
				System.out.println(((PessoaFisica)contatos[i]).toString());
			else if (contatos[i] instanceof PessoaJuridica)
				System.out.println(((PessoaJuridica)contatos[i]).toString());
			else
				System.out.println(contatos[i].toString());
		}
	}
	
	private PessoaFisica criarPessoaFisica() throws Exception {
		String estado, data, nome, cpf, endereco, email;
		System.out.println("Digite o nome da pessoa:\n");
		nome = EntradaTeclado.leString();
		System.out.println("Digite o estado civil da pessoa:\n");
		estado = EntradaTeclado.leString();
		System.out.println("Digite a data de nascimento:\n");
		data = EntradaTeclado.leString();
		System.out.println("Digite o cpf:\n");
		cpf = EntradaTeclado.leString();
		System.out.println("Digite o endereco:\n");
		endereco = EntradaTeclado.leString();
		System.out.println("Digite o email:\n");
		email = EntradaTeclado.leString();
		PessoaFisica pessoa = new PessoaFisica(estado, data, nome, cpf, endereco, email);
		return pessoa;
	}
	
	private PessoaJuridica criarPessoaJuridica() throws Exception {
		String estadual, social, nome, cnpj, endereco, email;
		System.out.println("Digite o nome da pessoa juridica:\n");
		nome = EntradaTeclado.leString();
		System.out.println("Digite a inscricao estadual da pessoa juridica:\n");
		estadual = EntradaTeclado.leString();
		System.out.println("Digite a razao social:\n");
		social = EntradaTeclado.leString();
		System.out.println("Digite o cnpj:\n");
		cnpj = EntradaTeclado.leString();
		System.out.println("Digite o endereco:\n");
		endereco = EntradaTeclado.leString();
		System.out.println("Digite o email:\n");
		email = EntradaTeclado.leString();
		PessoaJuridica pessoa = new PessoaJuridica(estadual, social, nome, cnpj, endereco, email);
		return pessoa;
	}
	
	public boolean addContato(String tipo) {
		tipo.toLowerCase();
		try {
			if (atual < contatos.length) {
				if (tipo.equals("fisica") || tipo.equals("física")) {
					contatos[atual++] = criarPessoaFisica();
					ordenado = false;
					return true;
				}
				else if (tipo.equals("juridica") || tipo.equals("jurídica")) {
					contatos[atual++] = criarPessoaJuridica();
					ordenado = false;
					return true;  
				} else {
					System.out.println("Pessoa invalida!\n");
					return false;
				}
			} else {
				System.out.println("Agenda cheia!\n");
				return false;
			}
		} catch (Exception e) {
				System.out.println("Erro, tente novamenta mais tarde...\n");
				return false;
		}
	}
	
	public boolean removeContato(String string) {
		int i;
		for (i = 0; i < atual && !string.equals(contatos[i].getCpfcnpj()) && !string.equals(contatos[i].getNome()); i++);//para no contato a ser removido
		if (i != atual) {
			while (i+1 != atual) {
				contatos[i] = contatos[i+1];
				i++;
			}
			atual--;
			contatos[atual] =  null;
			return true;
		} else {
			System.out.println("Contato nao encontrado!\n");
			return false;
		}
	}
	
	public Pessoa buscaContato(String string) {//1-cpf/cnpj 0-nome
		int i;
		for (i = 0; i < atual && !string.equals(contatos[i].getCpfcnpj()) && !string.equals(contatos[i].getNome()); i++);//para no contato a ser removido
		return i != atual ? contatos[i] : null;
	}
	
	public void ordenarContatos() {
		if (!ordenado) {
			for (int i = 0; i < atual-1; i++)
				for (int j = i+1; j < atual; j++)
					if (contatos[i] instanceof PessoaJuridica && contatos[j] instanceof PessoaFisica) {
						Pessoa aux = contatos[i];
						contatos[i] = contatos[j];
						contatos[j] = aux;
					}
		
			for (int i = 0; i < atual-1; i++)
				for (int j = i+1; j < atual; j++)
					if (contatos[i].cpfcnpjToLong() > contatos[j].cpfcnpjToLong() && contatos[i] instanceof PessoaFisica == contatos[j] instanceof PessoaFisica) {
						Pessoa aux = contatos[i];
						contatos[i] = contatos[j];
						contatos[j] = aux;
					}
			ordenado = true;
		}
	}
}
