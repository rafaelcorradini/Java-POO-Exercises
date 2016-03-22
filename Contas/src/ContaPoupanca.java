/**
* Classe que herda os métodos da classe ContaBancaria, criada para representar a conta poupança de uma pessoa, e guardar informações como:
* Nome do proprietário da conta, número, saldo e dia de rendimento da conta. 
* 
* @author Rafael Corradini da Cunha (9424322)
*/
public class ContaPoupanca extends ContaBancaria {
	private int vencimento;
	
	/**
	* Construtor, inicializa os atributos da conta: nome, número e dia de rendimento da conta.
	* @param nome Nome do proprietário da conta.
	* @param numero Número da conta.
	* @param dia Dia de rendimento da Conta.
	*/
	public ContaPoupanca(String nome, int numero, int dia) {
		super(nome, numero);
		vencimento = dia;
	}
	
	/**
	* Altera o dia de rendimento da conta.
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
	* @return Retorna o saldo da conta após o calculo de rendimento.
	*/
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


