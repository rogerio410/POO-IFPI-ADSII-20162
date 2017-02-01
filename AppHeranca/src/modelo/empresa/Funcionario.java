package modelo.empresa;

public abstract class Funcionario {
	
	public double salario;
	
	public Funcionario(double s) {
		salario = s;
	}
	
	public double getBonus(){
		return 0.15 * this.salario;
	}

}
