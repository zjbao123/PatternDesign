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
    private Price price;

    public Movie(String title, int priceCode) {
        this.priceCode = priceCode;
        this.title = title;
        switch (priceCode) {
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");

        }
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
        return price.getCharge(daysRented);
    }

    public int calcFrequentPoints(int daysRented) {
        return price.getPoint(daysRented);
    }
}
