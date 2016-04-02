/**
*�Classe abstrata que herda os m�todos da classe ContaBancaria, criada para representar a conta poupan�a de uma pessoa.
* 
*�@author Rafael Corradini da Cunha (9424322)
*/
public abstract class ContaPoupanca extends ContaBancaria {
	private int vencimento;
	
	
	/**
	* Construtor, inicializa os atributos da conta: nome e dia de rendimento da conta.
	* @param nome Nome do propriet�rio da conta.
	* @param dia Dia de rendimento da Conta.
	*/
	public ContaPoupanca(String nome, int dia) {
		super(nome);
		vencimento = dia;
	}
	
	/**
	*�Altera o dia de rendimento da conta.
	* @param dia O novo dia de rendimento da conta.
	*/	
	public int setVencimento(int dia) {
		return vencimento = dia;
	}
	
	/**
	* Devolve o dia de rendimento da conta.
	* @return Retorna o dia de rendimento.
	*/
	public int getVencimento() {
		return vencimento;
	}
	
	/**
	* Atualiza o saldo da conta, calculando o rendimento.
	* @return Retorna o saldo da conta ap�s o calculo de rendimento.
	*/
	@Override
	public double atualizaSaldo(double taxaRendimento) {
		saldo = saldo+(saldo*taxaRendimento);
		return saldo;
	}
	
	/**
	* Retorna uma string com o modelo - Conta: 123 - Nome: Rafael - Dia do rendimento: 10   
	* @return Retorna a string com os dados da conta.
	*/
	@Override
	public String toString() {
		String str;
		str = "\nConta: "+ numero +" - Nome: "+ nome + " - Dia do rendimento: " +vencimento;
		return str;
		
	}
	
}


