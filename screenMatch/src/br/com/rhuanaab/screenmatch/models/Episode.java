package br.com.rhuanaab.screenmatch.models;

import br.com.rhuanaab.screenmatch.calculations.Classifiable;

public class Episode implements Classifiable {
    private int number;
    private String name;
    private String Series;
    private int totalViews;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    @Override
    public int getClassification() {
        if (totalViews > 100) return 4;
        return 2;
    }
}
