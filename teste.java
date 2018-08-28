/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author mayso
 */
public class teste {

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
                System.out.println("Valor fora do intervalo previsto");
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

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int op, valor, b;
        Scanner ler = new Scanner(System.in);
        String emissor, receptor;
        BlockChain Cadeia = new BlockChain();
        Cadeia.criaCadeia();

        do {            
            op = menu();
            switch (op) {
                case 1:
                    System.out.println("Informe o Valor");
                    valor = ler.nextInt();
                    System.out.println("Informe o Emissor");
                    emissor = ler.next();
                    System.out.println("Informe o Receptor");
                    receptor = ler.next();
                    Cadeia.addBloco(valor, emissor, receptor);
                    break;

                case 2:
                    System.out.println("Informe o Bloco");
                    b = ler.nextInt();
                    System.out.println("======================================");
                    if (Cadeia.validarBloco(b)) {
                        System.out.println("Bloco Valido");
                    } else {
                        System.out.println("Bloco Invalido");
                    }
                    System.out.println("======================================");
                    break;

                case 3:
                    System.out.println("Informe o Bloco a ser alterado");
                    b = ler.nextInt();
                    System.out.println("Informe o Valor");
                    valor = ler.nextInt();
                    Cadeia.alterar(b, valor);
                    break;

                case 4:
                    Cadeia.printCadeia();
                    break;

            }
        } while (op != 5);
    }
}
