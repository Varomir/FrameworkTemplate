package page.objects;

import core.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverFactory.getInstance(), this);
    }
}
