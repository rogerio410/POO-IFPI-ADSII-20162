package modelo;

public interface Mensuravel {
	
	double area();
	double perimetro();
	
	default String nome(){
		return this.getClass().getSimpleName();
	}

}
