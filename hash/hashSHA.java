/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author PJC
 */
public class hashSHA implements Strategy {

    public String calculaHash(String input) {

        StringBuffer hexString = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);

            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("blockchain.hash.hashSHA.calculaHash()" + ex);

        } catch (UnsupportedEncodingException ex) {
            System.out.println("blockchain.hash.hashSHA.calculaHash()" + ex);

        }
        return hexString.toString();

    }
}
