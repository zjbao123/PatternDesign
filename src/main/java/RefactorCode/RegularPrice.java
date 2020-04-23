package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 23:26:14
 */
public class RegularPrice extends Price{
    static int LEAST_DAY_RENTED = 2;
    @Override
    public double getCharge(int daysRented) {
        double amount = 2;
        if (daysRented > LEAST_DAY_RENTED) {
            amount += ((daysRented - 2) * 1.5);
        }
        return amount;
    }
}
