package Pages.CoreProduct;

import Pages.PageHelper;
import org.openqa.selenium.By;

public class CoreProductLocators extends PageHelper {

    //FirstPage
    public static final By THREEDOT_ELE = By.xpath("//li[@data-testid='nav-item-#']//span");
    public static final By NEWS_ELE = By.xpath("//li[@data-testid='nav-item-/warriors/news']//a");

    public static final By DIALOG_BOX_CLOSE = By.xpath("//div[@role='dialog']//div[contains(text(),'x')]");

    public static final By ALL_TIME_ELE = By.xpath("//h3[contains(text(),'VIDEOS')]//..//..//li//div//time//span");

    public static final By CLICK_ELE_FOR_TAB = By.xpath("//div[@data-testid='display-ad']");


}
