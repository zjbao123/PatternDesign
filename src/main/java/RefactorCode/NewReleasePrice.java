package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 23:27:31
 */
public class NewReleasePrice extends Price {

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPoint(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
