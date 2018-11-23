/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayso
 */
public class Main {

    private static int menu() {
        int opcao = -1;
        Scanner ler = new Scanner(System.in);
        System.out.println("Forneca uma opcao entre 1 e 5: \n");
        System.out.println("\t[1] - Adicionar Bloco");
        System.out.println("\t[2] - Validar Bloco");
        System.out.println("\t[3] - Alterar Bloco");
        System.out.println("\t[4] - Exibir BlockChain");
        System.out.println("\t[5] - Sair");
        System.out.println("->");

        do {
            opcao = ler.nextInt();
            if (opcao < 1 || opcao > 5) {
                System.out.println("Valor fora do intervalo previsto\n");
                System.out.println("Forneca uma opcao entre 1 e 5: \n");
                System.out.println("\t[1] - Adicionar Bloco");
                System.out.println("\t[2] - Validar Bloco");
                System.out.println("\t[3] - Alterar Bloco");
                System.out.println("\t[4] - Exibir BlockChain");
                System.out.println("\t[5] - Sair");
                System.out.println("->");
            }
        } while (opcao < 1 || opcao > 5);
        return opcao;
    }

    public final static void clearConsole() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");

            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Tratar Exceptions
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner ler = new Scanner(System.in);
        int op, b;
        float valor;
        String emissor, receptor;

        BlockChain<Bitcoin> blockchain = new BlockChain<Bitcoin>();
        Bitcoin bitcoin = new Bitcoin();

        blockchain.resgatarBlockChain();

        do {
            op = menu();
            switch (op) {
                case 1:
                    System.out.println("Informe o Valor");
                    valor = ler.nextFloat();
                    System.out.println("Informe o Emissor");
                    emissor = ler.next();
                    System.out.println("Informe o Receptor");
                    receptor = ler.next();

                    bitcoin = new Bitcoin();
                    bitcoin.setEmissor(emissor);
                    bitcoin.setReceptor(receptor);
                    bitcoin.setValor(valor);
                    blockchain.addBlock(bitcoin);
                    blockchain.salvarBlockChain();
                    break;

                case 2:
                    System.out.println("Informe o indice do Bloco");
                    b = ler.nextInt();
                    System.out.println("======================================");
                    if (blockchain.validarBloco(b)) {
                        System.out.println("Bloco Valido");
                    } else {
                        System.out.println("Bloco Invalido");
                    }
                    System.out.println("======================================");
                    break;

                case 3:
                    System.out.println("Informe o indice do bloco a ser alterado");
                    b = ler.nextInt();
                    System.out.println("Informe o Valor");
                    valor = ler.nextInt();
                    blockchain.alterar(blockchain, b, valor);                    
                    break;

                case 4:
                    bitcoin.listar(blockchain);
                    break;

            }
        } while (op != 5);
    }

}
