package RefactorCode;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-23 23:30:03
 */
public class Movie {

    public static final int CHILDRENS = 2;
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
}
