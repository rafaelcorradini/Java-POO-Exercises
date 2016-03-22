import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Boz�. Permite que combina��es de dados sejam alocadas �s posi��es e mant�m o escore de um jogador.
 * @author Rafael Corradini da Cunha (9424322)<br>
 * Alan Nishimori Araujo (8066328) )
 */
public class Placar {
	private int[][] dadosPosicao = new int[10][5]; // Guarda os dados que estao na posicao
	private int[] score = new int[10]; // Guarda o score de cada posicao usada, -2 para posicao nao usada
	
	public Placar() {
		Arrays.fill(score, -2); // seta os valores de score -2 como padr�o
	}
	/**
	 * Adiciona uma sequencia de dados em uma determinada posi��o do placar.
	 * Ap�s a chamada, aquela posi��o torna-se ocupada e n�o pode ser usada uma segunda vez.
	 * @param posicao Posi��o a ser preenchida.
	 * 		As posi��es 1 a 6 correspondem às quantidas de uns at� seis, ou seja, as laterais do placar.
	 * 		As outas posi��es s�o: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados Um array de inteiros, de tamanho 5.
	 * 		Cada posi��o corresponde a um valor de um dado.
	 * 		Sup�e-se que cada dado pode ter valor entre 1 e 6.
	 * @throws IllegalArgumentException
	 */
	public void add(int posicao, int[] dados) throws IllegalArgumentException {
		if (score[posicao] == -2) {
			dadosPosicao[posicao] = dados;
			score[posicao] = -1;
		} else {
			throw new IllegalArgumentException("Posi��o j� preenchida");
		}
	}
	
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posi��es que j� est�o ocupadas.
	 * @return O valor da soma.
	 */
	public int getScore() {
		int res = 0;
		int aux;
		
		for(int i = 0; i < 10; i++) {
			if(score[i] != -2) {
				score[i] = 0;
				if(i<6) {
					res += (i+1) * dadosIguais(i, (i+1));
					score[i] = (i+1) * dadosIguais(i, (i+1));
				} else if(i==6) {
					aux = 0;
					for(int j = 0; j < 6; j++) {
						
						if(dadosIguais(i, j+1) == 5) {
							res += 15;
							score[i] = 15;
						} else if(dadosIguais(i, j+1) == 3){
							aux++;
						} else if(dadosIguais(i, j+1) == 2){
							aux++;
						}

					}
					if(aux == 2) { 
						res+= 15;
						score[i] = 15;
					}
				} else if(i==7) {
					aux = 0;
					for(int j = 0; j < 6; j++) {
						if(dadosIguais(i, j+1) == 1)
							aux++;
					}
					if(aux == 5) {
						res+= 20;
						score[i] = 20;
					}
				} else if(i==8) {
					for(int j = 0; j < 6; j++) {
						if(dadosIguais(i, j+1) == 4) {
							res+= 30;
							score[i] = 30;
						}
							
					}
				} else if(i==9) {
					for(int j = 0; j < 6; j++) {
						if(dadosIguais(i, j+1) == 5) {
							res+= 40;
							score[i] = 40;
						}
							
					}
				}
			}
			
				
		}
		return res;
	}
	
	/**
	 * Retorna quantas vezes n se repete nos 5 dados de uma posi��o do placar.
	 * @param posicao Posi��o do placar
	 * @param n N�mero que ser� verificado
	 * @return n�mero de repeti��es
	 */
	private int dadosIguais(int posicao, int n) {
		int res = 0;
		for(int i = 0; i < 5; ++i) {
			if(dadosPosicao[posicao][i] == n) {
				res++;
			}
				
		}
		return res;
	}
	
	/**
	 * A representa��o na forma de string, mostra o placar completo,
	 * indicando quais s�o as posi��es livres (com seus respectivos n�meros)
	 * e o valor obtido nas posi��es j� ocupadas. Por exemplo: 
	 * <br>
	 *  (1)    |   (7)    |   (4) <br>
	 *  --------------------------<br>
	 *  (2)    |   20     |   (5) <br>
	 *  --------------------------<br>
	 *  (3)    |   30     |   (6) <br>
	 *  --------------------------<br>
	 *         |   (10)   |<br>
	 *         +----------+ 
	 *         
	 * mostra as posi��es 8 (sequencia) e 9 (quadra) ocupadas, no exemplo.
	 */
	@Override
	public String toString() {
		String ret = "\n\n";

		getScore(); // os valores de cada posi��o s�o atribuidos no m�todo getScore()
		
		ret += (score[0] == -2) ? " (1) " : " "+ score[0] +" ";
		ret += " | ";
		ret += (score[6] == -2) ? " (7) " : " "+ score[6] +" ";
		ret += " | ";
		ret += (score[3] == -2) ? " (4) " : " "+ score[3] +" ";
		ret += "\n";
		ret+= "---------------------\n";
		ret += (score[1] == -2) ? " (2) " : " "+ score[1] +" ";
		ret += " | ";
		ret += (score[7] == -2) ? " (8) " : " "+ score[7] +" ";
		ret += " | ";
		ret += (score[4] == -2) ? " (5) " : " "+ score[4] +" ";
		ret += "\n";
		ret+= "---------------------\n";
		ret += (score[2] == -2) ? " (3) " : " "+ score[2] +" ";
		ret += " | ";
		ret += (score[8] == -2) ? " (9) " : " "+ score[8] +" ";
		ret += " | ";
		ret += (score[5] == -2) ? " (6) " : " "+ score[5] +" ";
		ret += "\n";
		ret+= "---------------------\n";
		ret += (score[9] == -2) ? "      | (10)  |" : "      | "+ score[9] +"  |";
		ret += "\n";
		ret+= "      +-------+ \n\n";
		
		
	
		return ret;
	}
}
