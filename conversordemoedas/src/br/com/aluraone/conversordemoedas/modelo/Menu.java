package br.com.aluraone.conversordemoedas.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> listaDeParametros = new ArrayList<>();

    public int exibeMenu(){
        System.out.println("------------------------------------------\n");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda :)\n");
        System.out.println("1 - Dólar ==> Real Brasileiro");
        System.out.println("2 - Real Brasileiro ==> Dólar");
        System.out.println("3 - Euro ==> Real Brasileiro");
        System.out.println("4 - Real Brasilero ==> Euro");
        System.out.println("5 - Iene Japonês ==> Real Brasileiro");
        System.out.println("6 - Real Brasileiro ==> Iene Japonês");
        System.out.println("7 - Sair\n");
        System.out.println("Escolha uma opção válida: ");
        System.out.println("------------------------------------------\n");
        int opcao = scanner.nextInt();
        return opcao;
    }

    public double pegaValor(Scanner scanner) {
        System.out.println("Digite o valor que deseja converter: ");
        double valorDigitado = scanner.nextDouble();
        return valorDigitado;
    }
}
