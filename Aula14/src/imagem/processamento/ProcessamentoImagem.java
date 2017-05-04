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
	
	public ProcessamentoImagem(BufferedImage imagem){
		if(imagem.getType() != BufferedImage.TYPE_BYTE_GRAY)
			throw new IllegalArgumentException("Imagem em formato inválido!");
		
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
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(imagem[i][j] != -1)
					return new int[] {j, i};
			}
		}
		return null;
	}
/*
 * -1 -1 -1 -1 -1  0 -1 -1 -1 -1 -1
 * -1 -1 -1 -1  0  0  0 -1 -1 -1 -1
 * -1 -1 -1  0  0 -1  0  0 -1 -1 -1
 * -1 -1 -1  0  0 -1  0  0 -1 -1 -1
 * -1 -1 -1 -1  0  0  0 -1 -1 -1 -1
 * -1 -1 -1 -1 -1  0 -1 -1 -1 -1 -1
 */
	public int largura(){
		int[] inicio = this.pontoInicial();
		int largura = 0;
		
		if(inicio != null){
			for(int i = inicio[1]; i < height; i++){
				int aux = 0;
				for(int j = 0; j < width; j++){
					if(imagem[i][j] != -1) aux++;
				}
				if(aux > largura)
					largura = aux;
			}
		}
		
		return largura;
	}
	
	public int altura() {
		int altura = 0;
		
			for(int i = 0; i < width; i++){
				int aux = 0;
				for(int j = 0; j < height; j++){
					if(imagem[j][i] != -1) aux++;
				}
				if(aux > altura)
					altura = aux;
			}
		return altura;
	}
	
	public int[][] getImagem(){
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
			System.out.println("nome?");
			arquivo = EntradaTeclado.leString();
			img = ImageIO.read(new File(arquivo));
			ad = new ProcessamentoImagem(img);
		} catch (Exception e) {
			System.out.println("arquivo invalido!" + e.getMessage());
			return ;
		}
		System.out.println("Ponto Inicial= (" + ad.pontoInicial()[1] + ", " +ad.pontoInicial()[0] + ")");
		System.out.println("Dimensoes da imagem: " + ad.getHeight() + "x" + ad.getWidth());
		System.out.println("Dimensoes do desenho: " + ad.altura() + "x" + ad.largura());
	}
}