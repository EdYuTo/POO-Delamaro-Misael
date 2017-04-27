package bozo.dados;
import bozo.rand.Random;

public class Dado {
	private int nlados;
	private int lado;
	
	public Dado(){
		nlados = 6;
	}
	
	public Dado(int n){
		nlados = n;
	}
	
	public int getLado(){
		return lado;
	}
	
	public int rolar(){
		Random r = new Random();
		lado = r.getIntRand(nlados) + 1;
		
		return lado;
	}
	
	@Override
	public String toString(){
		String s = "+-----+\n";
		
		if(lado == 1){
			s += "|     |\n|  *  |\n|     |\n";
		}
		
		else if(lado == 2){
			s += "|*    |\n|     |\n|    *|\n";
		}
		
		else if(lado == 3){
			s += "|*    |\n|  *  |\n|    *|\n";
		}
		
		else if(lado == 4){
			s += "|*   *|\n|     |\n|*   *|\n";
		}
		
		else if(lado == 5){
			s += "|*   *|\n|  *  |\n|*   *|\n";
		}
		
		else if(lado == 6){
			s += "|*   *|\n|*   *|\n|*   *|\n";
		}
		
		s += "+-----+";
		
		return s;
		
	}
	
	public static void main(String[] args){
		Dado dado = new Dado();
		
		dado.rolar();
		System.out.print(dado.toString());
	}
}
