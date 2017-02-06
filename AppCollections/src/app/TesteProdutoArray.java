package app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import modelos.Produto;

public class TesteProdutoArray {
	
public static void main(String[] args) {
		
		Produto tv = new Produto("TV", 8);
		Produto bike = new Produto("bike", 15);
		
		Produto[] itens = {tv, bike};
		
		System.out.println(Arrays.toString(itens));
		
		
	}

}
