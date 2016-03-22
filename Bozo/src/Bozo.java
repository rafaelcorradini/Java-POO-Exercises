/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Rafael Corradini da Cunha (9424322)<br>
 * Alan Nishimori Araujo (8066328) 
 */
public class Bozo {
	

	/**
	 * Método inicial do programa.
	 * Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa uma rodada do jogo.
	 * Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher.
	 * No final das rodadas a pontuação total é exibida.
	 * @param args -
	 * @throws Exception -
	 */
	public static void main(String[] args) throws Exception {
		Placar placar = new Placar();
		RolaDados dados= new RolaDados(5);
		
		int[] dadosSorteados = new int[5];
		int aux;
		String ler = "";
		
		for(int i = 0; i<10; i++) {
			System.out.print("Pressione enter para iniciar a rodada "+ (i+1));
			
			EntradaTeclado.leString();
			
			dadosSorteados = dados.rolar();
			System.out.println(dados);
			
			System.out.println("Digite os números dos dados a serem rolados novamente (ex: 1 2 5) : ");		
			while(true) {
				try {
					ler = EntradaTeclado.leString();
					dadosSorteados = dados.rolar(ler);
					break;
				} catch (NumberFormatException e) { // caso seja digitado uma entrada inválida
					System.out.println("Entrada inválida, digite novamente: ");
				}
			}
			System.out.println(dados);
			
			System.out.println("Digite os números dos dados a serem rolados novamente (ex: 1 2 5) : ");
			while(true) {
				try {
					ler = EntradaTeclado.leString();
					dadosSorteados = dados.rolar(ler);
					break;
				} catch (NumberFormatException e) { // caso seja digitado uma entrada inválida
					System.out.println("Entrada inválida, digite novamente: ");
				}
			}
			System.out.println(dados);
			
			System.out.print("Placar atual: "+ placar);
			
			System.out.println("Selecione qual posição quer ocupar: ");
			
			
			while(true) {
				try {
					aux = EntradaTeclado.leInt();
					placar.add(aux-1, dadosSorteados);
					if(aux>10 || aux<1) 
						throw new IllegalArgumentException("");
					break;
				} catch (IllegalArgumentException e) { // caso seja informada uma posição que não exista ou já preenchida
					System.out.println("Posição inválida ou já preenchida, digite novamente: ");
				}
			}
			
			System.out.print("Placar atualizado: "+ placar);
			
		}
		
		System.out.print("\nPontos obtidos: "+ placar.getScore());
	}

}
