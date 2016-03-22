/**
* Classe que herda os métodos da classe ContaBancaria, criada para representar a conta especial de uma pessoa, e guardar informações como:
* Nome do proprietário da conta, número, saldo e limite devedor da conta. 
* 
* @author Rafael Corradini da Cunha (9424322)
*/
public class ContaEspecial extends ContaBancaria {
	private double limite;
	
	/**
	* Construtor, inicializa os atributos da conta: nome, número e dia de rendimento da conta.
	* @param nome Nome do proprietário da conta.
	* @param numero Número da conta.
	* @param limite Limite devedor da Conta.
	*/
	public ContaEspecial(String nome, int numero, double limite) {
		super(nome, numero);
		this.limite = limite;
	}
	
	/**
	* Altera o limite devedor da conta.
	* @param valor O novo limite devedor da conta.
	*/	
	public double setLimite(double valor) {
		return limite = valor;
	}
	
	/**
	* Devolve o limite devedor da conta.
	* @return Retorna o limite devedor.
	*/
	public double getLimite() {
		return limite;
	}
	
	/**
	* Saca um determinado valor da conta.
	* @param valor Valor a ser sacado.
	* @return Retorna o saldo atual da conta.
	*/
	@Override
	public double saca(double valor) {
		if((saldo + limite) >= valor)
			saldo = saldo - valor;
		else 
			throw new IllegalArgumentException("Saldo insuficiente.");
		return saldo;		
	}
	
	/**
	* Retorna uma string com o modelo - Conta: 123 - Nome: Rafael - Limite devedor: 1000
	* @return Retorna a string com os dados da conta.
	*/
	@Override
	public String toString() {
		String str;
		str = "\nConta: "+ numero +" - Nome: "+ nome + " - Limite devedor: " +limite;
		return str;
		
	}
}
