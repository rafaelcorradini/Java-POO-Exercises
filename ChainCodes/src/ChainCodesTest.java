import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe usada para testes. Utiliza-se do JUnit. 
 * @author Rafael Corradini da Cunha (9424322) <br> Guilherme Alves Campos (8522320)
 *
 */
public class ChainCodesTest {
	
	/**
	 * Checa o funcionamento do algorismo ChainCodes através do método {@link ChainCodes#toString()}
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		String chainCode = img.toString();
		
		assertEquals(chainCode, "0007007777667666566555544544434433332232221221111001");
	}
	
	/**
	 * Checa o método {@link ChainCodes#numBorda()}
	 * @throws Exception
	 */
	@Test
	public void testNumBorda() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		int numBorda = img.numBorda();
		
		assertEquals(numBorda, 52);
		
	}
	/**
	 * Checa o método {@link ChainCodes#perimetro()}
	 * @throws Exception
	 */
	@Test
	public void testPerimetro() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		double perimetro = img.perimetro();
		double expected = 61.94112549695426;
		
		assertEquals((int)perimetro, (int)expected);
	}

	/**
	 * Checa o método {@link ChainCodes#pontoInicial()}
	 * @throws Exception
	 */
	@Test
	public void testPontoInicial() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		
		assertEquals (img.pontoInicial(),  "23x16");
	}

	/**
	 * Checa o método {@link ChainCodes#objWidth()}
	 * @throws Exception
	 */
	@Test
	public void testObjWidth() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		
		assertEquals(20, img.objWidth());
	}

	/**
	 * Checa o método {@link ChainCodes#objHeight()}
	 * @throws Exception
	 */
	@Test
	public void testObjHeight() throws Exception{
		ChainCodes img = new ChainCodes("src/circulo.png");
		
		assertEquals(20, img.objHeight());
	}

}
