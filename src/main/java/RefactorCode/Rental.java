package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-23 23:35:03
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calcMovieAmount() {

        return movie.getAmount(daysRented);
    }

    public int getFrequentRenterPoints() {

        return movie.calcFrequentPoints(daysRented);

    }

}
