public class Wolf extends Animal implements LandAnimal{
    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }

    @Override
    public void run(){
        System.out.println("Wolf is running");
    }
}
