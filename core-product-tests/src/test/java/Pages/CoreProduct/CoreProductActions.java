package Pages.CoreProduct;

import Constants.CoreProductConstant;
import org.ansh.actions.Actions;
import org.openqa.selenium.WebElement;
import org.tinylog.Logger;

import java.util.List;

public class CoreProductActions extends CoreProductLocators{

    public CoreProductActions(boolean requireNewsPage){
        actions.browserAction().maximizeWindow();
        if(requireNewsPage) actions.browserAction().goToURL(CoreProductConstant.CORE_PRODUC_NEWST_URL);
        else actions.browserAction().goToURL(CoreProductConstant.CORE_PRODUCT_URL);

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean elementVisible = actions.elementAction().isElementVisible(DIALOG_BOX_CLOSE);
        System.out.println("Is ElementVisible ->"+ elementVisible);
        if(elementVisible)actions.elementAction().clickElement(DIALOG_BOX_CLOSE);
        actions.browserAction().refreshPage();
    }


    public CoreProductActions hoverOverMenu(){
        actions.elementAction().hoverOver(THREEDOT_ELE);
        return this;
    }
    public CoreProductActions hoverOverMenu2(){
        actions.elementAction().clickElementXPixelUp(THREEDOT_ELE, 20);
        String tabActionElement = actions.keyboardAction().tabKeyAction();
        int count = 0;
        while (!tabActionElement.equals("...") && count < 23){
            Logger.debug("Pressing tab to change active element");
            tabActionElement = actions.keyboardAction().tabKeyAction();
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            count++;
        }
        Logger.debug("Final Active element text is -> "+tabActionElement);
        actions.keyboardAction().enterKeyAction();
        return this;
    }

    public CoreProductActions clickNewsLink(){
        actions.elementAction().clickElement(NEWS_ELE);
        return this;
    }

    public List<WebElement> getAllTimeData(){
        return actions.elementAction().getListOfWebElements(ALL_TIME_ELE);
    }


}
