package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import modelos.Produto;

public class TesteProduto {
	
	public static void main(String[] args) {
		
		Produto tv = new Produto("TV", 8);
		Produto bike = new Produto("Bike", 15);
		Produto carro = new Produto("Etios", 700);
		
		List<Produto> itens = new ArrayList<>();
		itens.add(carro);
		itens.add(tv);
		itens.add(bike);
		itens.add(carro);
		
		Collections.sort(itens, Produto.BY_NAME_INVERSE);
		//Traditional way.
//		for(int i = 0; i < itens.size(); i++){
//			Produto p = itens.get(i);
//			System.out.println(p.getNome());
//		}
		
		//Iterator.
//		Iterator<Produto> iterator = itens.iterator();
//		
//		while (iterator.hasNext()){
//			Produto p = iterator.next();
//			System.out.println(p.getNome());
//		}
		
		//Iterator pelo Foreach
		for (Produto p : itens) {
			System.out.println(p.getNome());
		}
		
	}

}





