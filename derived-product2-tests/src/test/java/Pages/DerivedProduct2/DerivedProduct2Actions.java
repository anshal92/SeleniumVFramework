package Pages.DerivedProduct2;

import Constants.DerivedProduct2Constant;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DerivedProduct2Actions extends DerivedProduct2Locators{

    public DerivedProduct2Actions(){
        actions.browserAction().maximizeWindow();
        actions.browserAction().goToURL(DerivedProduct2Constant.DERIVED_PRODUCT_URL);
        //actions.elementAction().clickElement(DIALOG_BOX_CLOSE);
    }

    public List<WebElement> getAllAnchorLinksFromFooter(){
        return actions.elementAction().getListOfWebElements(FOOTER_ANCHOR_LINKS);
    }
}
