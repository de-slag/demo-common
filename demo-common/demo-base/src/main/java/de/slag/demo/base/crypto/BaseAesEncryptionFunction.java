package de.slag.demo.base.crypto;

import java.util.function.Function;

public class BaseAesEncryptionFunction implements Function<String, String> {

	private String cipherKey;

	private String salt;

	public BaseAesEncryptionFunction(String cipherKey) {
		this(cipherKey, "aaaa");
	}

	public BaseAesEncryptionFunction(String cipherKey, String salt) {
		super();
		this.cipherKey = cipherKey;
		this.salt = salt;
	}

	@Override
	public String apply(String stringToEncrypt) {
		return CryptoUtils.encrypt(stringToEncrypt, cipherKey, salt);
	}

}
