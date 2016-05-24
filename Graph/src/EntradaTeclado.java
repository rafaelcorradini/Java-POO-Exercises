
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa fun��es para
 * ler strings, inteiros e doubles. 
 * Ela n�o faz verifica��es se o que foi digitado realmente
 * � o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);


	/**
	 * Le um string digitado pelo teclado, at� que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usu�rio.
	 * @throws IOException
	 */
	public static String leString() {
		String x;
		
		while (true) {
			
			try {
				x = br.readLine();
				return x;
			} catch (IOException e) {
				System.out.print("Entrada inv�lida, tente novamente.");
			}
		}

	}
	
	/**
	 * Le um char do teclado
	 * @return o string que foi digitado pelo usu�rio.
	 * @throws IOException
	 */
	public static char leChar() throws IOException {
		char x;
		x = (char) br.read();
		return x;

	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Verifica se o dado digitado pode ser convertido para um inteiro,
	 * se n�o for v�lida a entrada espera que o usu�rio digite novamente.
	 * @return  o valor inteiro digitado pelo usu�rio. 
	 * @throws IOException
	 */
	public static int leInt() throws IOException {
		
		while(true) {
			try {
				String x = leString();
				return Integer.parseInt(x);
			} catch(NumberFormatException e) {
				System.out.println("Entrada inv�lida, digite novamente: ");
			}
		}
		
		
	}
	
	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Verifica se o dado digitado pode ser convertido para um inteiro, e se est� dentro de [min, max].
	 * Se a entrada n�o for v�lida espera o usu�rio digitar novamente.
	 * @param min Valor m�nimo.
	 * @param max Valor m�ximo.
	 * @return  o valor inteiro digitado pelo usu�rio. 
	 * @throws IOException
	 */
	public static int leInt(int min, int max) throws IOException {
		
		while(true) {
			try {
				String x = leString();
				int a = Integer.parseInt(x);
				if(a>=min && a<=max) {
					return a;
				} else {
					throw new NumberFormatException("");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Entrada inv�lida, digite novamente: ");
			}
		}
		
		
	}
	
	

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num double. 
	 * Verifica se o dado digitado pode ser convertido para um double,
	 * se n�o for v�lida a entrada espera que o usu�rio digite novamente.
	 * @return  o valor double digitado pelo usu�rio. 
	 * @throws IOException
	 */

	public static double leDouble() throws IOException {
		
		while(true) {
			try {
				String x = leString();
				return Double.parseDouble(x);
			} catch(NumberFormatException e) {
				System.out.println("Entrada inv�lida, digite novamente: ");
			}
		}

	}
}