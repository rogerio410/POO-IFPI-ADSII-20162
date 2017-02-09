package modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarrinhoCompras implements Iterable<Produto>{
	
	private static final int SIZE_CARRINHO = 10;
	
	private List<Produto> produtos = new ArrayList<>();
	private int index = 0;
	
	
	public void addProduto(Produto p){
		this.produtos.add(p);
	}
	
	@Override
	public Iterator<Produto> iterator() {
//		CarrinhoIterator meuIterator = new CarrinhoIterator();
//		return meuIterator;
		return produtos.iterator();
	}
	
//	private class CarrinhoIterator implements Iterator<Produto>{
//
//		@Override
//		public boolean hasNext() {
//			return index < produtos.size();
//		}
//
//		@Override
//		public Produto next() {
//			Produto p = produtos.get(index);
//			index++;
//			return p;
//		}
//		
//		
//	}
//	

}
