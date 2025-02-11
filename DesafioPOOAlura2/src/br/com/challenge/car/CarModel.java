package br.com.challenge.car;

public class CarModel extends Car{
    public void CarModel(String name, double price1, double price2, double price3, int releaseYear, String modelBrand){
        defineModel(name);
        setRealeseYear(releaseYear);
        setModelBrand(modelBrand);
        showTecnicalSheet();
    }
}
