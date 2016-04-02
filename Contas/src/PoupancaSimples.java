/**
*�Classe que herda os m�todos da classe ContaPoupanca, criada para representar a conta poupan�a ouro de uma pessoa.
* 
*�@author Rafael Corradini da Cunha (9424322)
*/

public class PoupancaSimples extends ContaPoupanca {
	
	/**
	* Construtor, inicializa os atributos da conta: nome e dia de rendimento da conta.
	* @param nome Nome do propriet�rio da conta.
	* @param dia Dia de rendimento da Conta.
	*/
	public PoupancaSimples(String nome, int dia) {
		super(nome, dia);
	}

}
