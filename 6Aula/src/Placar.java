
public class Placar {
	private int posicoes[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private boolean ocupadas[] = {false, false, false, false, false, false, false, false, false, false};
	
	public void add(int posicao, int[] dados) throws IllegalArgumentException{
		if(ocupadas[posicao-1] || posicao <= 0 || posicao > 10) throw new IllegalArgumentException("Posição inválida!");
		
		/**
		 * Adicão nas posiçoes externas
		 */
		if(posicao <= 6){
			int nDado = 0;
			
			for(int i = 0; i < dados.length; i++){
				if(dados[i] == posicao) nDado++;
			}
			
			posicoes[posicao-1] = nDado * posicao;
			ocupadas[posicao-1] = true;
		}
		
		/**
		 * Adição na full hand
		 */
		else if(posicao == 7){
			int lado1 = dados[0], lado2 = 0;
			int nDado1 = 0, nDado2 = 0;
		
			for(int i = 0; i < dados.length; i++){
				if(dados[i] == lado1)
					nDado1++;
				else lado2 = dados[i];
			}
			
			for(int i = 0; i < dados.length; i++){
				if(dados[i] == lado2)
					nDado2++;
			}
			
			if((nDado1 == 3 && nDado2 == 2) 
					|| (nDado1 == 2 && nDado2 == 3))
				posicoes[posicao-1] = 15;
			else
				posicoes[posicao-1] = 0;
			
			ocupadas[posicao-1] = true;
		}
		
		else if(posicao == 8){
			int lados[] = {0, 0, 0, 0, 0, 0};
			
			for(int i = 0; i < dados.length; i++){
				lados[dados[i] - 1]++;
			}
			
			if((lados[0] == 1 && lados[1] == 1 && lados[2] == 1 && lados[3] == 1 && lados[4] == 1)
					|| (lados[1] == 1 && lados[2] == 1 && lados[3] == 1 && lados[4] == 1 && lados[5] == 1))
				posicoes[posicao-1] = 20;
			else posicoes[posicao-1] = 0;
			
			ocupadas[posicao-1] = true;
		}
		
		else if(posicao == 9){
			int lados[] = {0, 0, 0, 0, 0, 0};
			
			for(int i = 0; i < dados.length; i++){
				lados[dados[i] - 1]++;
			}
			
			posicoes[posicao-1] = 0;
			for(int i = 0; i < lados.length; i++){
				if(lados[i] >= 4){
					posicoes[posicao-1] = 30;
				}
			}
			
			ocupadas[posicao-1] = true;
		}
		
		else if(posicao == 10){
			int lados[] = {0, 0, 0, 0, 0, 0};
			
			for(int i = 0; i < dados.length; i++){
				lados[dados[i] - 1]++;
			}
			
			posicoes[posicao-1] = 0;
			for(int i = 0; i < lados.length; i++){
				if(lados[i] == 5){
					posicoes[posicao-1] = 40;
				}
			}
			
			ocupadas[posicao-1] = true;
		}
	}
	
	public int getScore(){
		int score = 0;
		for(int i = 0; i < posicoes.length; i++){
			score += posicoes[i];
		}
		
		return score;
	}
	
	@Override
	public String toString(){
		String s;
		if(!ocupadas[0]) s = "(1)\t|";
		else s = posicoes[0] + "\t|";
		
		if(!ocupadas[6]) s += "\t(7)\t|";
		else s +="	" + posicoes[6] + "\t|";
		
		if(!ocupadas[3]) s += "\t(4)\n";
		else s +="\t" + posicoes[3] + "\n";
		
		if(!ocupadas[1]) s += "(2)\t|";
		else s += posicoes[1] + "\t|";
		
		if(!ocupadas[7]) s += "\t(8)\t|";
		else s +="\t" + posicoes[7] + "\t|";
		
		if(!ocupadas[4]) s += "\t(5)\n";
		else s +="\t" + posicoes[4] + "\n";
		
		if(!ocupadas[2]) s += "(3)\t|";
		else s += posicoes[2] + "\t|";
		
		if(!ocupadas[8]) s += "\t(9)\t|";
		else s +="\t" + posicoes[8] + "\t|";
		
		if(!ocupadas[5]) s += "\t(6)\n";
		else s +="\t" + posicoes[5] + "\n";
		
		if(!ocupadas[9]) s += "\t|\t(10)\t|\n";
		else s +="\t|\t"+ posicoes[9] +"\t|\n";
		
		return s;
	}
	
	public static void main(String[] args){
		Placar p =new Placar();
		
		int dados[] = {3,3,3,3,3};
		p.add(10, dados);
		
		p.add(3, dados);
		
		p.add(9, dados);
		
		int dados1[] = {1,2,3,4,5};
		p.add(8, dados1);
		
		int dados2[] = {3,3,4,3,4};
		p.add(7, dados2);
		
		System.out.println(p.toString());
		System.out.println(p.getScore());
	
	}
	
}
