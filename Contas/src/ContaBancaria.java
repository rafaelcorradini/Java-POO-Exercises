/**
* Classe criada para representar a conta bancaria de uma pessoa, e guardar informações como:
* Nome do proprietário da conta, número e saldo da conta. 
* 
* @author Rafael Corradini da Cunha (9424322)
*/
public class ContaBancaria {
	protected String nome;
	protected double saldo;
	protected int numero;
	
	/**
	* Construtor, inicializa os atributos da conta: nome e número da conta.
	* @param nome Nome do proprietário da conta.
	* @param numero Número da Conta.
	*/
	public ContaBancaria(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	/**
	* Altera o nome do proprietário da conta.
	* @param nome O novo nome da pessoa.
	*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	* Altera o número da conta.
	* @param numero O número da conta.
	*/
	public void setIdade(int numero) {
		this.numero = numero;
	}
	
	
	/**
	* Devolve o número da conta.
	* @return Retorna o número da conta.
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
	* @return Retorna o nome do proprietário da conta.
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
