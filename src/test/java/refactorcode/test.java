package refactorcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-04-23 22:04:22
 */


public class test {
    @Test
    public void statement(){
        Customer customer = new Customer("Bob");
        String title = "Titanic";
        int priceCode = 2;
        int daysRented = 6;
        Movie movie = new Movie(title,priceCode);
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        String result= customer.statement();
        System.out.println("------------------");
        System.out.println(result);
        System.out.println("------------------");
        String testResult = "Rental Record for Bob\n" +
                "\tTitanic\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 1 frequent renter points";
        System.out.println(testResult);
        assertEquals("测试demo", result, testResult);

    }
}
