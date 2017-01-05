package app;

import javax.swing.JOptionPane;

import domain.Point;
import domain.Rectangle;

public class Principal {
	
	public static void main(String[] args) {
		String menu = "##### RT #####";
		menu += "\n 1 - Configurar Rect1";
		menu += "\n 2 - Configurar Rect2";
		menu += "\n 3 - Area do Rect1";
		menu += "\n 4 - Perimetro do Rect1";
		menu += "\n 5 - Verificar se Rect2 inicia em Rect1";
		menu += "\n\n 0 - Sair. \n";
		
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		
		int op = -1;
		
		while (op != 0){
			op = getInt(menu);
			
			switch (op) {
				case 1:
					//Config do rect1
					rect1.width = getDouble("Rect1 W:");
					rect1.height = getDouble("Rect1 H");
					rect1.pontoDeOrigem = new Point();
					rect1.pontoDeOrigem.x = getDouble("Rect1 X: ");
					rect1.pontoDeOrigem.y = getDouble("Rect1 Y: ");
					break;
				case 2: 
					//Config do rect2
					break;
				case 3:
					//Area
					showMsg("Rect1 Area: " + rect1.area());
					break;
				case 4:
					//Area
					showMsg("Rect1 Perimetro: " + rect1.perimeter());
					break;
				case 5:
					//Esta contido.
					if (rect1.contains(rect2)){
						showMsg("Sim.");
					}else{
						showMsg("Nao.");
					}
					break;
				case 0:
					break;
				default:
					showMsg("Opcao Invalida.");
					break;
			}
			
		}
		
		
		
		
		
		
		
	}


	private static void showMsg(String menu) {
		JOptionPane.showMessageDialog(null, menu);
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
	}
	
	private static int getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
	}

	private static Double getDouble(String msg) {
		String entrada = JOptionPane.showInputDialog(msg);
		return Double.valueOf(entrada);
	}

}










