/**
 * Simula um dado de n�mero de lados variados.
 * Ao criar o objeto � poss�vel estabelecer o n�mero de lados.
 * A rolagem do dado � feita por meio de um gerador de n�meros aleat�rios (Random).
 * @author 
 * Rafael Corradini da Cunha (9424322) <br>
 * Alan Nishimori Araujo (8066328) 
 */
public class Dado {
	
	private int lados;
	private int ladoCima;
	private Random rand;
	
	/**
	 * N�o tem fun��o real dentro da classe.
	 * Foi usada apenas para testar os m�todos implementados
	 * @param args Sem uso.
	 */
	public static void main(String[] args) {
		Dado d = new Dado();
		d.rolar();
		System.out.println("Lado sorteado: \n"+d);
	}
	
	/**
	 * Transforma representa��o do dado em String.
	 * � mostrada uma representa��o do dado que est� para cima.
	 * Note que n�o funciona corretamente para dados de 6 lados. Exemplo:
	 * <br>
	 * +-----+    +-----+    +-----+    +-----+    +-----+    <br>
	 * |*   *|    |     |    |*    |    |*    |    |*   *|    <br>
	 * |  *  |    |  *  |    |     |    |  *  |    |     |    <br>
	 * |*   *|    |     |    |    *|    |    *|    |*   *|    <br>
	 * +-----+    +-----+    +-----+    +-----+    +-----+
	 * 
	 * @return Retorna a string com a representação.
	 */
	@Override
	public String toString() {
		String r = "";
		switch(ladoCima) {
			case 1: r += "+-----+\n"; 
					r += "|     |\n"; 
					r += "|  *  |\n"; 
					r += "|     |\n"; 
					r += "+-----+\n"; 
					break;
			case 2: r += "+-----+\n"; 
					r += "|    *|\n"; 
					r += "|     |\n"; 
					r += "|*    |\n"; 
					r += "+-----+\n"; 
					break;
			case 3: r += "+-----+\n"; 
					r += "|    *|\n"; 
					r += "|  *  |\n"; 
					r += "|*    |\n"; 
					r += "+-----+\n"; 
					break;
			case 4: r += "+-----+\n"; 
					r += "|*   *|\n"; 
					r += "|     |\n"; 
					r += "|*   *|\n"; 
					r += "+-----+\n"; 
					break;
			case 5: r += "+-----+\n"; 
					r += "|*   *|\n"; 
					r += "|  *  |\n"; 
					r += "|*   *|\n"; 
					r += "+-----+\n"; 
					break;
			case 6: r += "+-----+\n"; 
					r += "|*   *|\n"; 
					r += "|*   *|\n"; 
					r += "|*   *|\n"; 
					r += "+-----+\n"; 
					break;
		}
		return r;
	}
	
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado() {
		lados = 6;
		rand = new Random();
		rolar();
	}
	
	/**
	 * Cria objeto com um n�mero qualquer de lados
	 * @throws IllegalArgumentException se o numero de lados for menor ou igual a um.
	 * @param n N�mero de lados do dado
	 */
	public Dado(int n) {
		if (n <= 1)
			throw new IllegalArgumentException("O numero de lados deve ser maior que 1");
		rand = new Random();
		lados = n;
		rolar();
	}
	
	/**
	 * Simula a rolagem do dado por meio de um gerador aleat�rio.
	 * O n�mero selecionado pode posteriormente ser recuperado com a chamada a getLado().
	 * @return retorna o n�mero sorteado
	 */
	public int rolar() {
		try {
			ladoCima = rand.getIntRand(1, lados+1);
		} catch(IllegalArgumentException e) {
			System.out.println("N�mero de lados inv�lido");
		}	
		
		return getLado();
	}

	
	/**
	 * Recupera o �ltimo sorteio feito com o dado.
	 * @return o n�mero do �ltimo lado selecionado.
	 */
	public int getLado() {
		return ladoCima;
	}
	
	

}
