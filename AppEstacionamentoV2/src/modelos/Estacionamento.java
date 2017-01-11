package modelos;

public class Estacionamento {
	
	private static Estacionamento estacionamento;
	
	private String nome;
	private Veiculo[] vagas;
	
	private Estacionamento(){
		this.nome = "R1 - Parking";
		this.vagas = new Veiculo[10];
	}
	
	//SINGLETON
	public static Estacionamento getInstance(){
		if (Estacionamento.estacionamento == null)
			Estacionamento.estacionamento = new Estacionamento();
		return estacionamento;
	}
	
	public boolean entrada(Veiculo veiculo){
		
		if (estaCheio() || (estacionado(veiculo) >= 0)){
			return false; //Esta cheio ou ja estacionado
		}
		
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] == null){
				vagas[i] = veiculo;
				break;
			}
				
		}
		
		return true;
	}
	
	public boolean saida(String placa){
		int pos = estacionado(placa);
		if ( pos >= 0){
			this.vagas[pos] = null;
			return true;
		}else{
			return false;
		}
	}
	
	public int estacionado(Veiculo veiculo){
		int pos = -1;
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null){
				if (vagas[i].getPlaca().equals(veiculo.getPlaca())){
					pos = i;
				}
			}
		}
		
		return pos;
	}
	
	public int estacionado(String placa){
		return estacionado(new Veiculo(placa, ""));
	}
	
	private boolean estaCheio() {
		for (Veiculo veiculo : vagas) {
			if (veiculo == null)
				return false;
		}
		return true;
	}

	public boolean entrada(String placa, String nome){
		Veiculo novoVeiculo = new Veiculo(placa, nome);
		boolean resultadoChamada = this.entrada(novoVeiculo);
		return resultadoChamada;
	}
	
	private String estado(){
		String resultado = "\n STATUS: \n";
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] == null){
				resultado += "Vaga " + i + ": livre.\n";
			}else {
				resultado += "Vaga " + i + ": " + vagas[i].getPlaca() + " - " + vagas[i].getNome() + "\n";
			}
		}
		return resultado;
	}
	
	public String toString() {
		return this.nome + estado();
	}
	

}








