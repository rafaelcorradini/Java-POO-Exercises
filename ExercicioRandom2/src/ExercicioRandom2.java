public class ExercicioRandom2 {

	public static void main(String[] args) throws Exception {
		System.out.println("Forne�a um n�mero inteiro para ser usado como semente: ");
		int x = EntradaTeclado.leInt();
		Random rand1 = new Random(x);
		Random rand2 = new Random();
	
		int k1 = 0,k2 = 1, cont = 0;
		
		System.out.println("xi: "+rand1);
		while(k1 != k2) {	
			k1 = rand1.getIntRand(501);
			k2 = rand2.getIntRand(501);	
			cont++;
		}
		System.out.println("N�mero gerado: "+ k1 +"\nN�mero de itera��es: "+ cont);
	}

}
