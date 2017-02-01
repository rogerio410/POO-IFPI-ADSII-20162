package modelo;

public class Passageiro implements Comparable{
	
	private String nome;
	private int categoria; // 1, 2, 3
	private int diasDeMembro;
	
	public Passageiro(String nome, int cat, int dias) {
		this.nome = nome;
		this.categoria = cat;
		this.diasDeMembro = dias;
	}
	
	@Override
	public String toString() {
		return this.nome + "-" +" cat/dias: "+this.categoria+"/"+this.diasDeMembro;
	}

	@Override
	public int compareTo(Object o) {
		Passageiro p = (Passageiro)o;
		if (this.categoria > p.categoria){
			return -1;
		}else if (this.categoria < p.categoria){
			return 1;
		}else{
			if (this.diasDeMembro > p.diasDeMembro){
				return -1;
			}else if (this.diasDeMembro < p.diasDeMembro){
				return 1;
			}else{
				return 0;
			}
			
		}
	}

}






