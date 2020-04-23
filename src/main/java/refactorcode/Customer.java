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
            //各类积分情况
            switch (rental.getMovie().getPriceCode()) {
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        thisAmount += ((rental.getDaysRented() - 3) * 1.5);
                    }
                    break;
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        thisAmount += ((rental.getDaysRented() - 2) * 1.5);
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                default:
                    break;
            }

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

