package br.com.challenge.primeNumbers;

public class PrimeChecker extends PrimeNumbers{
    public void isPrimeNumber(int number){
        if (checkPrimaryness(number)) System.out.println("É primo");
        else System.out.println("Não é primo");
    }
}
