import br.com.challenge.animal.Cat;
import br.com.challenge.animal.Dog;
import br.com.challenge.car.CarModel;

public class Main {
    public static void main(String[] args) {
        //EX 01
        CarModel HB20 = new CarModel();
        HB20.defineModel("HB20S");
        HB20.setModelBrand("Hyundai");
        HB20.setRealeseYear(2013);
        HB20.setPriceOfYear1(59592);
        HB20.setPriceOfYear2(82462);
        HB20.setPriceOfYear3(107980);

        HB20.showTecnicalSheet();

        //EX 02
        Cat brute = new Cat();
        brute.makeSound();
        brute.catBath();
        brute.scratchTheFurniture();

        Dog doguinha = new Dog();
        doguinha.growl();
        doguinha.wagTail();
        doguinha.makeSound();

    }
}