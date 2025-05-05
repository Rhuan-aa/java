public class Lion extends Animal implements LandAnimal{
    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }

    @Override
    public void run(){
        System.out.println("Lion is running!");
    }
}
