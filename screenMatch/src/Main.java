import br.com.rhuanaab.screenmatch.calculations.TimeCalculator;
import br.com.rhuanaab.screenmatch.models.Movie;
import br.com.rhuanaab.screenmatch.models.Series;

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
    }
}



