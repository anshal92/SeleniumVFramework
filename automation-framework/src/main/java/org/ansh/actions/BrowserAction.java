package org.ansh.actions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class BrowserAction {
    private WebDriver driver;
    public BrowserAction(WebDriver driver) {
        this.driver = driver;
    }

    public void goToURL(String url){
        driver.get(url);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void deleteAllCookie(){
        driver.manage().deleteAllCookies();
    }


}
