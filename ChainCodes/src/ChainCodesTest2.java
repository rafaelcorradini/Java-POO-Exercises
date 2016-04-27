import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe usada para testes. Utiliza-se do JUnit. O Eclemma acusa apenas 80%
 * @author Rafael Corradini da Cunha (9424322) <br> Guilherme Alves Campos (8522320)
 *
 */
public class ChainCodesTest2 {
	
	/**
	 * Checa o funcionamento do algoritmo ChainCodes através do método {@link ChainCodes#toString()}
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		String chainCode = img.toString();
		
		assertEquals(chainCode, "00000000000000000000000000000007000000000000700000000070000070000070000700070007000700700700707007707070777770767667666656655555554554545454544544545444544454445444544445444445444444544444444454444444444444444454444444444444444434444444444444444434444444443444443444443444443444344434443443443443434434343343433333323223221221211111101101010101001010010010001000100010000100000100000100000000010000000000001");
	}
	
	/**
	 * Checa o método {@link ChainCodes#numBorda()}
	 * @throws Exception
	 */
	@Test
	public void testNumBorda() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		int numBorda = img.numBorda();
		
		assertEquals(numBorda, 407);
		
	}
	/**
	 * Checa o método {@link ChainCodes#perimetro()}
	 * @throws Exception
	 */
	@Test
	public void testPerimetro() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		double perimetro = img.perimetro();
		double expected = 449.6639969244296;
		
		assertEquals((int)perimetro, (int)expected);
	}

	/**
	 * Checa o método {@link ChainCodes#pontoInicial()}
	 * @throws Exception
	 */
	@Test
	public void testPontoInicial() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		
		assertEquals (img.pontoInicial(),  "139x51");
	}

	/**
	 * Checa o método {@link ChainCodes#objWidth()}
	 * @throws Exception
	 */
	@Test
	public void testObjWidth() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		
		assertEquals(196, img.objWidth());
	}

	/**
	 * Checa o método {@link ChainCodes#objHeight()}
	 * @throws Exception
	 */
	@Test
	public void testObjHeight() throws Exception{
		ChainCodes img = new ChainCodes("src/oval.png");
		
		assertEquals(61, img.objHeight());
	}

}
