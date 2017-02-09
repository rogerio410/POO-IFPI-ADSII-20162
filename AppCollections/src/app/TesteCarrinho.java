package app;

import java.util.Iterator;

import modelos.CarrinhoCompras;
import modelos.Produto;

public class TesteCarrinho {
	
	public static void main(String[] args) {
		
		CarrinhoCompras car = new CarrinhoCompras();
		car.addProduto(new Produto("Apagador", 1));
		car.addProduto(new Produto("Borrada", 1));
		car.addProduto(new Produto("Cadeira", 1));
		
		int numero = (10 > 20)  ? 100 : 200;
		
		Iterator<Produto> iterador = car.iterator();
		
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
		
//		for (Produto produto : car) {
//			System.out.println(produto);
//		}
		
		
		
		System.out.println("Fim...");
		
	}

}
