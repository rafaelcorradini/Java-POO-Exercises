/**
* Classe criada para representar uma pessoa e guardar suas informações:
* Nome, idade e altura. 
* 
* @author Rafael Corradini da Cunha
*/
public class Pessoa {
	private String nome;
	private int idade;
	private float altura;
	
	/**
	* Construtor, inicializa os atributos da pessoa: nome, idade e altura.
	* @param n O nome da pessoa.
	* @param i A idade.
	* @param a A altura.
	*/
	public Pessoa(String n, int i, float a) {
		nome = n;
		idade = i;
		altura = a;
	}
	
	/**
	* Altera o nome da pessoa.
	* @param n O novo nome da pessoa.
	*/
	public void setNome(String n) {
		nome = n;
	}
	
	/**
	* Altera a idade da pessoa.
	* @param i A nova idade da pessoa.
	*/
	public void setIdade(int i) {
		idade = i;
	}
	
	/**
	* Altera a altura da pessoa.
	* @param a A nova altura da pessoa.
	*/
	public void setAltura(float a) {
		altura = a;
	}
	
	/**
	* Devolve a altura da pessoa.
	* @return Retorna a altura da pessoa.
	*/
	public double getAltura() {
		return altura;
	}
	
	/**
	* Devolve a idade da pessoa.
	* @return Retorna a idade da pessoa.
	*/
	public double getIdade() {
		return idade;
	}
	
	/**
	* Devolve o nome da pessoa.
	* @return Retorna o nome da pessoa.
	*/
	public String getNome() {
		return nome;
	}
	
	/**
	* Exibe nome, idade e altura da pessoa na tela.
	*/
	public void imprimeDados() {
		System.out.println("Nome: "+ nome +"\nIdade: "+ idade +"\nAltura: "+ altura);
	}
}
