
public class PessoaJuridica extends Pessoa {
	private String inscricao, razao;
	
	public PessoaJuridica(String inscricao, String razao, String nome, String cpfcnpj, String endereco, String email) {
		super(nome, cpfcnpj, endereco, email);
		this.inscricao = inscricao;
		this.razao = razao;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}
	
@Override
	public String toString() {
		String pessoa = "-------------\nPESSOA JURIDICA\n";
		pessoa += "NOME: " + this.getNome() + "\nCNPJ: " + this.getCpfcnpj() + "\nENDERECO: " + this.getEndereco();
		pessoa += "\nEMAIL: " + this.getEmail() + "\nINSCRICAO ESTADUAL: " + inscricao + "\nRAZAO SOCIAL: " + razao + "\n";
		return pessoa + "-------------\n";
	}
}
