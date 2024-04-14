package org.ansh.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.InputSource;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tinylog.Logger;

import java.time.Duration;
import java.util.List;

public class ElementAction {

    private WebDriver driver;
    public ElementAction(WebDriver driver) {
        this.driver = driver;
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public void clickElementXPixelUp(By locator, int pixelup){
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(locator);
        int x = webElement.getRect().getX();
        int y = webElement.getRect().getY();
        Logger.debug("X-> "+ x+" and Y->"+y);
        Logger.debug("Performing click at y-> "+(y-pixelup));
        actions.moveToLocation(x,y-pixelup).click().perform();
    }

    public void hoverOver(By locator){
        WebElement webElement = driver.findElement(locator);
        Actions actions = new Actions(driver);
        Logger.debug("Inside hover method.");
        int x = webElement.getRect().getX();
        int y = webElement.getRect().getY();
        Logger.debug("X-> "+ x+" and Y->"+y);
//        ((JavascriptExecutor) driver)
//                .executeScript("document.elementFromPoint(arguments[0], arguments[1]).dispatchEvent(new MouseEvent('mouseover', { bubbles: true }));", x, y);

        actions.moveToElement(webElement, 10,10).perform();
        //actions.moveToElement(webElement).perform();
        //Hack
    }

    public void hoverViaTabKey(By locator){
        WebElement webElement = driver.findElement(locator);
        Actions actions = new Actions(driver);

    }

    public List<WebElement> getListOfWebElements(By locator){
        return driver.findElements(locator);
    }

    public boolean isElementVisible(By locator){
        boolean isVisible = false;
        try {
            WebDriverWait smartwait = new WebDriverWait(driver, Duration.ofSeconds(10));
            smartwait.pollingEvery(Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
            isVisible = true;
        }
        catch (Exception e){

        }
        return isVisible;
    }

    //WebDriver can be cast to any other driver without issue
//    public void testDriver(String driverBrowser){
//        switch (driverBrowser.toLowerCase()){
//            case "chrome":
//                ChromeDriver chromeDriver = (ChromeDriver) driver;
//                System.out.println("Using chrome driver"+chromeDriver.getDevTools().toString());
//                break;
//            case "chromium":
//                ChromiumDriver chromiumDriver = (ChromiumDriver) driver;
//                System.out.println("Using chromiumDriver driver"+chromiumDriver.getCastIssueMessage());
//                break;
//            case "safari":
//                SafariDriver safariDriver = (SafariDriver) driver;
//                System.out.println("Using safariDriver driver"+safariDriver.getPermissions());
//                break;
//            case "firefox":
//                FirefoxDriver firefoxDriver = (FirefoxDriver) driver;
//                System.out.println("Using safariDriver driver"+firefoxDriver.getContext());
//                break;
//            default:
//                throw new RuntimeException("Invalid Choice");
//        }
//
//
//    }


//    public <DriverType extends WebDriver> DriverType getDriverByBrowser(){
//        DriverType driver1 = (DriverType) this.driver;
//        return driver1;
//    }
}
