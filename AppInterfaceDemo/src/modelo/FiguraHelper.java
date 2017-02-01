package modelo;

public class FiguraHelper {
	
	public void printAreaEPerimetro(Mensuravel fg){
		System.out.printf("Figura: %s\n", fg.nome());
		System.out.printf("\tArea: %.2f\n", fg.area());
		System.out.printf("\tPerimetro: %.2f\n", fg.perimetro());
	}
	
}
