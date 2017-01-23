package principal;

import modelos.Fracao;

public class TestaFracao {
	
	public static void main(String[] args) {
		
		Fracao f1 = new Fracao(1, 2);
		Fracao f2 = new Fracao(50, 100);
		
		boolean equiv = f1.equivalente(f2);
		equiv = f2.equivalente(f1);
		
		
	}

}
