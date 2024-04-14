package org.ansh.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {
    private WebDriver driver;
    public KeyboardAction(WebDriver driver) {
        this.driver = driver;
    }

    public String tabKeyAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB);
        return driver.switchTo().activeElement().getText();
    }

    public void enterKeyAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);

    }
}
