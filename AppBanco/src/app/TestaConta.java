package app;

import domain.Banco;
import domain.Conta;

public class TestaConta {
	
	public static void main(String[] args) {
		
		Banco r1bank = Banco.getInstance();
		System.out.println(r1bank);
		
		Conta conta = r1bank.novaConta("Rogério da Silva");
		conta.depositar(17500);
		
		Conta conta2  = r1bank.novaConta("Kassio Jose");
		conta2.depositar(-1000);
		
		Conta conta3  = r1bank.novaConta("Maria");
		conta3.depositar(-1000);
		
		System.out.println(conta);
		System.out.println(conta2);
		System.out.println(conta3);
		
		
	}

}
