/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente.
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * 
 * @author
 * Eduardo A Pacheco (8632455)<br>
 * Rafael C da Cunha (9424322)
 *	
 */
public class RolaDados {
	private Dado[] dados;
	private int dadosc;

	/**
	 * Construtor que cria e armazena vários objetos do tipo {@link Dado}.
	 * 		Usa para isso o construtor padrão daquela classe, ou seja,
	 * 		um dado de 6 lados e gerando sempre uma semente aleatória para o gerador de números aleatórios.
	 * 		Os dados criados podem ser referenciados por números, entre 1 e n.
	 * @param n Número de dados a serem criados.
	 */
	public RolaDados(int n) {
		if (n < 1)
			throw new IllegalArgumentException("o numero de dados tem que ser maior que zero");
		
		dadosc = n;
		dados = new Dado[n];
		
		for (int i = 0; i < dadosc; ++i)
			dados[i] = new Dado();
	}
	
	
	/**
	 * Rola todos os dados.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados.
	 * 		   Nesse caso, o valor retornado é o valor anterior que ele já possuía.
	 */
	public int[] rolar() {
		int[] ret = new int [dadosc];
		
		for (int i = 0; i < dadosc; ++i)
			ret[i] = dados[i].rolar();
		
		return ret;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param quais É um array de booleanos que indica quais dados devem ser rolados.
	 * 		  Cada posição representa um dos dados.
	 * 		  Ou seja, a posição 0 do array indica se o dado 1 deve ser rolado ou não, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados.
	 *		   Nesse caso, o valor retornado é o valor anterior que ele já possuía.
	 */
	public int[] rolar(boolean[] quais) {
		int[] ret = new int [dadosc];
		
		for (int i = 0; i < dadosc; ++i) {
			if (quais[i]) {
				ret[i] = dados[i].rolar();
			} else {
				ret[i] = dados[i].getLado();
			}
		}
			
		
		return ret;
	}
	
	/**
	 * Troca os dados
	 * @param sd Novos dados
	 */
	public void trocarDados(String sd) {
		String[] arrd = sd.split(" ");
		int i = 0;
		
		for(String a: arrd) {
			dados[i] = new Dado(6, Integer.parseInt(a));
			i++;
		}
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param str É um String que possui o número dos dados a serem rolados.
	 * 		      Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados.
	 * 		      Os números devem ser separados por espaços.
	 * 		      Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
	 * @return o valor de cada um dos dados, inclusive os que não foram rolados.
	 * 		   Nesse caso, o valor retornado é o valor anterior que ele já possuía
	 */
	public int[] rolar(String str) {
		int [] ret = new int [dadosc];
		if(!str.isEmpty()) {
			String[] sstr = str.split(" ");
			
			for (int i = 0; i < sstr.length; i++) {
				int pos = Integer.parseInt(sstr[i]);
				if (pos > 0 && pos <= dadosc)
					dados[pos - 1].rolar();
			}
		}
		
			
		for (int i = 0; i < dadosc; i++)
			ret[i] = dados[i].getLado();
		
		return ret;
	}
	
	/**
	 * Escolhe qual a melhor jogada a ser feita, quais dados devem ser rolados.
	 * @param placar Placar atual
	 * @return retorna string que dispõe a melhor jogada a ser feita
	 */
	public String melhorRolar(Placar placar) {
		String ret = "";
		int d[] = rolar("");
		int ms = placar.getMelhorScore(rolar("")), aux1 = -1, aux2 = 0;
		
		if(ms > 6) {
			if(ms == 9) {				
				for (int i = 0; i < dadosc; i++) {
					if(aux1 == -1)
						aux1 = i;
					else if(d[aux1] == d[i])
						break;
					aux1 = i;	
				}
				
				for (int i = 0; i < dadosc; i++) {					
					if(d[i] != d[aux1]) {
						aux2 = i;
					}
				}
				
				for(int i = 0; i < dadosc; i++) {
					if(i == aux2)
						ret+= "1 ";
					else
						ret+= "0 ";
				}
				return ret;
					
			}
			
			return "0 0 0 0 0";
				
		} else {
			for(int i = 0; i < dadosc; i++) {
				if(d[i] == ms)
					ret+= "0 ";
				else
					ret+= "1 ";
			}
			
			return ret;
		}
		
	}
	
	/**
	 * Retorna uma String com os 5 números dos dados que foram sorteados no último rolar
	 * @return String com os lados que estão para cima dos dados.
	 */
	public String strDados() {
		int[] dadosSorteados = rolar("");
		String ler = "";
		for(int d: dadosSorteados) {
			ler += d+" ";
		}
		return ler;
	}
	
	/**
	* Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horisontalmente, por exemplo:<br>
	* <br>
 	* 1          2          3          4          5<br>
	* +-----+    +-----+    +-----+    +-----+    +-----+    <br>
	* |*   *|    |     |    |*    |    |*    |    |*   *|    <br>
	* |  *  |    |  *  |    |     |    |  *  |    |     |    <br>
	* |*   *|    |     |    |    *|    |    *|    |*   *|    <br>
	* +-----+    +-----+    +-----+    +-----+    +-----+
	*/
	@Override
	public String toString() {
		String ret = "";
		String[][] sstr = new String[dadosc][];
		
		
		for (int i = 0; i < dadosc; ++i)
			sstr[i] = dados[i].toString().split("\\n");
		
		for (int i = 0; i < dadosc; ++i) {
			ret += i + 1;
			ret += "       ";
		}
		
		ret += '\n';

		for (int i = 0; i < sstr.length; ++i) {
			for (int j = 0; j < dadosc; ++j)
				ret += sstr[j][i] + ' ';
			ret += '\n';
		}
		
		ret += '\n';
		return ret;
	}
	
	public static void main(String[] args) {
		RolaDados rd = new RolaDados(5);
		System.out.println(rd);

		rd.rolar();
		System.out.println(rd);
		
		boolean[] b = new boolean[] {false, false, true, false, false};
		rd.rolar(b);
		System.out.println(rd);
		
		rd.rolar("2 5 6");
		System.out.println(rd);
	}
}