import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Classe usada para processar uma imagem e gerar seu chain code.
 * @author Rafael Corradini da Cunha (9424322) <br> Guilherme Alves Campos (8522320)
 */
public class ChainCodes {
	private BufferedImage image;
	
	/**
	 * Método main usado para testar aos métodos da classe
	 * @param args
	 */
	public static void main(String[] args) {	
		String url;
		boolean flag;
		ChainCodes img = null;
		
		
		do {
			flag = false;
			System.out.print("Local da imagem (ex: src/teste.png): ");
			url = EntradaTeclado.leString();
					
			try {
				img = new ChainCodes(url);
			} catch (IOException e) {
				System.out.print("\n***Não foi possivel abrir a imagem. Tente novamente.***\n");		
				flag = true;
			}
		} while (flag);
		
		
		System.out.println("ponto inicial: "+ img.pontoInicial());
		System.out.println("largura x altura do objeto: "+ img.objWidth() +" x "+ img.objHeight());
		System.out.println("Chain Code: " + img.toString());
		System.out.println("\nNúmero de pontos na borda: "+ img.numBorda());
		System.out.println("Perímetro do objeto: "+ img.perimetro());
	}

	/**
	 * Construtor do objeto
	 * @param path Localização da imagem.
	 * @throws IOException Lança Exceção quando é incapaz de localizar a imagem
	 */
	public ChainCodes(String path) throws IOException{
		File inFile = new File(path);
		image = ImageIO.read(inFile);
	}
	
	/**
	 * Calcula o número de pontos (pixels não brancos) na "borda" do objeto.
	 * @return Número de pontos (pixels não brancos) na "borda" do objeto.
	 */
	public int numBorda() {
		ArrayList<Integer> chain = generateChainCode();
		
		return chain.size();
	}
	
	
	/**
	 * Calcula o perimetro do objeto contido na imagem.
	 * @return Perimetro
	 */
	public double perimetro() {
		ArrayList<Integer> chain = generateChainCode();
		double ret = 0;
		
		for (int i : chain) {
			if(i % 2 == 0) {
				ret++;
			} else {
				ret = ret + Math.sqrt(2);
			}
		}
		
		return ret;
	}
	
	/**
	 * Gera o chainCodes do objeto e o coloca em um ArrayList
	 * @return ArrayList de inteiros contendo os valores calculados
	 */
	public ArrayList<Integer> generateChainCode() {
		String[] pontoInicial = pontoInicial().split("x");
		int x = Integer.parseInt(pontoInicial[0]), y = Integer.parseInt(pontoInicial[1]);
		ArrayList<Integer> ret = new ArrayList<>();
		int[] ver = {2,1,0,-1,-2};

		do {
			if(ret.size() > 0) {
				ver[0] = ret.get(ret.size() - 1);
				ver[1] = ret.get(ret.size() - 1) + 1;
				ver[2] = ret.get(ret.size() - 1) + 2;
				ver[3] = ret.get(ret.size() - 1) - 1;
				ver[4] = ret.get(ret.size() - 1) - 2;
			}
			Arrays.sort(ver);
			
			
			for(int j = 0; j < 5; j++) {
				if(ver[j] == -1) ver[j] = 7;
				if(ver[j] == -2) ver[j] = 6;
				if(ver[j] > 7) ver[j] = ver[j] % 8;
			}
			
			for(int j = 4; j >= 0; j--) {
				if(ver[j] == 0 && (image.getRGB(x+1, y) & 0xFF) != 255) {
					x++;
					ret.add(0);
					break;
				}
				if(ver[j] == 1 && (image.getRGB(x+1, y-1) & 0xFF) != 255) {
					x++;
					y--;
					ret.add(1);
					break;
				}
				if(ver[j] == 2 && (image.getRGB(x, y-1) & 0xFF) != 255) {
					y--;
					ret.add(2);
					break;
				}
				if(ver[j] == 3 && (image.getRGB(x-1, y-1) & 0xFF) != 255) {
					y--;
					x--;
					ret.add(3);
					break;
				}
				if(ver[j] == 4 && (image.getRGB(x-1, y) & 0xFF) != 255) {
					x--;
					ret.add(4);
					break;
				}
				if(ver[j] == 5 && (image.getRGB(x-1, y+1) & 0xFF) != 255) {
					y++;
					x--;
					ret.add(5);
					break;
				}
				if(ver[j] == 6 && (image.getRGB(x, y+1) & 0xFF) != 255) {
					y++;
					ret.add(6);
					break;
				}
				if(ver[j] == 7 && (image.getRGB(x+1, y+1) & 0xFF) != 255) {
					y++;
					x++;
					ret.add(7);
					break;
				}
			}	
		} while((x != Integer.parseInt(pontoInicial[0]) || y != Integer.parseInt(pontoInicial[1])));
		
		return ret;
	}
	
	/**
	 * Encontra o primeiro ponto não-branco da imagem
	 * @return As cordenados do ponto inicial
	 */
	public String pontoInicial() {
		String str = "";
		for(int i = 0; i < image.getHeight(); i++) {
			for(int j = 0; j < image.getWidth(); j++) {
				if((image.getRGB(j, i)& 0xFF) != 255) {
					str = j+"x"+i;
					j = image.getWidth();
					i = image.getHeight();
				}
			}
		}
		return str;
	}
	
	/**
	 * Calcula a largura do objeto
	 * @return largura do objeto
	 */
	public int objWidth() {
		int x1 =0, x2 = 0;
		for(int i = 0; i < image.getWidth(); i++) {
			for(int j = 0; j < image.getHeight(); j++) {
				if((image.getRGB(i, j)& 0xFF) != 255) {
					x1 = i;
					i = image.getWidth()+1;
					j = image.getHeight()+1;
				}
			}
		}
		for(int i = image.getWidth()-1; i >= 0; i--) {
			for(int j = image.getHeight()-1; j >= 0; j--) {
				if((image.getRGB(i, j)& 0xFF) != 255) {
					x2 = i;
					i = -1;
					j = -1;
				}
			}
		}
				
		return (x2-x1)+1;
	}
	
	/**
	 * Calcula a altura do objeto
	 * @return altura do objeto
	 */
	public int objHeight() {
		String[] pontoInicial = pontoInicial().split("x");
		int y1 = Integer.parseInt(pontoInicial[1]), y2 = Integer.parseInt(pontoInicial[1]);
		for(int i = image.getHeight()-1; i >= 0; i--) {
			for(int j = image.getWidth()-1; j >= 0; j--) {
				if((image.getRGB(j, i)& 0xFF) != 255) {
					y2 = i;
					i = -1;
					j = -1;
				}
			}
		}
				
		return (y2-y1)+1;
	}
	
	/**
	 * Converte o chainCodes em uma string e o retorna.
	 */
	@Override
	public String toString() {
		ArrayList<Integer> chain = generateChainCode();
		String str = "";
		
		for (int i : chain) {
			str += i;
		}
		
		return str;
	}
	
}
