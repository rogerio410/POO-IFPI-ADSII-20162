package app;

import domain.Conta;

public class TestaConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta("Rogério da Silva");
		
		conta.depositar(17500);
		
		System.out.println(conta.getTitular());
		
		
		System.out.println(conta);
		
		
	}

}
