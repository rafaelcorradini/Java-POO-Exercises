
public class ObesidadePessoa {
	private double peso;
	private double altura;
	private
	
	public void setPeso(double p) {
		peso = p;
	}
	
	public void setAltura(double a) {
		altura = a;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double calculaIMC() {
		return peso/(altura*altura);
	}
	
	public void defineObesidade() {
		if(calculaIMC() > 25) 
			System.out.println("Risco de obesidade.");
		else
			System.out.println("Não há risco de obesidade.");
	}
}
