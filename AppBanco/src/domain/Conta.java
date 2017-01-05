package domain;

public class Conta {
	
	private Titular titular;
	private double saldo;
	private String telefone;

	public Conta(String titular) {
		this.titular = new Titular(titular);
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
	
	@Override
	public String toString() {
		return "Conta [titular=" + titular + ", saldo=" + saldo + "]";
	}
	
	

}
