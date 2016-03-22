/**
* Classe criada para representar uma agenda que armazena até 10 pessoas.
*
* @author Rafael Corradini
*/
public class Agenda {
	Pessoa[] agenda = new Pessoa[10];
	
	/**
	* Insere uma pessoa na agenda.
	* @param nome O nome da pessoa a ser inserida.
	* @param idade A idade da pessoa a ser inserida.
	* @param altura A altura da pessoa a ser inserida.
	*/
	public void armazenaPessoa(String nome, int idade, float altura) {
		for(int i = 0; i < 10; i++) {
			if(agenda[i] == null) {
				agenda[i] = new Pessoa(nome, idade, altura);
				break;
			}	
		}
		
	}
	
	/**
	* Busca uma pessoa na agenda pelo nome, e a remove.
	* @param nome O nome da pessoa a ser removida.
	*/
	public void removePessoa(String nome) {
		if(buscaPessoa(nome) >= 0) {
			agenda[buscaPessoa(nome)] = null;
		} else {
			System.out.println("Pessoa inexistente\n");
		}
	}
	
	/**
	* Busca uma pessoa na agenda pelo nome.
	* @param nome O nome da pessoa a ser encontrada.
	* @return Retorna a posição da pessoa na agenda, 
	* caso não encontre a pessoa retorna um número negativo.
	*/
	public int buscaPessoa(String nome) {
		for(int i = 0; i < 10; i++) {
			if(agenda[i] != null)
				if(agenda[i].getNome().equals(nome))
					return i;
		}
		return -1;
	}
	
	/**
	* Exibe na tela os dados de todas as pessoas da agenda.
	*/
	public void imprimeAgenda() {
		for(int i = 0; i < 10; i++) {
			if(agenda[i] != null) {
				System.out.println(i +": ");
				agenda[i].imprimeDados();
			}	
		}
	}
	
	/**
	* Exibe na tela os dados da pessoa que está na posição "i" da agenda.
	* @param i A posição da pessoa na agenda.
	*/
	public void imprimePessoa(int i) {
		if(agenda[i] != null) {
			agenda[i].imprimeDados();
		} else {
			System.out.println("Pessoa inexistente\n");
		}
	}
}
