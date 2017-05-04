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
	
	public ProcessamentoImagem(BufferedImage imagem) {
			
		this.height = imagem.getHeight();
		this.width = imagem.getWidth();
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
	
	private int[] proximo(int inicio[], int visitado[]) {
		int proximo[] = new int[2];
		int aux = 0;
		
		if (inicio[0] >= 0 && inicio[0] < height)
			if (inicio[1] >=0 && inicio[1] <= width)
				for (int i = -1; i < 2; i++) 
					for (int j = -1; j < 2; j++)
		
		return proximo;
	}
	
	public int chainCodes() {
		int[] inicio = this.pontoInicial();
		int[] prox = new int [2];
		int[] ant = new int [2];
		int borda = 0;
		
		prox[0] = ant[0] = inicio[0];
		prox[1] = ant[1] = inicio[1];
	
		while (proximo(prox, ant)[0] != inicio[0] && proximo(prox, ant)[1] != inicio[1]) {
			borda++;
			ant[0] = prox[0];
			ant[1] = prox[1];
			inicio = proximo(inicio, ant);
		}
		return borda;
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
		System.out.println("Dimensoes do desenho: " + ad.largura() + "x" + ad.altura());
		System.out.println("Chain Codes: " + ad.chainCodes());
	}
}