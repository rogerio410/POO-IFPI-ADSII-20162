package modelo.empresa;

public class Gerente extends Funcionario{

	public Gerente(double s) {
		super(s);
	}
	
	public double getBonus() {
		return super.getBonus() + 15000;
	}
	

}
