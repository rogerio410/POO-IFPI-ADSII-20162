package app;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import modelos.Produto;

public class TesteProduto {
	
	public static void main(String[] args) {
		
		Produto tv = new Produto("TV", 8);
		Produto bike = new Produto("Bike", 15);
		Produto carro = new Produto("Etios", 700);
		
		List itens = new ArrayList<>();
		itens.add(carro);
		itens.add(tv);
		itens.add(bike);
		itens.add(carro);
		
		Collections.sort(itens, Produto.BY_NAME_INVERSE);
		
		System.out.println(itens);
		
	}

}
