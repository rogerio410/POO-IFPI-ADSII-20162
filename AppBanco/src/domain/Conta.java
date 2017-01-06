package domain;

public class Conta {
	
	private static int ultimoNumero = 0;
	
	private int numero;
	private Titular titular;
	private double saldo;
	private String telefone;

	Conta(String titular) {
		this.titular = new Titular(titular);
		this.numero = obterNumero(); 
	}

	private int obterNumero() {
		return ++Conta.ultimoNumero;
	}
	
	public void depositar(double valor){
		this.saldo += valor;
	}
	
	public String getTitular(){
		return this.titular.getNome();
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	@Override
	public String toString() {
		return "Conta [n.= "+this.numero + " titular=" + titular + ", saldo=" + saldo + "]";
	}
	
	

}
