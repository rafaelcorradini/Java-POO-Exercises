/**
*�Classe criada para representar a conta bancaria de uma pessoa, e guardar informa��es como:
* Nome do propriet�rio da conta, n�mero e saldo da conta. 
* 
*�@author Rafael Corradini da Cunha (9424322)
*/
public class ContaBancaria {
	protected String nome;
	protected double saldo;
	protected int numero;
	
	/**
	* Construtor, inicializa os atributos da conta: nome e n�mero da conta.
	* @param nome Nome do propriet�rio da conta.
	* @param numero N�mero da Conta.
	*/
	public ContaBancaria(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	/**
	*�Altera o nome do propriet�rio da conta.
	* @param nome O novo nome da pessoa.
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	*�Altera o n�mero da conta.
	* @param numero O n�mero da conta.
	*/
	public void setIdade(int numero) {
		this.numero = numero;
	}
	
	
	/**
	* Devolve o n�mero da conta.
	* @return Retorna o n�mero da conta.
	*/
	public double getNumero() {
		return numero;
	}
	
	/**
	* @return Retorna o saldo da conta.
	*/
	public double getSaldo() {
		return saldo;
	}
	
	/**
	* @return Retorna o nome do propriet�rio da conta.
	*/
	public String getNome() {
		return nome;
	}
	
	/**
	* Deposita um determinado valor na conta.
	* @param valor Valor a ser depositado.
	* @return Retorna o saldo atual da conta.
	*/
	public double deposita(double valor) {
		saldo = saldo + valor;
		return saldo;
	}
	
	/**
	* Saca um determinado valor da conta.
	* @param valor Valor a ser sacado.
	* @return Retorna o saldo atual da conta.
	*/
	public double saca(double valor) {
		if(saldo>=valor)
			saldo = saldo - valor;
		else 
			throw new IllegalArgumentException("Saldo insuficiente.");
		return saldo;
		
	}
	
	/**
	* Retorna uma string com o modelo - Conta: 123 - Nome: Rafael
	* @return Retorna a string com os dados da conta.
	*/
	@Override
	public String toString() {
		String str;
		str = "\nConta: "+ numero +" - Nome: "+ nome;
		return str;
		
	}
}
