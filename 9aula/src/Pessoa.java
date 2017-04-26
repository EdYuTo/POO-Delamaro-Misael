
public class Pessoa {
	private String nome, cpfcnpj, endereco, email;
	
	public Pessoa(String nome, String cpfcnpj, String endereco, String email) {
		this.nome = nome;
		this.cpfcnpj = cpfcnpj;
		this.endereco = endereco;
		this.email = email;
	}

	public long cpfcnpjToLong() {
		if (cpfcnpj != null && !cpfcnpj.isEmpty()) {
			String sub[] = cpfcnpj.split("\\D");//tudo menos numeros
			String numero = "";
			
			for (int i = 0; i < sub.length; i++)
				numero += sub[i];
						
			return numero != null && !numero.isEmpty() ? Long.parseLong(numero) : -1;
		}
		return -1;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

/*---usados caso exista uma funcao atualizarDados()
 * 
 *	public void setNome(String nome) {
 *		this.nome = nome;
 *	}
 *
 *	public void setCpfcnpj(String cpfcnpj) {
 *		this.cpfcnpj = cpfcnpj;
 *	}
 *
 *	public void setEndereco(String endereco) {
 *		this.endereco = endereco;
 *	}
 *
 *	public void setEmail(String email) {
 *		this.email = email;
 *	}
*/
@Override
	public String toString() {
		return "Pessoa nao encontrada!\n";
	}
}
