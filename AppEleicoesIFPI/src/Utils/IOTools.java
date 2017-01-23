package Utils;

import javax.swing.JOptionPane;

public class IOTools {
	
	public static String getString(String msg, boolean required){
		String entrada;
		entrada = JOptionPane.showInputDialog(msg);
		
		if (required && entrada.isEmpty()){//programador apaixonado.
			showError("Favor forneça um valor com os solicitado.");
			getString(msg, required);
		}
		
		return entrada;
	}
	
	public static String getString(String msg){
		return getString(msg, true);
	}
	
	public static int getInt(String msg, boolean required){
		String entrada = getString(msg, required);
		int numero = 0;
		try {
			numero = Integer.valueOf(entrada);
		} catch (Exception e) {
			showError("Favor forneça um valor com os solicitado.");
			numero = getInt(msg, required);
		}
		
		return numero;
	}
	
	public static int getInt(String msg){
		return getInt(msg, true);
	}
	
	public static void showMsg(String msg){
		JOptionPane.showMessageDialog(null, 
				msg, 
				"IFPI Eleicoes2017", 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showError(String msg){
		JOptionPane.showMessageDialog(null, 
				msg, 
				"IFPI Eleicoes2017", 
				JOptionPane.ERROR_MESSAGE);
	}

}
