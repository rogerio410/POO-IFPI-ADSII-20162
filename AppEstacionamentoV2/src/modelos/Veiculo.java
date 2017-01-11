package modelos;

public class Veiculo {
	
	private String placa;
	private String nome;
	
	public Veiculo(String p, String m){
		this.placa = p;
		this.nome = m;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return "Veiculo: " + this.placa +" - " + this.nome;
	}

}
