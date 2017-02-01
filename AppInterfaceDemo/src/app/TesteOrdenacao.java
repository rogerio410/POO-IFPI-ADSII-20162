package app;

import java.util.Arrays;

import modelo.ArraysK;
import modelo.Passageiro;

public class TesteOrdenacao {
	
	public static void main(String[] args) {
		
		
		Passageiro pa = new Passageiro("A", 1, 80);
		Passageiro pb = new Passageiro("B", 2, 100);
		Passageiro pc = new Passageiro("C", 2, 100);
		Passageiro pd = new Passageiro("D", 2, 101);
		Passageiro pe = new Passageiro("E", 3, 101);
		
		Passageiro[] passageiros = {pa, pb, pc, pd, pe};
		
		imprimir(passageiros);
		
		Arrays.sort(passageiros);
		System.out.println();
		
		imprimir(passageiros);
		
	}

	private static void imprimir(Passageiro[] itens) {
		for (Passageiro i : itens) {
			System.out.println(i);
		}
	}

}
