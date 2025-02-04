import br.com.rhuanaab.screenmatch.models.Movie;

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
    }
}
