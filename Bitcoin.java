/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlockChain;

import BlockChain.Block;
import BlockChain.BlockChain;
import java.io.Serializable;

/**
 *
 * @author mayso
 */
public class Bitcoin implements Serializable{
    private String emissor;
    private String receptor;
    private float valor;
    

    public Bitcoin()  {
    }

     public void listar(BlockChain <Bitcoin> blockchain){
       Block<Bitcoin> blocolistar = blockchain.getBlock();
     
       while(blocolistar != null){
           System.out.println(blocolistar.getElemento().getEmissor()+"->"+blocolistar.getElemento().getValor()+"->"+blocolistar.getElemento().getReceptor()+"|"+blocolistar.getHash()+"\n");
           blocolistar = blocolistar.getProximo();
       }
     
   }
    
    public int hashCode(){        
        return (int) (emissor.hashCode()+receptor.hashCode()+valor);
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
