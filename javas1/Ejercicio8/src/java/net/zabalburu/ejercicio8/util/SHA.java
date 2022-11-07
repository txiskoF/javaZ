/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio8.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


/**
 *
 * @author ichueca
 */
public class SHA {
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        String passwordToHash = "marta";
        String salt = getSalt();
        System.out.println("Salto: " + salt);
        String securePassword = get_SHA_256_SecurePassword(passwordToHash, Base64.getDecoder().decode(salt));
        System.out.println("Hash: " + securePassword);
    }
 
    public static String getHash(String password, String salto){
        return get_SHA_256_SecurePassword(password, Base64.getDecoder().decode(salto));
    }
    
    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    
     
    //Add salt
    public static String getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
