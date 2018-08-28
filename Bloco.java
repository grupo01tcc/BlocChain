/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

/**
 *
 * @author mayso
 */
public class Bloco {

    private String hash;
    private String hashant;
    private Bloco prox;

    // Dados do Bloco
    private int valor;
    private String emissor;
    private String receptor;

    
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

    public Bloco getProx() {
        return prox;
    }

    public void setProx(Bloco prox) {
        this.prox = prox;
    }

    
    // Get e Set dos Dados do Bloco    
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

}
