package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 23:24:24
 */
public abstract class Price {
    public abstract double getCharge(int daysRented);
    public int getPoint(int daysRented){
        return 1;
    }
}
