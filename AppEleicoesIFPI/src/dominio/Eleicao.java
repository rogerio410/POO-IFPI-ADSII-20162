package dominio;

public class Eleicao {
	
	private String nome;
	private String campus;
	private int qtdDocentes;
	private int qtdTAE;
	private int qtdDiscentes;
	private Candidato[] candidatos;
	
	public Eleicao(int qCand, int qDoc, int qTae, int qDis) {
		this.qtdDocentes = qDoc;
		this.qtdTAE = qTae;
		this.qtdDiscentes = qDis;
		this.candidatos = new Candidato[qCand];
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public boolean removeCandidato(int index){
		
		if (index < 0 || index >= this.candidatos.length)
			return false;
		
		this.candidatos[index] = null;
		
		return true;
	}

	private boolean numeroRepetido(Candidato c) {
		for (Candidato candidato : candidatos) {
			if (candidato != null)
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
		return percentual * 100;
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
	
	private boolean dadosConsistentes() {
		//Numeros de votos superiores aos permitidos individual ou globalmente.
		//Se nao houver candidato tb.
		
		int totalPermitido = this.qtdDocentes + this.qtdTAE + this.qtdDiscentes;
		int totalSomado = 0;
		int qtdCandidados = 0;
		
		for (Candidato c : candidatos) {
			
			if (c == null)
				continue;
			
			int totalCandidato = c.getVotacao().getQtdVotoDocente() 
					+ c.getVotacao().getQtdVotoTAE() 
					+ c.getVotacao().getQtdVotoDiscente();
			if (totalCandidato > totalPermitido)
				return false;
			
			totalSomado += totalCandidato;
			qtdCandidados++;
		}
		
		if (totalSomado > totalPermitido)
			return false;
		
		//Se nao há candidatos
		if (qtdCandidados == 0)
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		
		if (!dadosConsistentes()){
			return "Dados inconsistentes. ";
		}
		
	 	String res = "Eleição " + this.nome + "\n\n";
		res += "candidado / doc / tae / dic / % final \n";
		
		for (Candidato c : candidatos) {
			double pDoc = percentualVotoDocente(c);
			double pTae = percentualVotoTAE(c);
			double pDisc = percentualVotoDiscente(c);
			int qDoc = c.getVotacao().getQtdVotoDocente();
			int qTae = c.getVotacao().getQtdVotoTAE();
			int qDisc = c.getVotacao().getQtdVotoDiscente();
			double total = percentualCandidato(c);
			
			res += String.format("%s / %.1f%%(%d) / %.1f%%(%d) / %.1f%%(%d)  == %.1f %%\n\n", c, pDoc, qDoc, pTae, qTae, pDisc, qDisc, total);
			
		}
		
		res += String.format("VENCENDOR: " + vencedor() + " --> %.1f %%", percentualCandidato(vencedor()) );
		
		return res;
	}

	

}
