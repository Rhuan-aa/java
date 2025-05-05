public class Zoo {
    Animal[] jails = new Animal[10];
    int index = 0;

    public void allocateAnimal(Animal animal) {
        if (index < 10) {
            jails[index++] = animal;
            return;
        }

        System.out.println("Jaulas cheias !!!");
    }

    public void hitJails() {
        for (Animal animal : jails){
            animal.makeSound();

            if (animal instanceof LandAnimal landAnimal) {
                landAnimal.run();
            }
        }
    }
}
