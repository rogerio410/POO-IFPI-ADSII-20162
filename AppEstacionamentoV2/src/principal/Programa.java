package principal;

import java.util.Arrays;

import javax.swing.JOptionPane;

import modelos.Estacionamento;
import modelos.Veiculo;

public class Programa {
	
public static void main(String[] args) {
		
		Estacionamento estacionamento = Estacionamento.getInstance();
		String menu = "1 - Entrada \n2 - Saida \n3 - Estado\n4 - Sair";
		
		while(true){
			
			int opcao = Integer
					.valueOf(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
				case 1: //Entrada
					String placa = JOptionPane.showInputDialog("Placa: ");
					String nome = JOptionPane.showInputDialog("Nome: ");
					
					//estacionamento.entrada(new Veiculo(placa, nome));
					if (estacionamento.entrada(placa, nome) == true){
						int pos = estacionamento.estacionado(placa);
						JOptionPane.showMessageDialog(null, "Entrada Ok. Vaga: " + pos);
					}else {
						JOptionPane
						.showMessageDialog(null, "Erro: Estacionamento Cheio ou Veiculo já estacionado");
					}
					
					break;
				case 2: // Saida
					placa = JOptionPane.showInputDialog("Placa: ");
					
					if (estacionamento.saida(placa)){
						JOptionPane.showMessageDialog(null, "Saida Ok. Obg.");
					}else{
						JOptionPane.showMessageDialog(null, "Erro: Veiculo nao estacionado.");
					}
					
					break;
					
				case 3: //Estado
					JOptionPane.showMessageDialog(null, estacionamento);
					break;
					
				case 4: //Sair
					return;
				default://Opcao Invalida.
					JOptionPane.showMessageDialog(null, "Opcao Invalida");
					break;
			}
			
		}
		
		
	}

}
