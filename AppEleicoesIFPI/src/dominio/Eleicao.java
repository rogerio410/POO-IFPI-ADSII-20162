package dominio;

public class Eleicao {
	
	private String nome;
	private String campus;
	private int qtdDocentes;
	private int qtdTAE;
	private int qtdDiscentes;
	private Candidato[] candidatos;
	
	public Eleicao(int qDoc, int qTae, int qDis) {
		this.qtdDocentes = qDoc;
		this.qtdTAE = qTae;
		this.qtdDiscentes = qDis;
	}

}
