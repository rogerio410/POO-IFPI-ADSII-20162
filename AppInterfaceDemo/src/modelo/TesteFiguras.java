package modelo;

public class TesteFiguras {
	
	public static void main(String[] args) {
		
		FiguraHelper fh = new FiguraHelper();
		Circulo c = new Circulo(15);
		Quadrado q = new Quadrado(15);
		
		Mensuravel[] figuras = {c, q};
		
		for (Mensuravel m : figuras) {
			fh.printAreaEPerimetro(m);
		}
		
	}

}
