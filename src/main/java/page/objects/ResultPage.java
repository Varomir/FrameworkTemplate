package page.objects;

import org.openqa.selenium.By;

public class ResultPage extends BasePage {

    private static final String SEARCH_CONTAINER = "//div[@id='hotellist_inner']";
    private By searchResults = By.xpath(SEARCH_CONTAINER + "/div[contains(@class,'sr_item sr_item_new')]");


    public int getSearchResultSize(){
        return getElements(searchResults).size();
    }
}
