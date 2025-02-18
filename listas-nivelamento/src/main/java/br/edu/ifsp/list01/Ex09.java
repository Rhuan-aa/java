package br.edu.ifsp.list01;

import java.util.Locale;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(int[] input) {
        String output = null;
        int sumOfAges = 0, numOfAdults = 0, numOfElderly = 0, numOfPeople = 0;

        for (int age : input){
            if (age < 0) break;

            numOfPeople++;
            sumOfAges += age;

            if (age >= 18) numOfAdults++;
            if (age > 75) numOfElderly++;
        }

        if (numOfPeople == 0) return "0.00 0 0.00%";

        double ageAverage = (double) sumOfAges / numOfPeople;
        double elderlyPercentage = ((double) numOfElderly * 100.0) / numOfPeople;

        output = String.format(Locale.US, "%.2f %d %.2f%%", ageAverage, numOfAdults, elderlyPercentage);

        return output;
    }
}
