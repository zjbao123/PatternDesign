package refactorcode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-23 23:30:03
 */
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode){
        this.priceCode = priceCode;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public double getAmount(int daysRented) {
        double amount = 0;
        switch (priceCode) {
            case CHILDREN:
                amount += 1.5;
                if (daysRented > 3) {
                    amount += ((daysRented - 3) * 1.5);
                }
                break;
            case REGULAR:
                amount += 2;
                if (daysRented > 2) {
                    amount += ((daysRented - 2) * 1.5);
                }
                break;
            case NEW_RELEASE:
                amount += daysRented * 3;
                break;
            default:
                break;
        }
        return amount;
    }
}
