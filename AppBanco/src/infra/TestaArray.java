package infra;

import java.util.Arrays;

public class TestaArray {
	
	public static void main(String[] args) {
		
		int[] numeros = new int[3];
		int[] idades = {13, 18, 18};
		
		numeros[0] = 100;
		numeros[1] = 11;
		numeros[2] = 13;
		
		Arrays.sort(numeros);
		
		for(int i = 0; i < 3; i = i + 1){
			System.out.println(numeros[i]);
		}
		
//		for (int i = 0; i < idades.length; i++) {
//			idades[i] = -1;
//		}
		
		Arrays.fill(idades, 18);
		
		for (int i : idades) {
			System.out.println(i);
		}
		
		
		
		
		
	}

}
