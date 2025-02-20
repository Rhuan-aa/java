package br.com.challenge.animal;

public class Dog extends Animal{

    public void wagTail(){
        System.out.println("*abanando rabo*");
    }

    public void growl(){
        System.out.println("*rosnando*");
    }

    @Override
    public void makeSound() {
        System.out.println("AU AU AU!");
    }
}
