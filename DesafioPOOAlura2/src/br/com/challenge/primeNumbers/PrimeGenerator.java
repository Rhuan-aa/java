package br.com.challenge.primeNumbers;

public class PrimeGenerator extends PrimeNumbers{
    public int generateNextPrime(int lastPrimeNumber){
        int nextPrime = lastPrimeNumber+1;

        while (!checkPrimaryness(nextPrime)){
            nextPrime++;
        }

        return nextPrime;
    }
}
