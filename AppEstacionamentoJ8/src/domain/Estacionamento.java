package domain;

public class Estacionamento {
	
	private static Estacionamento instance;
	
	private String nome;
	private Veiculo[] vagas;
	private int pos = 0;
	
	private Estacionamento() {
		this.nome = "R1 Parking";
		this.vagas = new Veiculo[10];
	}
	
	public static Estacionamento getInstance(){
		
		if (Estacionamento.instance == null)
			Estacionamento.instance = new Estacionamento();
		
		return Estacionamento.instance;
	}
	
	public boolean entrada(Veiculo veiculo){
		//TODO
		if (!contem(veiculo.getPlaca())){
			//Faz a entrada de fato
			vagas[pos++] = veiculo;
			return true;
		}else {
			//Veiculo já estacionado.
			return false;
		}
	}
	
	public boolean saida(String placa){
		if (contem(placa)){
			//Procurar posicao e torna Null.
			return true;
		}else{
			return false;
		}
		
	}
	
	public Veiculo[] getVagas() {
		return vagas;
	}
	
	private boolean contem(String placa){
		for (Veiculo veiculo : vagas) {
			if (veiculo.getPlaca().equals(placa)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

}









