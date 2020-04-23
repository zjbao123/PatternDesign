package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 23:27:05
 */
public class ChildrenPrice extends Price {
    static int LEAST_DAY_RENTED = 3;
    @Override
    public double getCharge(int daysRented) {
        double amount = 1.5;
        if (daysRented > LEAST_DAY_RENTED) {
            amount += ((daysRented - 3) * 1.5);
        }
        return amount;
    }
}
