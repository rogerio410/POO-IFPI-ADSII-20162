package modelo;

public class Quadrado implements Mensuravel {
	
	private int lado;
	
	public Quadrado(int lado) {
		this.lado = lado;
	}
	
	public double area(){
		return lado*lado;
	}
	
	public double perimetro() {
		return 4 * this.lado;
	}
	
}
