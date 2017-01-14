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
		this.candidatos = new Candidato[3];
	}
	
	public boolean addCandidato(Candidato c){ //Decisao: o candidato já vem com votacao
		if (!cheio() && !numeroRepetido(c)){
			for (int i = 0; i < candidatos.length; i++) {
				if (candidatos[i] == null){
					candidatos[i] = c;
					return true;
				}
			}
		}
		return false;
	}

	private boolean numeroRepetido(Candidato c) {
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero() == c.getNumero())
				return true;
		}
		return false;
	}

	private boolean cheio() {
		for (Candidato candidato : candidatos) {
			if (candidato == null)
				return false;
		}
		return true;
	}
	
	public double percentualCandidato(Candidato c){
		double percentual;
		percentual = percentualVotoDocente(c);
		percentual += percentualVotoDiscente(c);
		percentual += percentualVotoTAE(c);
		return percentual;
	}
	
	public double percentualVotoDocente(Candidato c){
		return calculaPercentualSegmento(c.getVotacao().getQtdVotoDocente(), this.qtdDocentes);
	}
	
	public double percentualVotoTAE(Candidato c){
		return calculaPercentualSegmento(c.getVotacao().getQtdVotoTAE(), this.qtdTAE);
	}
	
	public double percentualVotoDiscente(Candidato c){
		return calculaPercentualSegmento(c.getVotacao().getQtdVotoDiscente(), this.qtdDiscentes);
	}
	
	private double calculaPercentualSegmento(int votos, int total){
		double percentual;
		percentual = (double) votos / total * 1/3;
		return percentual;
	}
	
	public Candidato vencedor(){
		Candidato campeao;
		campeao = this.candidatos[0];
		for (Candidato candidato : candidatos) {
			if (candidato != null){
				if (percentualCandidato(candidato) > percentualCandidato(campeao)){
					campeao = candidato;
				}
			}
		}
		return campeao;
	}

}
