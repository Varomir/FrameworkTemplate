package page.objects;

import core.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BasePage {

    protected static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver;

    public BasePage() {
        driver = WebDriverFactory.getInstance();
    }

    protected WebElement getElement(By locator) {
        LOG.debug(" get single element by locator: " + locator.toString());
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator) {
        LOG.debug(" get list of elements by locator: " + locator.toString());
        return driver.findElements(locator);
    }
}
