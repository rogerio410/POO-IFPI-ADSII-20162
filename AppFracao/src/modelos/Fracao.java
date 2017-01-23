package modelos;

public class Fracao {
	
	private int numerador;
	private int denominador;
	
	public Fracao() {
		this.numerador = 0;
		this.denominador = 1;
	}
	
	public Fracao(int n, int d){
		this.numerador = n;
		this.denominador = d;
	}
	
	public boolean equivalente(Fracao outraFracao){
		if (this.decimal() == outraFracao.decimal()){
			return true;
		}else {
			return false;
		}
			
	}
	
	
	public static Fracao minimo(Fracao f1, Fracao f2){
		if (f1.decimal() < f2.decimal()){
			return f1;
		}else{
			return f2;
		}
	}
	
	
	public double decimal(){
		return (double) (this.numerador / this.denominador);
	}
	

}







