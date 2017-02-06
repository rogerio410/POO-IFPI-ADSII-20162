package app;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import modelos.Produto;

public class TesteMap {
	
	public static void main(String[] args) {
		
		Produto tv = new Produto("Bola de Basquete", 1);
		Produto bike = new Produto("Notebook", 2);
		Produto carro = new Produto("Celular", 1);
		
		Map<String, Produto> presentes;
		presentes = new TreeMap<>();
		presentes.put("Kassio", tv);
		presentes.put("Alexs", bike);
		presentes.put("JN", bike);
		presentes.put("JN", carro);
		presentes.put("Breno", carro);
		
		System.out.println(presentes);		
		
		
		
	}

}
