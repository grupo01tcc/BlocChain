/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author mayso
 */
public class BlockChain {

    private Bloco block;

    public void criaCadeia() {
        block = null;
    }

    public void printCadeia() {

        for (Bloco n = block; n != null; n = n.getProx()) {
            System.out.println(n.getHash() + "|" + n.getEmissor() + "->" + n.getValor() + "->" + n.getReceptor());
        }
    }

    public static String hash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {

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

    public void addBloco(int i, String e, String r) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        /*cria novo elemento*/
        Bloco novo = new Bloco();
        novo.setValor(i);
        novo.setEmissor(e);
        novo.setReceptor(r);

        /*objeto para percorrer a lista*/
        Bloco p = block;

        //se lista vazia inclui no inicio
        if (block == null) {
            novo.setHash(hash(e + i + r));
            novo.setHashant(null);
            novo.setProx(null);
            block = novo;
        } else {
            // se lista nao vazia, percorre a lista ate o final
            while (p.getProx() != null) {
                p = p.getProx();
            }

            //insere bloco
            novo.setHash(hash(p.getHash() + hash(e + i + r)));
            novo.setHashant(p.getHash());
            novo.setProx(null);
            p.setProx(novo);
        }
    }

    public boolean validarBloco(int b) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int c = 1;
        Bloco p = block;
        String hashBloco = null;
        if (p == null) {
            return false;
        } else {
            while (p.getProx() != null) {
                if (p.getHashant() == null) {
                    hashBloco = hash(p.getEmissor() + p.getValor() + p.getReceptor());
                } else {
                    hashBloco = p.getHashant() + hash(p.getEmissor() + p.getValor() + p.getReceptor());
                    hashBloco = hash(hashBloco);
                }
                //System.out.println(hashBloco + "|" + p.getHash());
                if (hashBloco.equals(p.getHash())) {
                    if (c == b) {
                        return true;
                    }
                } else {
                    return false;
                }
                p = p.getProx();
                c++;
            }
            
            if (b == 1) {
                hashBloco = hash(p.getEmissor() + p.getValor() + p.getReceptor());
            } else if (b == c) {
                hashBloco = p.getHashant() + hash(p.getEmissor() + p.getValor() + p.getReceptor());
                hashBloco = hash(hashBloco);
            }
            else return false;

            if (hashBloco.equals(p.getHash())) {
                return true;
            } else {
                return false;
            }
        }
    }

   
    void alterar(int b, int i) {
        int c;
        Bloco p = block;
        for (c = 1; c < b; c++) {
            p = p.getProx();
        }
        p.setValor(i);

    }
}
