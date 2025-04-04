package br.edu.ifsp.list01;

import java.util.Locale;

/*
    Sabe-se que uma lata de tinta tem um custo C e é capaz de pintar uma área de M metros quadrados.
    Faça um programa que leia a largura L, a altura A de uma parede, o valor C de uma lata de tinta e
    o rendimento M desta lata. Após isso, imprima quantas latas de tintas são necessárias e o custo
    total (com duas casas decimais). Assuma que não é possível comprar lata de tinta fracionada.

    Exemplos de entrada e saída:
    Entrada   	Saída
    4           4 20.00
    3
    5
    3

    Entrada	    Saída
    10.0        3 15.00
    2.0
    5.0
    7
*/
public class Ex06 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(double L, double a, double c, double m) {
        String output = null;
        double area = L*a, cost = 0;
        int cans = 0;

        if (area > 0) {
            cans = (int) Math.ceil(area/m);
            cost = c * cans;
        }

        output =  String.format(Locale.US, "%d %.2f", cans, cost);
        return output;
    }
}
