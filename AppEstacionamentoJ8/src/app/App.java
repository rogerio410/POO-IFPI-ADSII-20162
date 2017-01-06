package app;

import domain.Estacionamento;
import domain.Veiculo;

public class App {
	
	public static void main(String[] args) {
		
		Estacionamento park = Estacionamento.getInstance();
		
		//MENU.
		Veiculo v = new Veiculo("ABC", "Palio");
		park.entrada(v);
		park.saida("ACD");
		park.getVagas();
		
	}

}
