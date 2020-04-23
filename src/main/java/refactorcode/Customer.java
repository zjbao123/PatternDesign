package refactorcode;

import java.util.ArrayList;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 21:05:21
 */
public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }


    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.calcMovieAmount() + "\n";
        }


        //打印汇总
        result += "Amount owed is " + calcTotalAmount() + "\n";
        result += "You earned " + calcFrequentRenterPoint() + " frequent renter points";
        return result;
    }

    private double calcTotalAmount() {
        return rentals.stream().map(Rental::calcMovieAmount).reduce(0.0, Double::sum);
    }
    private int calcFrequentRenterPoint() {
        return rentals.stream().map(Rental::getFrequentRenterPoints).reduce(0, Integer::sum);
    }

}

