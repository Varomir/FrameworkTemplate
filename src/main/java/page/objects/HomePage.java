package page.objects;

import core.BaseTest;
import core.Config;
import core.WebDriverFactory;

public class HomePage extends BaseTest {

    public static HomePage open(){
        WebDriverFactory.getInstance().get(Config.getBaseURL());
        LOG.debug("Open home page");
        return new HomePage();
    }
}
