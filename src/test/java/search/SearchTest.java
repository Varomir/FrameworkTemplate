package search;

import core.BaseTest;
import ddt.TestDataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.ResultPage;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class SearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;

    @Test(dataProvider = "SearchTestData", dataProviderClass = TestDataProvider.class)
    public void periodSearch(String city, LocalDate checkinDate, LocalDate checkoutDate){

        homePage = HomePage.open();
        resultPage = homePage.searchHotels(city, checkinDate, checkoutDate);
        int size = resultPage.getSearchResultSize();
        assertThat("Results item size was not as expected", size, is(greaterThanOrEqualTo(21)));
    }
}
