import core.BaseTest;
import org.testng.annotations.Test;
import page.objects.HomePage;

public class SearchTest extends BaseTest {

    HomePage homePage;

    @Test
    public void periodSearch(){
        homePage = HomePage.open();
        LOG.debug("period search test");
    }
}
