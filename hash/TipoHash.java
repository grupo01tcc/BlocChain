/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain.hash;

public enum TipoHash {
    SHA5 {
        @Override
        public Strategy calculaHash(String input) {
            return new hashSHA();
        }
    },
    MD5 {
        @Override
        public Strategy calculaHash(String input) {
            return new hashMD5();
        }
    };
    
    public abstract Strategy calculaHash(String input);
    
}
