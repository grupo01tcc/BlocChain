/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import blockchain.hash.TipoHash;
import java.io.Serializable;

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
       
    public String hash(String input) {

        TipoHash tipoHash = TipoHash.values()[1];
        
        return tipoHash.calculaHash(input).toString();

    }
}
