package modelo;

public class Circulo implements Mensuravel {
	
	private int raio;
	
	public Circulo(int raio) {
		this.raio = raio;
	}
	
	public double calcularArea(){
		return Math.PI * this.raio * this.raio;
	}
	
	@Override
	public double area() {
		return calcularArea();
	}
	
	@Override
	public double perimetro() {
		return 2 * Math.PI * this.raio;
	}
	
}
