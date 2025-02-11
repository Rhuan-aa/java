package br.com.rhuanaab.screenmatch.calculations;

import br.com.rhuanaab.screenmatch.models.Movie;
import br.com.rhuanaab.screenmatch.models.Series;
import br.com.rhuanaab.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

//    public void include(Movie movie){
//        this.totalTime += movie.getDurationInMinutes();
//    }
//
//    public void include(Series series){
//        this.totalTime += series.getDurationInMinutes();
//    }

    public void include(Title title){
        this.totalTime += title.getDurationInMinutes();
    }
}
