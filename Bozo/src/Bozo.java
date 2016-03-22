/**
 * Essa � a classe inicial do programa Boz�. Possui apenas o m�todo main, que cuida da execu��o do jogo.
 * @author Rafael Corradini da Cunha (9424322)<br>
 * Alan Nishimori Araujo (8066328) 
 */
public class Bozo {
	

	/**
	 * M�todo inicial do programa.
	 * Ele cuida da execu��o do jogo e possui um la�o, no qual cada itera��o representa uma rodada do jogo.
	 * Em cada rodada, o jogador joga os dados at� 3 vezes e depois escolhe a posi��o do placar que deseja preencher.
	 * No final das rodadas a pontua��o total � exibida.
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
			
			System.out.println("Digite os n�meros dos dados a serem rolados novamente (ex: 1 2 5) : ");		
			while(true) {
				try {
					ler = EntradaTeclado.leString();
					dadosSorteados = dados.rolar(ler);
					break;
				} catch (NumberFormatException e) { // caso seja digitado uma entrada inv�lida
					System.out.println("Entrada inv�lida, digite novamente: ");
				}
			}
			System.out.println(dados);
			
			System.out.println("Digite os n�meros dos dados a serem rolados novamente (ex: 1 2 5) : ");
			while(true) {
				try {
					ler = EntradaTeclado.leString();
					dadosSorteados = dados.rolar(ler);
					break;
				} catch (NumberFormatException e) { // caso seja digitado uma entrada inv�lida
					System.out.println("Entrada inv�lida, digite novamente: ");
				}
			}
			System.out.println(dados);
			
			System.out.print("Placar atual: "+ placar);
			
			System.out.println("Selecione qual posi��o quer ocupar: ");
			
			
			while(true) {
				try {
					aux = EntradaTeclado.leInt();
					placar.add(aux-1, dadosSorteados);
					if(aux>10 || aux<1) 
						throw new IllegalArgumentException("");
					break;
				} catch (IllegalArgumentException e) { // caso seja informada uma posi��o que n�o exista ou j� preenchida
					System.out.println("Posi��o inv�lida ou j� preenchida, digite novamente: ");
				}
			}
			
			System.out.print("Placar atualizado: "+ placar);
			
		}
		
		System.out.print("\nPontos obtidos: "+ placar.getScore());
	}

}
