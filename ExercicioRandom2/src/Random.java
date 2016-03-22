import java.util.Calendar;

public class Random {
	private long p = 2147483648L;
	private long m = 843314861L;
	private long a = 453816693L;
	private long xi = 1023L; // semente
	
	@Override
	public String toString() {
		return ""+(xi);
	}
	
	public Random(int k) {
		xi = k;
	}
	
	public Random() {
		xi = (int) Calendar.getInstance().getTimeInMillis();
	}
	
	public void setSemente(int k) {
		xi = k;
	}
	
	public double getRand() {
		// calcula o próximo valor xi
		// calcula um valor entre 0 e 1, divindo por p
		xi = (a + m * xi ) % p;
		double d = xi;
		return d / p;
	}
	
	public int getIntRand(int max) {
		// gera valor entre [0, 1)
		// multiplica por maxreturn (int) d;
		double d = max * getRand();
		return (int) d;
	}
	
	public int getIntRand() {
		// multiplica por maxreturn (int) d;
		double d = getIntRand();
		return (int) d;
	}
	
	public int getIntRand(int min, int max) throws IllegalArgumentException {
		if(max <= min) {
			throw new IllegalArgumentException("Parâmetros inválidos");
		}
		double d = min + getIntRand(max-min);
		return (int) d;
	}
}
