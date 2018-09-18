/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlockChain;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author mayso
 */
public class Block<T> implements Serializable{

    private T elemento;
    private Block<T> proximo;
    private String hash;
    private String hashant;

    public Block(T e) {
        this.elemento = e;
    }

    public Block(T e, Block<T> b) {
        this.elemento = e;
        this.proximo = b;
    }
    
    public int hashCode(){
        return elemento.hashCode();
    }

    public T getElemento() {
        return elemento;
    }

    public Block<T> getProximo() {
        return proximo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setProximo(Block<T> proximo) {
        this.proximo = proximo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHashant() {
        return hashant;
    }

    public void setHashant(String hashant) {
        this.hashant = hashant;
    }
       
    public String hash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();

    }
}
