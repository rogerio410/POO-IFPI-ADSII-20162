package domain;

import domain.Conta;

public class Banco {
	
	private static Banco instancia;
	
	private Conta[] contas;
	private String nome = "R1Bank";
	
	private Banco() {
		this.contas = new Conta[100];
	}
	
	public static Banco getInstance(){
		if (Banco.instancia == null)
			Banco.instancia = new Banco();
		return instancia;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public Conta novaConta(String nomeTitular){
		this.contas[0] = new Conta(nomeTitular);
		return this.contas[0];
	}

}








