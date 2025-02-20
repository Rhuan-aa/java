package br.com.challenge.animal;

public class Cat extends Animal{

    public void scratchTheFurniture(){
        System.out.println("*arranhando o sofá*");
    }

    public void catBath(){
        System.out.println("*se lambendo*");
    }

    @Override
    public void makeSound() {
        System.out.println("Meooooow!");;
    }
}
