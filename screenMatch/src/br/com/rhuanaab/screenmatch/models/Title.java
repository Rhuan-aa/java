package br.com.rhuanaab.screenmatch.models;

public class Title {
    private String name;
    private int releaseDate;
    private boolean InThePlan;
    private double totalRating;
    private int numberOfReviews;
    private int durationInMinutes;

    public Title(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public void showTecnicalSheet(){
        System.out.println("Nome do Filme: " + name);
        System.out.println("Ano de Lançamento: " + releaseDate);
    }

    public void rate(double newRate){
        totalRating += newRate;
        numberOfReviews++;
    }

    public int getNumberOfReviews(){
        return numberOfReviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setInThePlan(boolean inThePlan) {
        this.InThePlan = inThePlan;
    }

    public boolean isInThePlan() {
        return InThePlan;
    }

    public double ratingScore(){
        return totalRating / numberOfReviews;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
