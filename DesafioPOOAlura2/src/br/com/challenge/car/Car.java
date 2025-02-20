package br.com.challenge.car;

public class Car {
    private String modelName;
    private double priceOfYear1;
    private double priceOfYear2;
    private double priceOfYear3;
    private int realeseYear;
    private String modelBrand;

    public String getModelName() {
        return modelName;
    }

    public double getPriceOfYear1() {
        return priceOfYear1;
    }

    public double getPriceOfYear2() {
        return priceOfYear2;
    }

    public double getPriceOfYear3() {
        return priceOfYear3;
    }

    public void setPrices(double price1, double price2, double price3){
        this.priceOfYear1 = price1;
        this.priceOfYear2 = price2;
        this.priceOfYear3 = price3;
    }

    public void defineModel(String model){
        this.modelName = model;
    }

    public int getRealeseYear() {
        return realeseYear;
    }

    public void setRealeseYear(int realeseYear) {
        this.realeseYear = realeseYear;
    }

    public String getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(String modelBrand) {
        this.modelBrand = modelBrand;
    }

    public void setPriceOfYear1(double priceOfYear1) {
        this.priceOfYear1 = priceOfYear1;
    }

    public void setPriceOfYear2(double priceOfYear2) {
        this.priceOfYear2 = priceOfYear2;
    }

    public void setPriceOfYear3(double priceOfYear3) {
        this.priceOfYear3 = priceOfYear3;
    }

    public double calculateSmallestPrice(){
        double smallestPrice = priceOfYear1;

        if (smallestPrice > priceOfYear2){
            smallestPrice = priceOfYear2;
        }

        if (smallestPrice > priceOfYear3) {
            smallestPrice = priceOfYear3;
        }

        return smallestPrice;
    }

    public double calculateHighestPrice(){
        double highestPrice = priceOfYear1;

        if (highestPrice < priceOfYear2){
            highestPrice = priceOfYear2;
        }

        if (highestPrice < priceOfYear3) {
            highestPrice = priceOfYear3;
        }

        return highestPrice;
    }

    public void showTecnicalSheet(){
        System.out.println("Modelo: " + modelName);
        System.out.println("Marca: " + modelBrand);
        System.out.println("Data de Lançamento: " + realeseYear);
        System.out.println("Preço do Primeiro ano: " + priceOfYear1);
        System.out.println("Preço do Segundo ano: " + priceOfYear2);
        System.out.println("Preço do Terceiro ano: " + priceOfYear3);
        System.out.println("Menor Preço: " + calculateSmallestPrice());
        System.out.println("Maior Preço: " + calculateHighestPrice());
    }
}
