package infra;

import java.util.Random;

public class TesteRandom {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			//int num = rand.nextInt(100);
			int num = (int)(rand.nextDouble() * 100);
			System.out.println(num);
		}
		
		
	}

}
