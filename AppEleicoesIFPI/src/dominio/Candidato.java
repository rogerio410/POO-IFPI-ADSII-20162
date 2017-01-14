package dominio;

public class Candidato {
	
	private String nome;
	private int numero;
	private String sexo; //Enum
	private String slogan;
	private Votacao votacao;
	
	public Candidato(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	public Votacao getVotacao() {
		return votacao;
	}
	
	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	@Override
	public String toString() {
		return this.nome + " ("+ this.numero + ")";
	}
	
	

}
