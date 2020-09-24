package de.slag.demo.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.slag.demo.base.crypto.BaseAesDecryptionFunction;
import de.slag.demo.base.crypto.BaseAesEncryptionFunction;

class BaseAesCryptoIntegrationTest {

	private static final String ENCRYPTED_TEXT = "G+NHfr9wgS1WN7shS0JDTF3keibTEMuwl2a6YK22zHAcw4VrGxEE5fY8pDZY2SSMLFTFgTzbbm3u1XuOdFc0JA==";
	private static final String CLEAR_TEXT = "This is a Test that has to be encrypted and decrypted.";
	private static final String CIPHER_KEY = "Euya6iegujopheibaec2ooYal6queiLiu4ie3vuNg2ruot7aut1eipiewesiu7jo";

	@Test
	void test() {
		BaseAesEncryptionFunction baseAesEncryptionFunction = new BaseAesEncryptionFunction(CIPHER_KEY);
		String encryptedText = baseAesEncryptionFunction.apply(CLEAR_TEXT);

		assertEquals(ENCRYPTED_TEXT, encryptedText);

		BaseAesDecryptionFunction baseAesDecryptionFunction = new BaseAesDecryptionFunction(CIPHER_KEY);
		String decryptedText = baseAesDecryptionFunction.apply(encryptedText);

		assertEquals(CLEAR_TEXT, decryptedText);
	}

	@Test
	void testCreateEncryptionFunction() {
		new BaseAesEncryptionFunction(CIPHER_KEY);
	}

	@Test
	void testCreateDecryptionFunction() {
		new BaseAesDecryptionFunction(CIPHER_KEY);
	}

}
