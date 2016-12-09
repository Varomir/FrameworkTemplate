package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;
import static core.Config.getProperty;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        return driver;
    }

    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static void init() {
        WebDriver driverInput;
        switch (getProperty("test.browser")) {
            case "firefox":
                driverInput = new FirefoxDriver();
                break;
            case "iexplore":
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\IEDriverServer.exe");
                driverInput = new InternetExplorerDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
                driverInput = new ChromeDriver();
                break;
            default:
                throw new AssertionError("Unsupported browser: " + getProperty("test.browser"));
        }

        driverInput.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("test.timeout")), TimeUnit.SECONDS);
        WebDriverFactory.set(driverInput);
        getInstance().manage().window().setSize(new Dimension(1024, 768));
    }

    public static void tearDown() {
        WebDriverFactory.getInstance().quit();
    }
}
