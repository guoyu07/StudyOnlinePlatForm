package indi.jack.util;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCrypt;
/**
 * @author j
 *
 */
public class TransformToHashPassword {
	private static final SecureRandom RANDOM;
	private static final int HASHING_ROUNDS = 10;
	static {
		try {
			RANDOM = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static byte[] formToHash(String password){
		byte[] bytes=null;
		if (password != null && password.length() > 0) {
			String salt = BCrypt.gensalt(HASHING_ROUNDS, RANDOM);
			 bytes=BCrypt.hashpw(password, salt).getBytes();
		}
		return bytes;
	}
}
