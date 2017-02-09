package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import modelos.Produto;

public class TesteMap {
	
	public static void main(String[] args) {
		
		Produto tv = new Produto("Bola de Basquete", 1);
		Produto bike = new Produto("Notebook", 2);
		Produto carro = new Produto("Celular", 1);
		Produto teclado = new Produto("Teclado Apple", 1);
		
		Map<String, Produto> presentes;
		presentes = new HashMap<>();
		presentes.put("Kassio", tv);
		presentes.put("Alexs", bike);
		presentes.put("JN", bike);
		presentes.put("JN", carro);
		presentes.put("Breno", carro);
		presentes.put("RogerioSilva", teclado);
		
		Set<String> nomes = presentes.keySet();
		Collection<Produto> valores = presentes.values();
		
		
//		for (String key : nomes) {
//			System.out.println(key + " --> " + presentes.get(key));
//		}
		
		for (Produto produto : valores) {
			System.out.println(produto);
		}
		
		
		
	}

}
