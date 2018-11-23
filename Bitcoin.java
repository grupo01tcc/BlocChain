package blockchain;

import java.io.Serializable;


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
