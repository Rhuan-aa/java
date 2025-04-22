public class Main {
    public static void main(String[] args) {
        Animal[] jails = new Animal[10];
        int index = 0;

        jails[index++] = new Lion();
        jails[index++] = new Owl();
        jails[index++] = new Lion();
        jails[index++] = new Wolf();
        jails[index++] = new Lion();
        jails[index++] = new Wolf();
        jails[index++] = new Owl();
        jails[index++] = new Owl();
        jails[index++] = new Owl();
        jails[index++] = new Wolf();

        for (Animal animal : jails){
            animal.makeSound();

            if (animal instanceof Lion lion) {
                lion.run();
            } else if (animal instanceof Wolf wolf) {
                wolf.run();
            }
        }
    }
}