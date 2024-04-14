package Pages.DerivedProduct1;

import Pages.PageHelper;
import org.openqa.selenium.By;

public class DerivedProduct1Locators extends PageHelper {

    public static final By TICKETS_ELE = By.xpath("//span[contains(text(),'Tickets')]");
    public static final By SHOP_MEN_ELE = By.xpath("//a[contains(text(),'Men')]");

    public static final By DIALOG_BOX_CLOSE = By.xpath("//div[@role='dialog']//div[contains(text(),'x')]");
}
