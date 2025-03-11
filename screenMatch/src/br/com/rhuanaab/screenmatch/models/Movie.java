package br.com.rhuanaab.screenmatch.models;

import br.com.rhuanaab.screenmatch.calculations.Classifiable;

public class Movie extends Title implements Classifiable {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) ratingScore() / 2;
    }
}
