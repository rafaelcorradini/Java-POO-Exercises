import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntradaTeclado {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	public static String leString() throws IOException {
		String x;
		x = br.readLine();
		return x;

	}

	public static int leInt() throws IOException {
		String x = leString();
		return Integer.parseInt(x);
	}
}