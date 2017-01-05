package domain;

public class Titular {
	
	private String tratamento;
	private String nome;
	private String telefone;
	private String endereco;
	
	public Titular(String nome) {
		this.nome = nome;
		this.tratamento = "Sr(a)";
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.tratamento + " " + this.nome;
	}
	
	public String toString() {
		return getNome();
	}

}
