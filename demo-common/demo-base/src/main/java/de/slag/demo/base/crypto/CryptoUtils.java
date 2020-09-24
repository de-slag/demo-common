package de.slag.demo.base.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.function.Supplier;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import de.slag.demo.base.BaseException;

class CryptoUtils {

	private static final int ITERATION_COUNT = 65536;
	private static final int KEY_LENGTH = 256;
	private static final Supplier<IvParameterSpec> IV_PARAMETER_SPEC_SUPPLIER = () -> new IvParameterSpec(
			new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

	public static String decrypt(String strToDecrypt, String secret, String salt) {
		Cipher cipher;
		try {
			cipher = createInitializedCipher(secret, salt, Cipher.DECRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException e) {
			throw new BaseException(e);
		}

		byte[] doFinal = doFinal(strToDecrypt, cipher);

		return new String(doFinal);

	}

	private static byte[] doFinal(String strToDecrypt, Cipher cipher) {
		byte[] doFinal;
		try {
			doFinal = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new BaseException(e);
		}
		return doFinal;
	}

	public static String encrypt(String strToEncrypt, String secret, String salt) {
		Cipher cipher;
		try {
			cipher = createInitializedCipher(secret, salt, Cipher.ENCRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException e) {
			throw new BaseException(e);
		}

		byte[] doFinal;
		try {
			doFinal = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			throw new BaseException(e);
		}
		return Base64.getEncoder().encodeToString(doFinal);

	}

	private static Cipher createInitializedCipher(String secret, String salt, int decryptMode)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException {

		final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		final KeySpec keySpec = new PBEKeySpec(secret.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
		final SecretKey secretKey = factory.generateSecret(keySpec);
		final SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

		final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(decryptMode, secretKeySpec, IV_PARAMETER_SPEC_SUPPLIER.get());
		return cipher;
	}

}
