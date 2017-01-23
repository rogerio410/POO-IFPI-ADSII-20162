package app;

import modelo.Aluno;
import modelo.AlunoEnsinoFundamental;
import modelo.AlunoEnsinoMedio;

public class TesteHeranca {
	
	public static void main(String[] args) {
		
		Aluno af = new AlunoEnsinoFundamental("Fabio", 123);
		af.getNotas()[0] = 10;
		af.getNotas()[1] = 7;
		af.getNotas()[2] = 3;
		
		Aluno am = new AlunoEnsinoMedio("Joao Neto", 1234);
		am.getNotas()[0] = 10;
		am.getNotas()[1] = 7;
		am.getNotas()[2] = 3;
		
		AlunoEnsinoMedio am2 = (AlunoEnsinoMedio)am;
		
//		Aluno a = new Aluno("Teresa", 124);
//		a.getNotas()[0] = 10;
//		a.getNotas()[1] = 7;
//		a.getNotas()[2] = 2;
		
		System.out.println(af);
		System.out.println(am);
		System.out.println(am2);
		
	}

}
