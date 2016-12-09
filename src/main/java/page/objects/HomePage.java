package page.objects;

import core.Config;
import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDate;

public class HomePage extends BasePage {

    private static final String LEFT_PANEL = "#frm[data-is-first-visible='1']";
    private By search = By.cssSelector(LEFT_PANEL + " #ss");
    private By checkin = By.cssSelector(LEFT_PANEL + " .c2-wrapper-s-checkin .sb-date-field__controls>input");
    private By checkout = By.cssSelector(LEFT_PANEL + " .c2-wrapper-s-checkout .sb-date-field__controls>input");
    private By submit = By.cssSelector(LEFT_PANEL + " button[type='submit']");

    @Step("Open URL")
    public static HomePage open(){
        WebDriverFactory.getInstance().get(Config.getBaseURL());
        LOG.debug("Open home page");
        return new HomePage();
    }

    @Step("set 'city'")
    private void setSearchCityFld(String text){
        String sequence1 = Keys.chord(text, Keys.TAB);
        getElement(search).sendKeys(sequence1);
    }

    private String prepareDateSequence(LocalDate date) {
        String seq = Keys.chord(String.format("%02d", date.getMonthValue()), String.format("%02d", date.getDayOfMonth()), Integer.toString(date.getYear()), Keys.TAB);
        LOG.debug(" send key sequence " + seq);
        return seq;
    }

    @Step("set 'checkin' date")
    private void setCheckinDateFld(LocalDate date){
        getElement(checkin).sendKeys(prepareDateSequence(date));
    }

    @Step("set 'checkout' date")
    private void setCheckoutDateFld(LocalDate date){
        getElement(checkout).sendKeys(prepareDateSequence(date));
    }

    @Step("click 'Search' button")
    private ResultPage clickSearchBtn(){
        getElement(submit).click();
        return new ResultPage();
    }

    @Step("Search hotels")
    public ResultPage searchHotels(String city, LocalDate checkin, LocalDate checkout){
        setSearchCityFld(city);
        setCheckinDateFld(checkin);
        setCheckoutDateFld(checkout);
        return clickSearchBtn();
    }
}
