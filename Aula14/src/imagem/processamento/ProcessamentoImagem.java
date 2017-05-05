package imagem.processamento;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import imagem.util.EntradaTeclado;

/**
 * 
 * @author Bruno Flavio Ferreira - 9791330
 * @author Edson Yudi Toma - 9791305 
 */

public class ProcessamentoImagem {
	private int imagem[][];
	private int height;
	private int width;
	private double perimeter;
	
	public ProcessamentoImagem(BufferedImage imagem) {
			
		this.height = imagem.getHeight();
		this.width = imagem.getWidth();
		this.perimeter = 0;
		this.imagem = new int[height][width];
		
		//Leitura da matriz
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				this.imagem[j][i] = imagem.getRGB(i, j);
			}
		}
	}
	
	public int[] pontoInicial() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(imagem[i][j] != -1)
					return new int[] {j, i};
			}
		}
		return null;
	}

	public int largura() {
		int[] inicio = this.pontoInicial();
		int largura = 0;
		
		if(inicio != null){
			for(int i = inicio[1]; i < height; i++) {
				int aux = 0;
				int aux1 = 0;
				for(int j = 0; j < width; j++){
					if(imagem[i][j] != -1) aux++;
					else if(aux != 0){
						if(aux > aux1)
							aux1 = aux;
						aux = 0;
					}
				}
				if(aux1 > aux)
					aux = aux1;
				
				if(aux > largura)
					largura = aux;
			}
		}
		return largura;
	}
	
	public int altura() {
		int altura = 0;
		
		for(int i = 0; i < width; i++) {
			int aux = 0;
			int aux1 = 0;
			for(int j = 0; j < height; j++) {
				if(imagem[j][i] != -1) aux++;
				else if(aux != 0){
					if(aux > aux1)
						aux1 = aux;
					aux = 0;
				}
			}
			if(aux1 > aux)
				aux = aux1;
			
			if(aux > altura)
				altura = aux;
		}
		return altura;
	}
	
	private boolean check(int x, int y) {//checa se o ponto esta na borda da imagem
		int aux = 0;//acumulador
		if (x >= 0 && x < height)//x dentro dos limites da imagem
			if (y >=0 && y < width) {//y dentro dos limites da imagem
				if (this.imagem[x][y] == -1) return false;//se for um ponto branco eh ignorado
				for (int i = -1; i < 2; i++)//varia de -1 a 1 para varrer 3 coordenadas em x
					for (int j = -1; j < 2; j++)//varia de -1 a 1 para varrer 3 coordenadas em y --- ao todo varrem 8 coordenadas ao redor do ponto
						if (x+i>=0 && y+j>=0 && (i!=0 || j!=0) && x+i<height && y+j<width && this.imagem[x+i][y+j] == -1)//checa se o novo ponto nao eh o proprio ponto e se suas coordenadas estao dentro dos limites da imagem
							aux++;//incrementa o acumulador
				if (aux >= 2)//se um ponto nao for branco e possuir conexao com pelo menos 2 pontos brancos, ele esta na borda!
					return true;
			}
		return false;//erro, nao esta na borda
	}
	
	private int[] proximo(int inicio[], int visitado[]) {//calcula o proximo ponto
		int proximo[] = new int[4];//2 coordenadas para o proximo e 2 coordenadas para o anterior
		if (inicio[0] >= 0 && inicio[0] < height)//x do ponto esta dentro dos limites da imagem
			if (inicio[1] >= 0 && inicio[1] < width)//y do ponto esta dentro dos limites da imagem
				for (int i = -1; i < 2; i++)//varia de -1 a 1 para varrer 3 coordenadas em x
					for (int j = -1; j < 2; j++)//varia de -1 a 1 para varrer 3 coordenadas em y --- ao todo varrem 8 coordenadas ao redor do ponto
						if ((i!=0 || j!= 0) && inicio[0]+i>=0 && inicio[1]+j>=0 && inicio[0]+i<height && inicio[1]+j<width)//se nao for o proprio ponto e as coordenadas do novo ponto estiverem dentro dos limites da imagem
							if (check(inicio[0]+i, inicio[1]+j)&&(inicio[0]+i!=visitado[0]||inicio[1]+j!=visitado[1])) {//checa se o novo ponto eh de borda e se ele nao eh o anterior
								proximo[0] = inicio[0] + i;//prox
								proximo[1] = inicio[1] + j;//prox
								proximo[2] = inicio[0];//novo anterior
								proximo[3] = inicio[1];//novo anterior
								if (i+j == 1 || i+j == -1) this.perimeter += 1;//linha reta + raiz de (1+0)
								else this.perimeter += Math.sqrt(2);//diagonais + raiz de (1+1)
								return proximo;
							}
		return null;//erro
	}
	
	public int chainCodes() {
		int[] inicio = this.pontoInicial();//ponto de partida e de parada 
		int[] prox = new int [2];//armazena coordenadas do prox ponto
		int[] ant = new int [2];//armazena coordenadas do pinto anterior
		int[] aux = new int [4];//aux q recebe coordenadas do proximo ponto e do ponto anterior
		int borda = 0;//acumulador
		boolean stop = false;//para parar o laco
		
		prox[0] = ant[0] = inicio[1];//proximo = anterior (comeco)
		prox[1] = ant[1] = inicio[0];//
		
		while (!stop) {
			aux = proximo(prox, ant);//calcula o proximo e retorna o proximo e o novo anterior
			prox[0] = aux[0];//atribui as coordenadas do proximo ao vetor
			prox[1] = aux[1];//
			ant[0] = aux[2];//atribui as coordenadas do anterior ao vetor
			ant[1] = aux[3];//
			borda++;//incrementa o acumulador
			if (prox == null || (prox[0] == inicio[1] && prox[1] == inicio[0]))//nao para ate o proximo ser o ponto inicial
				stop = true;
		}
		return borda;//retorno do numero de pontos na borda
	}
	
	public int[][] getImagem() {
		return imagem;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	public static void main(String[] args) {
		String arquivo;
		BufferedImage img; 
		ProcessamentoImagem ad;
		try {
			System.out.println("Digite o nome da imagem:");
			arquivo = EntradaTeclado.leString();
			img = ImageIO.read(new File(arquivo));
			ad = new ProcessamentoImagem(img);
		} catch (Exception e) {
			System.out.println("Arquivo invalido!\n" + e.getMessage());
			return ;
		}
		System.out.println("Ponto Inicial= (" + ad.pontoInicial()[0] + ", " +ad.pontoInicial()[1] + ")");
		System.out.println("Dimensoes da imagem: " + ad.getWidth() + "x" + ad.getHeight());
		System.out.println("Dimensoes do objeto: " + ad.largura() + "x" + ad.altura());
		System.out.println("Numero de pontos da borda do objeto: " + ad.chainCodes());
		System.out.println("Perimetro: " + ad.getPerimeter());
	}
}