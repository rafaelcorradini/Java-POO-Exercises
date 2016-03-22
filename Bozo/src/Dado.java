/**
 * Simula um dado de número de lados variados.
 * Ao criar o objeto é possível estabelecer o número de lados.
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author 
 * Rafael Corradini da Cunha (9424322) <br>
 * Alan Nishimori Araujo (8066328) 
 */
public class Dado {
	
	private int lados;
	private int ladoCima;
	private Random rand;
	
	/**
	 * Não tem função real dentro da classe.
	 * Foi usada apenas para testar os métodos implementados
	 * @param args Sem uso.
	 */
	public static void main(String[] args) {
		Dado d = new Dado();
		d.rolar();
		System.out.println("Lado sorteado: \n"+d);
	}
	
	/**
	 * Transforma representação do dado em String.
	 * É mostrada uma representação do dado que está para cima.
	 * Note que não funciona corretamente para dados de 6 lados. Exemplo:
	 * <br>
	 * +-----+    +-----+    +-----+    +-----+    +-----+    <br>
	 * |*   *|    |     |    |*    |    |*    |    |*   *|    <br>
	 * |  *  |    |  *  |    |     |    |  *  |    |     |    <br>
	 * |*   *|    |     |    |    *|    |    *|    |*   *|    <br>
	 * +-----+    +-----+    +-----+    +-----+    +-----+
	 * 
	 * @return Retorna a string com a representaÃ§Ã£o.
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
	 * Cria objeto com um número qualquer de lados
	 * @throws IllegalArgumentException se o numero de lados for menor ou igual a um.
	 * @param n Número de lados do dado
	 */
	public Dado(int n) {
		if (n <= 1)
			throw new IllegalArgumentException("O numero de lados deve ser maior que 1");
		rand = new Random();
		lados = n;
		rolar();
	}
	
	/**
	 * Simula a rolagem do dado por meio de um gerador aleatório.
	 * O número selecionado pode posteriormente ser recuperado com a chamada a getLado().
	 * @return retorna o número sorteado
	 */
	public int rolar() {
		try {
			ladoCima = rand.getIntRand(1, lados+1);
		} catch(IllegalArgumentException e) {
			System.out.println("Número de lados inválido");
		}	
		
		return getLado();
	}

	
	/**
	 * Recupera o último sorteio feito com o dado.
	 * @return o número do último lado selecionado.
	 */
	public int getLado() {
		return ladoCima;
	}
	
	

}
