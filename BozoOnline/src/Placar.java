import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Rafael Corradini da Cunha (9424322)<br>
 * Alan Nishimori Araujo (8066328) )
 */
public class Placar {
	private int[][] dadosPosicao = new int[10][5]; // Guarda os dados que estao na posicao
	private int[] score = new int[10]; // Guarda o score de cada posicao usada, -2 para posicao nao usada
	private static String[] nomes = new String[] {
			"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes",
			"Full", "Sequence", "Four of a kind", "General"
	};
	
	public Placar() {
		Arrays.fill(score, -2); // seta os valores de score -2 como padrão
	}
	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar.
	 * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 * @param posicao Posição a ser preenchida.
	 * 		As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar.
	 * 		As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados Um array de inteiros, de tamanho 5.
	 * 		Cada posição corresponde a um valor de um dado.
	 * 		Sup�e-se que cada dado pode ter valor entre 1 e 6.
	 * @throws IllegalArgumentException
	 */
	public void add(int posicao, int[] dados) throws IllegalArgumentException {
		if (score[posicao] == -2) {
			dadosPosicao[posicao] = dados;
			score[posicao] = -1;
		} else {
			throw new IllegalArgumentException("Posição já preenchida");
		}
	}
	
	/**
	 * Retona uma array com os pontos do placar
	 * @return Array com os pontos
	 */
	public int[] getArrayScore() {
		return score;
	}
	
	/**
	 * Retorna um array com os nomes
	 * @return Array com os nomes.
	 */
	public static String getName(int k) {
		return nomes[k];
	}
	
	/**
	 * Encontra o melhor lugar para ocupar no placar
	 * @param d Array de inteiros com os lados sorteados
	 * @return posição no placar.
	 */
	public int getMelhorScore(int[] d) {
		boolean flag1 = false;
		boolean flag2 = false;
		int iguais = 0;
		int t = 0;
		int m = 0;
		
		if(score[9] == -2 || score[8] == -2) {
			for(int j = 1; j <= 6; ++j) {
				iguais = 0;
				for(int i = 0; i < 5; ++i) {
					if(d[i] == j) {
						iguais++;
					}	
				}
				if(iguais == 5 && score[9] == -2) {
					return 10;
				} else if(iguais == 4 && score[8] == -2) {
					return 9;
				}
			}
		}
		
		
		
		if(score[7] == -2) {
			flag1 = true;
			for(int j = 0; j < 5; j++) {
				if((d[j] - d[j]) != 1) {
					flag1 = false;
					break;
				}	
			}
			if(flag1) {
				return 8;
			}
		}
		
		if(score[6] == -2) {
			flag1 = false;
			flag2 = false;
				
			for(int j = 1; j <= 6; ++j) {
				iguais = 0;
				for(int i = 0; i < 5; ++i) {
					if(d[i] == j) {
						iguais++;
					}	
				}
				if(iguais == 5) {
					flag1 = true;
					flag2 = true;
					break;
				}
				if(iguais == 3) {
					flag1 = true;
				} else if(iguais == 2) {
					flag2 = true;
				}
			}
	
			if(flag1 && flag2) { 
				return 7;
			}
		
		}
		
		if(score[5] == -2 || score[4] == -2 || score[3] == -2 || score[2] == -2 || score[1] == -2 || score[0] == -2) {
			flag1 = false;
			for(int j = 1; j <= 6; j++) {
				iguais = 0;
				for(int i = 0; i < 5; i++) {
					if(d[i] == j) {
						iguais++;
					}	
				}
				if((j*iguais > t) && (score[j-1] == -2)) {
					t = j*iguais;
					m = j;
					flag1 = true;
				}
					
			}	
			if(flag1)
				return m;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(score[i] == -2)
				return i+1;
		}
		return -1;		
	}
	
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 * @return O valor da soma.
	 */
	public int getScore() {
		int res = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		
		
		
		for(int i = 0; i < 10; i++) {
			Arrays.sort(dadosPosicao[i]);
			if(score[i] != -2) {
				score[i] = 0;
				if(i<6) {
					res += (i+1) * dadosIguais(i, (i+1));
					score[i] = (i+1) * dadosIguais(i, (i+1));
				} else if(i==6) {
					flag1 = false;
					flag2 = false;
					for(int j = 0; j < 6; j++) {
						
						if(dadosIguais(i, j+1) == 5) {
							res += 15;
							score[i] = 15;
							break;
						} else if(dadosIguais(i, j+1) == 3){
							flag1 = true;
						} else if(dadosIguais(i, j+1) == 2){
							flag2 = true;
						}

					}
					if(flag1 && flag2) { 
						res+= 15;
						score[i] = 15;
					}
				} else if(i==7) {
					flag1 = true;
					for(int j = 0; j < 5; j++) {
						if((dadosPosicao[i][j] - dadosPosicao[i][j]) != 1) {
							flag1 = false;
							break;
						}
					}
					if(flag1) {
						res+= 20;
						score[i] = 20;
					}
					
				} else if(i==8) {
					for(int j = 0; j < 6; j++) {
						if(dadosIguais(i, j+1) == 4) {
							res+= 30;
							score[i] = 30;
							break;
						}
							
					}
				} else if(i==9) {
					for(int j = 0; j < 6; j++) {
						if(dadosIguais(i, j+1) == 5) {
							res+= 40;
							score[i] = 40;
							break;
						}
							
					}
				}
			}
			
				
		}
		return res;
	}
	
	/**
	 * Retorna quantas vezes n se repete nos 5 dados de uma posição do placar.
	 * @param posicao Posição do placar
	 * @param n Número que será verificado
	 * @return número de repetições
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
	 * A representação na forma de string, mostra o placar completo, indicando quais são as
	 * posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas.
	 * Por exemplo: <br>
	 * <pre>
	 * (1)    |   (7)    |   (4) 
	 * --------------------------
	 * (2)    |   20     |   (5) 
	 * --------------------------
	 * (3)    |   30     |   (6) 
     *--------------------------
     *        |   (10)   |
     *        +----------+ 
     *</pre><br>
     *mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
	 */
	@Override
	public String toString() {
		String num;
		String s = "";
		
		getScore(); // os valores de cada posição são atribuidos no método getScore()
		
		for (int i = 0 ; i < 3; i++) {
			num = score[i] != -2 ? String.format("%-4d", score[i]) : "(" + (i+1) + ") ";
			s +=   num + "   |   ";
			num = score[i+6] != -2 ? String.format("%-4d", score[i+6]) : "(" + (i+7) + ") ";
			s +=   num + "   |   ";
			num = score[i+3] != -2 ? String.format("%-4d", score[i+3]) : "(" + (i+4) + ") ";
			s+= num + "\n--------------------------\n";
		}
		num = score[9] != -2 ? String.format("%-4d", score[9]) : "(" + 10 + ")";
		s += "       |   " + num + "   |";
		s += "\n       +----------+\n";
		return s;
	}
	
	public static void main(String[] args) {
		Placar p = new Placar();
		int[] d = {4,4,4,4,6};
		
		p.add(8, d);
		System.out.println(p.toString());
	}
}