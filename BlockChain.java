/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author mayso
 */
public class BlockChain {

    private Block block;

    public void criaCadeia() {
        block = null;
    }

    public void printCadeia() {

        for (Block n = block; n != null; n = n.getProx()) {
            System.out.println(n.getHash() + "|" + n.getEmissor() + "->" + n.getValor() + "->" + n.getReceptor());
        }
    }
   
    public void addBloco(int i, String e, String r) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        /*cria novo elemento*/
        Block novo = new Block();
        novo.setValor(i);
        novo.setEmissor(e);
        novo.setReceptor(r);

        /*objeto para percorrer a lista*/
        Block p = block;

        //se lista vazia inclui no inicio
        if (block == null) {
            novo.setHash(novo.hash(e + i + r));
            novo.setHashant(null);
            novo.setProx(null);
            block = novo;
        } else {
            // se lista nao vazia, percorre a lista ate o final
            while (p.getProx() != null) {
                p = p.getProx();
            }

            //insere bloco
            novo.setHash(novo.hash(p.getHash() + novo.hash(e + i + r)));
            novo.setHashant(p.getHash());
            novo.setProx(null);
            p.setProx(novo);
        }
    }

    public boolean validarBloco(int b) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int c = 1;
        Block p = block;
        String hashBloco = null;
        if (p == null) {
            return false;
        } else {
            while (p.getProx() != null) {
                if (p.getHashant() == null) {
                    hashBloco = p.hash(p.getEmissor() + p.getValor() + p.getReceptor());
                } else {
                    hashBloco = p.getHashant() + p.hash(p.getEmissor() + p.getValor() + p.getReceptor());
                    hashBloco = p.hash(hashBloco);
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
                hashBloco = p.hash(p.getEmissor() + p.getValor() + p.getReceptor());
            } else if (b == c) {
                hashBloco = p.getHashant() + p.hash(p.getEmissor() + p.getValor() + p.getReceptor());
                hashBloco = p.hash(hashBloco);
            }
            else return false;

            if (hashBloco.equals(p.getHash())) {
                return true;
            } else {
                return false;
            }
        }
    }

   
    public void alterar(int b, int i) {
        int c;
        Block p = block;
        for (c = 1; c < b; c++) {
            p = p.getProx();
        }
        p.setValor(i);

    }
}
