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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double thisAmount = 0;
            //计算各类积分情况
            thisAmount = rental.calcMovieAmount();

            //获取积分情况
            frequentRenterPoints++;
            //如果是新片并且租借一天以上加一分
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" +rental.getMovie().getTitle()+"\t"+ String.valueOf(thisAmount) +"\n";
            totalAmount += thisAmount;

        }

        //打印汇总
        result += "Amount owed is "+String.valueOf(totalAmount)+"\n";
        result += "You earned "+String.valueOf(frequentRenterPoints)+" frequent renter points";
        return result;
    }

}

