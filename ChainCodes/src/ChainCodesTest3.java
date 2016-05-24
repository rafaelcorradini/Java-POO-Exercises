import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe usada para testes. Utiliza-se do JUnit. O Eclemma acusa apenas 80%
 * @author Rafael Corradini da Cunha (9424322) <br> Guilherme Alves Campos (8522320)
 *
 */
public class ChainCodesTest3 {
	
	/**
	 * Checa o funcionamento do algoritmo ChainCodes através do método {@link ChainCodes#toString()}
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		String chainCode = img.toString();
		
		assertEquals(chainCode, "000000000000000000000000000000000000070000000700000070707077070700707077776700070700070070777007007077767070777776776767667676766666666666666667666666666666666666666666666666566666566665656666665666566566666665656656665656556566566666566656656566656565656555454555545555555545555555554544545454444545444544545444454445444445444444445454444444444444444444444444444434334343333233323222222222222222222222222222222222222222221212121122122212121212122122212233333434444444444444444444445555555555556565655666666656565565666566566666565656666665656656666666665666665656565554555545455454545454444445454444444544444454444444444444544444444444444444444444443434344343332323233323333323222322323222222222222223222222222222222222222222222222222222222222212222212222221212212222121211221212121122212111121110110100101000101001000000101000001010000100101001110100000011101000000100101122121112111222222222221212212112112111011010110110101001010010001000010000010010000001010000000000000010000101");
	}
	
	/**
	 * Checa o método {@link ChainCodes#numBorda()}
	 * @throws Exception
	 */
	@Test
	public void testNumBorda() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		int numBorda = img.numBorda();
		
		assertEquals(numBorda, 984);
		
	}
	/**
	 * Checa o método {@link ChainCodes#perimetro()}
	 * @throws Exception
	 */
	@Test
	public void testPerimetro() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		double perimetro = img.perimetro();
		double expected = 1107.435641587185;
		
		assertEquals((int)perimetro, (int)expected);
	}

	/**
	 * Checa o método {@link ChainCodes#pontoInicial()}
	 * @throws Exception
	 */
	@Test
	public void testPontoInicial() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		
		assertEquals (img.pontoInicial(),  "288x80");
	}

	/**
	 * Checa o método {@link ChainCodes#objWidth()}
	 * @throws Exception
	 */
	@Test
	public void testObjWidth() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		
		assertEquals(308, img.objWidth());
	}

	/**
	 * Checa o método {@link ChainCodes#objHeight()}
	 * @throws Exception
	 */
	@Test
	public void testObjHeight() throws Exception{
		ChainCodes img = new ChainCodes("src/aform.png");
		
		assertEquals(229, img.objHeight());
	}

}
