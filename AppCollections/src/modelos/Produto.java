package modelos;

import java.util.Comparator;
import static java.util.Comparator.*;

public class Produto implements Comparable<Produto> {
	
	public final static Comparator<Produto> BY_NAME = comparing(Produto::getNome);
	public final static Comparator<Produto> BY_NAME_INVERSE = comparing(Produto::getNome, reverseOrder());
	
	private String nome;
	private int peso;
	
	public Produto(String nome, int peso) {
		this.nome = nome;
		this.peso = peso;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + this.nome + ", peso=" + this.peso + "]";
	}
	
	@Override
	public int compareTo(Produto o) {
		return Integer.compare(this.peso, o.getPeso());
	}
	
	

}
