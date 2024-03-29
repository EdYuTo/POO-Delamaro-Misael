/**
 * Classe que se comporta como o jogo em si
 * Ao final de cada rodada pergunta-se se o jogador quer continuar ou parar
 * Caso deseje parar, o jogo termina
 * Caso continue, o jogo terminara quando o jogador desejar parar ou quando acabarem os creditos do jogador
 * @author bruno flavio - 9791330
 * @author edson toma - 9791305
 */
public class VideoPoker {

	public static void main(String[] args) {
		Baralho b = new Baralho();
		Mao m = new Mao();
		Pontuacao p = new Pontuacao(200);//200 creditos iniciais
		int aposta = 0;
		boolean work;
		
		while (true) {//rodadas
			work = false;
			while(!work) {
				try {
					System.out.println("Digite o valor da aposta:\n");
					aposta = EntradaTeclado.leInt();
					if (aposta <= p.getCreditos() && aposta > 0)
						work = true;
					else if (aposta > 0) {
						work = false;
						System.out.println("Creditos insuficientes!\n");
					} else {
						work = false;
						System.out.println("Aposta invalida!\n");
					}
				} catch (Exception e) {
					System.out.println("Algo deu errado! Tente novamente...\n");
					work = false;
				}
			}
			
			b.embaralhar();
		    b.darCartas(m);
		    System.out.println("Suas cartas:\n" + m.toString());
		    
		    for (int i = 0; i < 2; i++) {
		    	work = false;
		    	while (!work) {
		    		try{
		    			System.out.println("Digite quais cartas trocar:\n");
		    			m.trocarCartas(EntradaTeclado.leString(), b);
		    			System.out.println("Suas cartas:\n" + m.toString());
		    			work = true;
		    		} catch (Exception e) {
		    			System.out.println("Algo deu errado! Tente novamente...\n");
		    			work = false;
		    		}
		    	}
		    }
		    System.out.printf("Creditos ganhos nesta rodada: %d\n", p.calculaRodada(aposta, m));
		    System.out.printf("Creditos totais: %d\n", p.getCreditos());
		    
		    if (p.getCreditos() == 0)
		    	break;
		   
		    work = false;
		    String s = "";
			while(!work) {
				try {
					System.out.println("Deseja continuar? y n\n");
					s = EntradaTeclado.leString();
					work = true;
				} catch (Exception e) {
					System.out.println("Algo deu errado! Tente novamente...\n");
					work = false;
				}
			}
		    s = s.toLowerCase();
		    if (s.equals("n")) break;
		}
		if (p.getCreditos() > 0 && p.getCreditos() > 200)
			System.out.printf("Parabens! Voce faturou %d creditos\n", p.getCreditos()-200);
		else if (p.getCreditos() == 200)
			System.out.println("Sua fatura: 0\nNao ganhou nada, que merda! Mas pense pelo lado positivo, tambem nao perdeu!\n");
		else if (p.getCreditos() > 0)
			System.out.printf("Voce perdeu: %d creditos\nMais sorte na proxima!\n", 200-p.getCreditos());
		else
			System.out.println("Seus creditos acabaram e voce foi expulso!\n");
	}
}
