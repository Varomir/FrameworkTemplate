package search;

import core.BaseTest;
import ddt.TestDataProvider;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.ResultPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

@Features({"Search functionality"})
public class SearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;

    @Description("Search hotels by period")
    @Stories({"Search - positive"})
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "SearchTestData", dataProviderClass = TestDataProvider.class)
    public void periodSearch(String city, LocalDate checkinDate, LocalDate checkoutDate){

        homePage = HomePage.open();
        resultPage = homePage.searchHotels(city, checkinDate, checkoutDate);
        int size = resultPage.getSearchResultSize();
        assertThat("Results item size was not as expected", size, is(greaterThanOrEqualTo(21)));
    }
}
