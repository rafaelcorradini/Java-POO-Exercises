/**
 * Simula um dado de número de lados variados.
 * Ao criar o objeto é possível estabelecer o número de lados.
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author 
 * Rafael Corradini da Cunha (9424322)
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
	
	private String  s010 = "|  *  |\n",
					s100 = "|*    |\n",
					s001 = "|    *|\n",
					s000 = "|     |\n",
					s101 = "|*   *|\n",
					s111 = "|* * *|\n";

	/**
	 * Transforma representação do dado em String. É mostrada
	 * uma representação do dado que está para cima. Note que só
	 * funciona corretamente para dados de 6 lados. Exemplo:<br>
	 * <pre>
			+-----+    
			|*   *|    
			|  *  |    
			|*   *|    
			+-----+    
	 * </pre><br>
	 */
	@Override
	public String  toString()
	{
		if (lados != 6 ) return "Não há representação para esse dados";
		String s = "+-----+\n";
		switch (getLado()) {
			case 1:
				s += (s000 + s010 + s000);
				break;
			case 2:
				s += (s100 + s000 + s001);
				break;
			case 3:
				s += (s100 + s010 + s001);
				break;
			case 4:
				s += (s101 + s000 + s101);
				break;
			case 5:
				s += (s101 + s010 + s101);
				break;
			case 6:
				s += (s111 + s000 + s111);
			break;
			
		}
		s += ("+-----+\n");
		return s;
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
	 * Cria objeto com um n�mero qualquer de lados
	 * @throws IllegalArgumentException se o numero de lados for menor ou igual a um.
	 * @param n N�mero de lados do dado
	 */
	public Dado(int n, int ladoCima) {
		if (n <= 1)
			throw new IllegalArgumentException("O numero de lados deve ser maior que 1");
		rand = new Random();
		lados = n;
		this.ladoCima = ladoCima;
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
