package modelo;

public class MeuEscutador implements Escutador{
	
	@Override
	public void onClick() {
		System.out.println("Clicou mesmo...");
	}
}