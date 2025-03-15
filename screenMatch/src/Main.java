import br.com.rhuanaab.screenmatch.calculations.RecommendationFilter;
import br.com.rhuanaab.screenmatch.calculations.TimeCalculator;
import br.com.rhuanaab.screenmatch.models.Episode;
import br.com.rhuanaab.screenmatch.models.Movie;
import br.com.rhuanaab.screenmatch.models.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("O Poderoso Chefão");
        myMovie.setReleaseDate(1970);
        myMovie.setDurationInMinutes(180);
        myMovie.showTecnicalSheet();
        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);
        System.out.println(myMovie.ratingScore());

        Series lost = new Series();
        lost.setName("Lost");
        lost.setReleaseDate(2000);
        lost.showTecnicalSheet();
        lost.setSeasons(10);
        lost.setEpisodesPerSeason(10);
        lost.setMinutesPerEpisode(50);
        System.out.println("Duração de Lost: " + lost.getDurationInMinutes());

        Movie myOtherMovie = new Movie();
        myOtherMovie.setName("Avatar");
        myOtherMovie.setReleaseDate(2023);
        myOtherMovie.setDurationInMinutes(200);

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(myMovie);
        calculator.include(myOtherMovie);
        calculator.include(lost);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSeries(String.valueOf(lost));
        episode.setTotalViews(300);
        filter.filter(lost);

        Movie movie2 = new Movie();
        movie2.setName("Dogville");
        movie2.setDurationInMinutes(200);
        movie2.setReleaseDate(2003);
        movie2.rate(10);

        ArrayList<Movie> movieArray = new ArrayList<>();
        movieArray.add(movie2);
        movieArray.add(myMovie);
        movieArray.add(myOtherMovie);
        System.out.println("Tamanho da Lista: " + movieArray.size());
        System.out.println("First Movie: " + movieArray.get(0).getName());
        System.out.println(movieArray.get(0).toString());
        System.out.println(movieArray.toString());
    }
}



