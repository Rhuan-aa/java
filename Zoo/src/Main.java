public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        zoo.allocateAnimal(new Lion());
        zoo.allocateAnimal(new Lion());
        zoo.allocateAnimal(new Wolf());
        zoo.allocateAnimal(new Owl());
        zoo.allocateAnimal(new Owl());
        zoo.allocateAnimal(new Lion());
        zoo.allocateAnimal(new Wolf());
        zoo.allocateAnimal(new Wolf());
        zoo.allocateAnimal(new Lion());
        zoo.allocateAnimal(new Owl());
        zoo.allocateAnimal(new Lion());

        zoo.hitJails();
    }
}