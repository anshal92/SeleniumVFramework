package org.ansh.actions;

import org.ansh.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Actions {

    private final WebDriver driver;
    public Actions(){
        System.out.println("Inside Action Constructor.");
        driver = DriverManager.getDriver();
        System.out.println("The driver is -> "+ driver.toString());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

     public ElementAction elementAction(){
         return new ElementAction(driver);
     }

    public ScrollAction scrollAction(){
         return new ScrollAction(driver);
     };

    public BrowserAction browserAction(){
         return new BrowserAction(driver);
     };

    public KeyboardAction keyboardAction(){
         return new KeyboardAction(driver);
     };


}
