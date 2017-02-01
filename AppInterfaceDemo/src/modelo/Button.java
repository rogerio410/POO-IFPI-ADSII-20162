package modelo;

public class Button {
	
	private String label;
	private Escutador escutador;
	
	public Button() {
	}
	
	public Button(String label) {
		this.label = label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void clicar(){
		escutador.onClick();
	}
	
	public void setEscutador(Escutador escutador) {
		this.escutador = escutador;
	}
	
}
