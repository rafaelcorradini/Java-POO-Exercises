
public class ExAgenda {

	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda();
		boolean x = true;
				
		
		while(x) {
			System.out.println("1 - insere na agenda");
			System.out.println("2 - remove da agenda");
			System.out.println("3 - imprime a agenda");
			System.out.println("4 - imprime dados da pessoa");
			System.out.println("Outro - Sair");
			switch(EntradaTeclado.leInt()) {
				case 1:  System.out.println("Digite nome, idade e altura: ");
						 agenda.armazenaPessoa(EntradaTeclado.leString(),EntradaTeclado.leInt(), (float)EntradaTeclado.leDouble());
						 break;
				case 2:  System.out.println("Digite o nome da pessoa que quer remover:");
						 agenda.removePessoa(EntradaTeclado.leString());
						 break;
				case 3:  agenda.imprimeAgenda();
						 break;
				case 4:  System.out.println("Digite o indice da pessoa q deseja mostrar:");
						 agenda.imprimePessoa(EntradaTeclado.leInt());
						 break;
				default: x = false; 
						 break;
			}
		}
		
	}

}
