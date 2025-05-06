import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zoo {
    List<Animal> jails = new ArrayList<>();

    public void allocateAnimal(Animal animal) {
        Objects.requireNonNull(animal, "Animal cannot be null");
        jails.add(animal);
    }

    public void hitJails() {
        jails.forEach(Animal::makeSound);
        jails.stream()
                .filter(animal -> animal instanceof LandAnimal)
                .map(animal -> (LandAnimal) animal)
                .forEach(LandAnimal::run);
    }
}
