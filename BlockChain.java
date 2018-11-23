/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayso
 */
public class BlockChain<T> implements Serializable{

    private Block<T> bloco; 
       
    public void resgatarBlockChain(){
       
          if (new File("BlockChain").canRead() == true) {

              try {
                  FileInputStream in = null;
                  in = new FileInputStream("BlockChain");
                  ObjectInputStream objIn = new ObjectInputStream(in);                
                  this.bloco =  (Block<T>) objIn.readObject();
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
    }

    public void salvarBlockChain(){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("BlockChain");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(bloco);
            objOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addBlock(T elemento) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Block<T> novo = new Block<T>(elemento);

        /*objeto para percorrer a lista*/
        Block<T> p = bloco;

        if (bloco == null) {
            novo.setProximo(this.bloco);
            this.bloco = novo;
            this.bloco.setHash(novo.hash(Integer.toString(bloco.getElemento().hashCode())));
            this.bloco.setHashant(null);
        }else {
             while (p.getProximo() != null) {
                p = p.getProximo();
            }
             //insere bloco
             novo.setProximo(null);
             p.setProximo(novo);
             novo.setHash(novo.hash(p.getHash() +Integer.toString(novo.getElemento().hashCode())));
             novo.setHashant(p.getHash());
        }
    }    

    public Block <T> getBlock(){
        return bloco;
    }
    
    
    public boolean validarBloco(int indice) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int c = 1;
        Block<T> p = bloco;
        String hashBloco = null;
        if (p == null) {
            return false;
        } else {
            while (p.getProximo() != null) {
                if (p.getHashant() == null) {
                    hashBloco = p.hash(Integer.toString(p.getElemento().hashCode()));
                } else {
                    hashBloco =  p.hash(p.getHashant() +Integer.toString(p.getElemento().hashCode()));                    
                }                
                if (hashBloco.equals(p.getHash())) {
                    if (c == indice) {
                        return true;
                    }
                } else {
                    return false;
                }
                p = p.getProximo();
                c++;
            }
            
                        
            if (indice == 1) {
                hashBloco = p.hash(Integer.toString(p.getElemento().hashCode()));
            } else if (indice == c) {
                hashBloco =  p.hash(p.getHashant() +Integer.toString(p.getElemento().hashCode()));                
            }
            else return false;
            
            //System.out.println(hashBloco + "|" + p.getHash());

            if (hashBloco.equals(p.getHash())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
     public void alterar(BlockChain <Bitcoin> block, int b, float i) {
        int c;
        Block<Bitcoin> alterar = block.getBlock();
        for (c = 1; c < b; c++) {
             alterar = alterar.getProximo();
        }
        alterar.getElemento().setValor(i);

    }
    
}
