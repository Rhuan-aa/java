package br.com.rhuanaab.screenmatch.models;

import br.com.rhuanaab.screenmatch.calculations.Classifiable;

public class Movie extends Title implements Classifiable {
    private String director;

    public Movie(String name, int releaseDate) {
        super(name, releaseDate);
    }

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

    @Override
    public String toString() {
        return "Movie: " + this.getName() + " (" + this.getReleaseDate() + ") ";
    }
}
