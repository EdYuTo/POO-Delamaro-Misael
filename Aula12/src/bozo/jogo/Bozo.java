package bozo.jogo;
import bozo.leitura.EntradaTeclado;
import bozo.placar.Placar;
import bozo.dados.RolaDados;
import bozo.exception.ETException;

public class Bozo {

	public static void main(String[] args) throws Exception {
		RolaDados r = new RolaDados(5);
		Placar p = new Placar();
		String reroll;
		boolean work;
		int posicao;
		
		for (int i = 0; i < 10; i++) {
			System.out.println("\t   Seu placar:\n" + p.toString());
			
			r.rolar();			
			System.out.println(r.toString());
			
			for (int j = 0; j < 2; j++) {
				work = false;
				while (!work) {
					try {
						System.out.println("Digite as posicoes a serem trocadas\n");
						reroll = EntradaTeclado.leString();
						r.rolar(reroll);			
						System.out.println(r.toString());
						work = true;
					} catch (ETException e) {
						System.out.println(e.getMessage());
						work = false;
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						work = false;
					} catch (Exception e) {
						System.out.println("Algo deu errado!\n");
						work = false;
					}
				}
			}
						
			System.out.println(p.toString());
			work = false;
			while (!work) {
				try {
					System.out.println("Digite a posição do placar desejada\n");
					posicao = EntradaTeclado.leInt();
					p.add(posicao, r.rolar(" "));
					work = true;
				} catch (Exception e) {
					System.out.println("Posição indisponível\n");
					System.out.println(p.toString());
					work = false;
				}
			}
			System.out.println("Pontuação: " + p.getScore());
		}
		System.out.println(p.toString());
		System.out.println("Pontuação Final: " + p.getScore());
	}

}
