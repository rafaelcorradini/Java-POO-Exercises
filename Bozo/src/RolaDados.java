/**
 * Essa � uma classe auxiliar que permite gerencia um conjunto de v�rios dados simultaneamente.
 * Opera��es como rolar alguns dos dados ou exibir o resultado de todos eles, s�o implementadas.
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
	 * Construtor que cria e armazena v�rios objetos do tipo {@link Dado}.
	 * 		Usa para isso o construtor padr�o daquela classe, ou seja,
	 * 		um dado de 6 lados e gerando sempre uma semente aleat�ria para o gerador de n�meros aleat�rios.
	 * 		Os dados criados podem ser referenciados por n�meros, entre 1 e n.
	 * @param n N�mero de dados a serem criados.
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
	 * @return Retorna o valor de cada um dos dados, inclusive os que n�o foram rolados.
	 * 		   Nesse caso, o valor retornado � o valor anterior que ele j� possu�a.
	 */
	public int[] rolar() {
		int[] ret = new int [dadosc];
		
		for (int i = 0; i < dadosc; ++i)
			ret[i] = dados[i].rolar();
		
		return ret;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param quais � um array de booleanos que indica quais dados devem ser rolados.
	 * 		  Cada posi��o representa um dos dados.
	 * 		  Ou seja, a posi��o 0 do array indica se o dado 1 deve ser rolado ou n�o, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que n�o foram rolados.
	 *		   Nesse caso, o valor retornado � o valor anterior que ele j� possu�a.
	 */
	public int[] rolar(boolean[] quais) {
		int[] ret = new int [dadosc];
		
		for (int i = 0; i < dadosc; ++i)
			if (quais[i])
				ret[i] = dados[i].rolar();
		
		return ret;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param str � um String que possui o n�mero dos dados a serem rolados.
	 * 		      Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados.
	 * 		      Os n�meros devem ser separados por espa�os.
	 * 		      Se o valor passado no string estiver fora do intervalo v�lido, ele � ignorado simplesmente.
	 * @return o valor de cada um dos dados, inclusive os que n�o foram rolados.
	 * 		   Nesse caso, o valor retornado � o valor anterior que ele j� possu�a
	 */
	public int[] rolar(String str) {
		int [] ret = new int [dadosc];
		if(!str.isEmpty()) {
			String[] sstr = str.split(" ");
			
			for (int i = 0; i < sstr.length; ++i) {
				int pos = Integer.parseInt(sstr[i]);
				if (pos > 0 && pos <= dadosc)
					dados[pos - 1].rolar();
			}
		}
		
			
		for (int i = 0; i < dadosc; ++i)
			ret[i] = dados[i].getLado();
		
		return ret;
	}
	
	/**
	* Usa a representa��o em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horisontalmente, por exemplo:<br>
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