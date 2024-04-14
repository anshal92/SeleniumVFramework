package org.ansh.factory;


import org.ansh.drivers.DriverCreation;
import org.ansh.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.time.Duration;

public class DriverCreationFactory {
    static ThreadLocal<String> methodName = new ThreadLocal<>();

    public static WebDriver getDriver(String driverToSelect) {
        WebDriver driver;
        switch (driverToSelect.toLowerCase()){
            case "chrome":// Local Setup
            case "chromium":
                driver = DriverCreation.createDriverForChrome();
                break;
            case "safari": // Local Setup
                driver = DriverCreation.createDriverForSafari();
                break;
            case "firefox": // Local Setup
                driver = DriverCreation.createDriverForFireFox();
                break;
            case "lambdatest": // Cloud Setup
                driver = DriverCreation.createLambdaTestDriver(getTestMethodName());
                break;
            default:
                throw new RuntimeException();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        return driver;
    }

    public static void setTestMethodName(ITestResult result){
        methodName.set(result.getMethod().getMethodName());
    }

    public static String getTestMethodName(){
        return methodName.get();
    }

}
