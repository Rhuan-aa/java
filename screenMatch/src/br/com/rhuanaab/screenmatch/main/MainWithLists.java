package br.com.rhuanaab.screenmatch.main;

import br.com.rhuanaab.screenmatch.models.Movie;
import br.com.rhuanaab.screenmatch.models.Series;
import br.com.rhuanaab.screenmatch.models.Title;

import java.util.ArrayList;

public class MainWithLists {
    public static void main(String[] args) {
        Movie myMovie = new Movie("O Poderoso Chefão", 1970);
        Series lost = new Series("Lost", 2000);
        Movie myOtherMovie = new Movie("Avatar", 2023);
        Movie movie2 = new Movie("Dogville",2003);

        ArrayList<Title> list = new ArrayList<>();
        list.add(myMovie);
        list.add(myOtherMovie);
        list.add(movie2);
        list.add(lost);

        for (Title title : list) {
            title.showTecnicalSheet();
        }
    }
}
