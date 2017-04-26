
public class PessoaFisica extends Pessoa {
	private String estadocivil, nascimento;
	
	public PessoaFisica(String estadocivil, String nascimento, String nome, String cpfcnpj, String endereco, String email) {
		super(nome, cpfcnpj, endereco, email);
		this.estadocivil = estadocivil;
		this.nascimento = nascimento;
	}
	
	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
@Override
	public String toString() {
		String pessoa = "-------------\nPESSOA FISICA\n";
		pessoa += "NOME: " + this.getNome() + "\nCPF: " + this.getCpfcnpj() + "\nENDERECO: " + this.getEndereco();
		pessoa += "\nEMAIL: " + this.getEmail() + "\nESTADO CIVIL: " + estadocivil + "\nDATA DE NASCIMENTO: " + nascimento + "\n";
		return pessoa + "-------------\n";
	}
}
