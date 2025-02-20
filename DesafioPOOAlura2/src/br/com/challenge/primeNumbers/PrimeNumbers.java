package br.com.challenge.primeNumbers;

public class PrimeNumbers {
    public boolean checkPrimaryness(int number) {
        if (number <= 1) return false;

        for (int i = 0; i < number; i++) {
            if (number%i == 0) return false;
        }

        return true;
    }

    public void listPrimes(int limit){
        System.out.println("Numeros primos até " + limit);

        for (int i = 0; i < limit; i++) {
            if (checkPrimaryness(i)) System.out.println(i + " ");
        }
        System.out.printf("\n");
    }

}
