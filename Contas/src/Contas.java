import java.io.IOException;
import java.util.LinkedList;

/**
 * Essa é a classe inicial do programa Contas. Possui um método main, que cuida da manipulação de contas.
 * 
 * @author Rafael Corradini da Cunha (9424322)
 *
 */
public class Contas {
	
	// Exibe todas as contas que estão na lista
	private static void printContas(LinkedList<ContaBancaria> contas) {
		for(ContaBancaria conta: contas) {
			System.out.println(conta);
		}
	}

	public static void main(String[] args) throws IOException {
		int opt = 0, c = 0, dia, tipo = 0, num = 0;
		String print, nome;
		double d;
		LinkedList<ContaBancaria> contas = new LinkedList<ContaBancaria>();
		
		while(true) {
			print =   "1 - Incluir uma nova conta\n";
			print +=  "2 - Sacar um determinado valor de uma conta\n";
			print +=  "3 - Depositar um determinado valor em uma conta\n" ;
			print +=  "4 - Atualizar o valor de todas as contas poupança de um determinado dia\n";
			print +=  "5 - Mostrar o saldo de cada uma das contas\n";
			print +=  "Outro - Sair\n";
			 
			System.out.println(print);
			opt = EntradaTeclado.leInt();
		
			
			
			switch(opt) {
				case 1: System.out.print("Tipo da Conta(1 - para poupança ou 2 - para especial): ");
						tipo = EntradaTeclado.leInt(1,2);
						
						
						System.out.println("Insira os dados da nova conta: ");
						System.out.print("Nome: ");
						nome = EntradaTeclado.leString();
						
						
						if(tipo == 1) {
							System.out.print("Dia do rendimento: ");
							dia = EntradaTeclado.leInt(1,31);
		
							contas.add(num, new ContaPoupanca(nome, num, dia));
						} else if(tipo == 2) {
							System.out.print("Limite: ");
							d = EntradaTeclado.leDouble();
							contas.add(num, new ContaEspecial(nome, num, d));
						} 
						num++;
						break;
						
				case 2: printContas(contas);
						System.out.print("Digite o número da conta: ");
						c = EntradaTeclado.leInt(0,contas.size()-1);
						System.out.println("Saldo disponível: "+ contas.get(c).getSaldo());
						System.out.println("Quanto deseja sacar? ");
						d = EntradaTeclado.leDouble();
						
						try {
							contas.get(c).saca(d);
							break;
						} catch(IllegalArgumentException e) {
							System.out.println(e);
						}
						break;
						
				case 3: printContas(contas);
						System.out.print("Digite o número da conta: ");
						c = EntradaTeclado.leInt(0,contas.size()-1);							

						System.out.println("Quanto deseja depositar? ");
						d = EntradaTeclado.leDouble();
						contas.get(c).deposita(d);
						break;
						
				case 4: System.out.print("Dia: ");
						dia = EntradaTeclado.leInt();
						for(ContaBancaria conta: contas) {
							try {
								if(((ContaPoupanca) conta).getVencimento() == dia)
									((ContaPoupanca) conta).atualizaSaldo(0.1);	
							} catch (ClassCastException e) {
								
							}							
						}
						
						break;
						
				case 5: for(ContaBancaria conta: contas) {
							System.out.println(conta + " - Saldo: "+ conta.getSaldo());						
						}
						break;
						
				default: System.exit(1);
				
			}
		}
		
	}

}
