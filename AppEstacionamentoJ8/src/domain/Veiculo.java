package domain;

public class Veiculo {
	
	private String placa;
	private String descricao;
	
	public Veiculo(String placa, String descricao) {
		this.placa = placa;
		this.descricao = descricao;
	}
	
	public String getPlaca() {
		return placa;
	}

	public String toString() {
		return "Veiculo [placa=" + placa + ", descricao=" + descricao + "]";
	}
	
	
	

}
