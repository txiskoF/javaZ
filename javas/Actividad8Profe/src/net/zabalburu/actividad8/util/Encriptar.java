package net.zabalburu.actividad8.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Encriptar {

	public Encriptar() {
		// TODO Auto-generated constructor stub
	}

	private static final SecureRandom RAND = new SecureRandom();

	  public static String getSalto (final int length) {

	    if (length < 1) {
	      System.err.println("error in generateSalt: length must be > 0");
	      return Optional.empty().toString();
	    }

	    byte[] salt = new byte[length];
	    RAND.nextBytes(salt);

	    return Optional.of(Base64.getEncoder().encodeToString(salt)).get();
	  }
	
	  
	  private static final int ITERATIONS = 65536;
	  private static final int KEY_LENGTH = 512;
	  private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

	  public static String getHash (String password, String salt) {

	    char[] chars = password.toCharArray();
	    byte[] bytes = salt.getBytes();

	    PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

	    Arrays.fill(chars, Character.MIN_VALUE);

	    try {
	      SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
	      byte[] securePassword = fac.generateSecret(spec).getEncoded();
	      return Optional.of(Base64.getEncoder().encodeToString(securePassword)).get();

	    } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
	      System.err.println("Exception encountered in hashPassword()");
	      return Optional.empty().toString();

	    } finally {
	      spec.clearPassword();
	    }
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(getHash("12345",getSalto(10)));
		  System.out.println(getHash("12345",getSalto(10)));
	  }
	  
}
