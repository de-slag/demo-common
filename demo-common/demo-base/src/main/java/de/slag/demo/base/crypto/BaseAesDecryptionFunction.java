package de.slag.demo.base.crypto;

import java.util.function.Function;

public class BaseAesDecryptionFunction implements Function<String, String> {

	private String cipherKey;

	private String salt;

	public BaseAesDecryptionFunction(String cipherKey) {
		this(cipherKey, "aaaa");
	}
	
	public BaseAesDecryptionFunction(String cipherKey, String salt) {
		super();
		this.cipherKey = cipherKey;
		this.salt = salt;
	}

	@Override
	public String apply(String stringToDecrypt) {
		return CryptoUtils.decrypt(stringToDecrypt, cipherKey, salt);
	}

}
