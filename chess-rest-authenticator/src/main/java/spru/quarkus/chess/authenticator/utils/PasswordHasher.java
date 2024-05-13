package spru.quarkus.chess.authenticator.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * author sprugit
 */
public class PasswordHasher {
	
	/**
	 * Hashes a given string with given salt
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	private static String hash(String password, byte[] salt) {
		String ret = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			ret = Base64.getEncoder().encodeToString(md.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			//this should never happen
		} 
		return ret;
	}
	
	/**
	 * Hashes a password
	 * Use case: when creating a new user
	 * 
	 * @param password
	 * @return
	 */
	public static String[] hash(String password) {
		String stored_salt = null;
		byte[] salt = new byte[16];
		
		new SecureRandom().nextBytes(salt);
		
		stored_salt = Base64.getEncoder().encodeToString(salt);
		return new String[]{hash(password,salt),
				stored_salt};
	} 
	
	/**
	 * Hashes a new password using an already existing salt (from the database)
	 * Use case: user changing password
	 * 
	 * @param password
	 * @param stored_salt
	 * @return
	 */
	public static String rehash(String password, String stored_salt) {
		byte[] salt = Base64.getDecoder().decode(stored_salt);
		return hash(password,salt);
	}
	
	/**
	 * Authenticates a user
	 * 
	 * @param password
	 * @param stored_salt
	 * @param stored_password
	 * @return
	 */
	public static boolean authenticate(String password, String stored_salt, String stored_password) {
		return stored_password.contentEquals(rehash(stored_password, stored_salt));
	}
}