
/**
* Classe que herda os métodos da classe ContaPoupanca, criada para representar a conta poupança ouro de uma pessoa.
* 
* @author Rafael Corradini da Cunha (9424322)
*/
public class PoupancaOuro extends ContaPoupanca {
	
	/**
	* Construtor, inicializa os atributos da conta: nome e dia de rendimento da conta.
	* @param nome Nome do proprietário da conta.
	* @param dia Dia de rendimento da Conta.
	*/
	public PoupancaOuro(String nome, int dia) {
		super(nome, dia);
	}
	
	/**
	* Atualiza o saldo da conta, calculando o rendimento, como é conta ouro, o rendimento é multiplicado por 1.5.
	* @return Retorna o saldo da conta após o calculo de rendimento.
	*/
	@Override
	public double atualizaSaldo(double taxaRendimento) {
		saldo = saldo+(saldo*(1.5*taxaRendimento));
		return saldo;
	}

}
