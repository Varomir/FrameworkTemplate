package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        LOG.info("start browser");
        WebDriverFactory.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        LOG.info("stop browser");
        WebDriverFactory.tearDown();
    }
}
