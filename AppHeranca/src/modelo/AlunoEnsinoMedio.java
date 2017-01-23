package modelo;

public final class AlunoEnsinoMedio extends Aluno{
	
	public boolean querDominarOMundo;
	
	public AlunoEnsinoMedio(String nome, int matricula) {
		super(nome, matricula);
		this.querDominarOMundo = true;
	}
	
	public String getSituacao(){
		if (media() >= 7){
			return "APROVADO";
		}else{
			return "REPROVADO";
		}
	}
	
	public boolean isLiso(){
		return true;
	}

	protected double media() {
		double med = (notas[0]*2 + notas[1]*3 + notas[2]*4)/9;
		return med;
	}
	
	public String toString(int a) {
		if (1 == 1)
			throw new RuntimeException("F%$S$");
		return "Agua";
	}

}
