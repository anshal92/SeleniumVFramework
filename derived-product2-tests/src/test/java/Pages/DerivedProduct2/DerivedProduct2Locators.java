package Pages.DerivedProduct2;

import Pages.PageHelper;
import org.openqa.selenium.By;

public class DerivedProduct2Locators extends PageHelper {

    public static final By FOOTER_ANCHOR_LINKS = By.xpath("//footer//a");
    public static final By SHOP_MEN_ELE = By.xpath("//a[contains(text(),'Men')]");

    public static final By DIALOG_BOX_CLOSE = By.xpath("//div[@role='dialog']//div[contains(text(),'x')]");
}
