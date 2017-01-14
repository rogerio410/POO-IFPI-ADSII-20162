package principal;

import Utils.IOTools;
import dominio.Candidato;
import dominio.Eleicao;
import dominio.Votacao;

import static Utils.IOTools.*;

public class AppEleicao {
	
	static Eleicao eleicao;
	
	public static void main(String[] args) {
		
		int op = 0;
		String menu = "1 - Add Candidato \n"+
				"2 - Resultado Geral\n" +
				"0 - Sair\n\n";
		
		inicializar();
		
		do {
			op = IOTools.getInt(menu, true);
			
			switch (op) {
				case 1:
					addCandidato();
					break;
				case 2:
					showMsg(eleicao.toString());
					break;
				case 0:
					showMsg("bye. ");
					break;
				default:
					showError("Opcao inválida");
					break;
				}
			
			
		} while (op != 0);
		
	}

	private static void addCandidato() {
		String nome = getString("Nome: ");
		int numero = getInt("Numero: ");
		String sexo = getString("Sexo: ", false);
		String slogan = getString("Slogan", false);
		
		Candidato c = new Candidato(nome, numero);
		c.setSlogan(slogan);
		c.setSexo(sexo);
		
		c.setVotacao(obterVotacao());
		
		if (eleicao.addCandidato(c)){
			showMsg("Candidato e sua votacao adicionados com sucesso");
		}else{
			showError("Nao foi possivel adicionar o candidato. "
					+ "Verifique os dados ou se ainda há vaga");
		}
		
	}

	private static Votacao obterVotacao() {
		int votosDoc = getInt("Votos de Docentes: ");
		int votosTae = getInt("Votos de TAE: ");
		int votosDisc = getInt("Votos de Discentes: ");
		return new Votacao(votosDoc, votosTae, votosDisc);
	}

	private static void inicializar() {
		String nome = getString("Nome Eleição: ");
		String campus = getString("Campus: ");
		
		int qCand = getInt("Quantos candidatos: ");
		int qDoc = getInt("Qtd Eleitores Docentes: ");
		int qTae = getInt("Qtd Eleitores TAE: ");
		int qDisc = getInt("Qtd Eleitores Discentes: ");
		
		eleicao = new Eleicao(qCand, qDoc, qTae, qDisc);
		eleicao.setCampus(campus);
		eleicao.setNome(nome);
		
		showMsg("Inicializacao Ok");
	}

}
