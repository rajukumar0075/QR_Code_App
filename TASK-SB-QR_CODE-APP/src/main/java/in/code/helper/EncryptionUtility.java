package in.code.helper;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.stereotype.Component;

import in.code.entity.Student;

@Component
public class EncryptionUtility {

	public SecretKey generateKey(int n) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(n);
		SecretKey key = keyGenerator.generateKey();
		return key;
	}

	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	// Encrypt Serialized object
	public SealedObject doEncrypt(Student student) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, IOException, IllegalBlockSizeException {

		SecretKey key = generateKey(128);
		IvParameterSpec iv = generateIv();
		String algorithm = "AES/CBC/PKCS5Padding";
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		SealedObject sealedObject = new SealedObject(student, cipher);
		return sealedObject;
	}

}
