package dominio;

public class Votacao {
	
	private int qtdVotoDocente;
	private int qtdVotoTAE;
	private int qtdVotoDiscente;
	
	public Votacao(int vDoc, int vTae, int vDis) {
		this.qtdVotoDocente = vDoc;
		this.qtdVotoTAE = vTae;
		this.qtdVotoDiscente = vDis;
	}
	
	public int getQtdVotoDiscente() {
		return qtdVotoDiscente;
	}
	
	public int getQtdVotoDocente() {
		return qtdVotoDocente;
	}
	
	public int getQtdVotoTAE() {
		return qtdVotoTAE;
	}

}
