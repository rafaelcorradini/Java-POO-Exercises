
public class ExercicioObesidade {

	public static void main(String[] args) throws Exception {
		ObesidadePessoa pessoa = new ObesidadePessoa();
		
		System.out.println("Peso: ");
		pessoa.setPeso(EntradaTeclado.leDouble());
		System.out.println("Altura(ex: 1.7): ");
		pessoa.setAltura(EntradaTeclado.leDouble());
		
		System.out.println("Altura: "+pessoa.getAltura());
		
		pessoa.defineObesidade();
	}

}
