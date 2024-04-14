package org.ansh.drivers;


import org.ansh.utils.BaseFileHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverCreation {

    //Lambda Test config requirement.
    // ToDo: Need to move to better impl soon
    public static WebDriver driver = null;
    public static String gridURL = "@hub.lambdatest.com/wd/hub";

    static BaseFileHelper baseFileHelper = new BaseFileHelper();


    /** Incase of doubt on driver Binaries being used.
     * Please go through this -> https://www.selenium.dev/blog/2023/whats-new-in-selenium-manager-with-selenium-4.11.0/
     * tldr; Driver management through Selenium Manager is opt-in for the Selenium bindings.
     * Thus, users can continue managing their drivers manually (putting the driver in the PATH or
     * using system properties) or rely on a third-party manager to do it automatically.
     * Selenium Manager only operates as a fallback: if no driver is provided, Selenium Manager will come to the rescue.*/
    public static WebDriver createDriverForChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        return chromeDriver;
    }

    public static WebDriver createDriverForSafari(){

        SafariOptions safariOptions = new SafariOptions();
        SafariDriver safariDriver = new SafariDriver(safariOptions);
        return safariDriver;
    }

    public static FirefoxDriver createDriverForFireFox(){

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        return firefoxDriver;
    }


    //ToDo: Integrate later
    public static WebDriver createLambdaTestDriver(String methodName){
        //Default Properties for now
        //Properties dataAsProperties = baseFileHelper.getDataAsProperties(RunType.SELENIUM);
        //baseFileHelper.setSystemProperty(dataAsProperties);
        String platform = System.getProperty("web.platform");

        ChromeOptions browserOptions = new ChromeOptions();

        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(System.getProperty("web.browserVersion"));

        HashMap<String, Object> ltOptions = new HashMap<>();

        //StackWalker to get current Method
        /*StackWalker stackWalker = StackWalker.getInstance();

        String defaultMethod = stackWalker.walk(frames -> frames
                .filter(stackFrame -> stackFrame.getMethodName().contains("test"))
                .findFirst().map(sf -> sf.getMethodName())
                .orElse("DefaultMethod"));*/

        ltOptions.put("name", methodName);

//        ltOptions.put("username", LambdaTest.LT_USERNAME);
//        ltOptions.put("accessKey", LambdaTest.LT_ACCESS_KEY);

        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("console", "true");

        ltOptions.put("project", System.getProperty("web.project")/*+ LocalDateTime.now().toEpochSecond(ZoneOffset.of("+05:30"))*/);
        ltOptions.put("selenium_version", System.getProperty("web.seleniumVersion"));

        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        String lambdaTestUrlString = "https://" + "username" + ":" + "accesskey" + gridURL;
        System.out.println("LambdaTestUrl -> "+ lambdaTestUrlString);
        try {
            driver = new RemoteWebDriver(new URL(lambdaTestUrlString), browserOptions);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }
}
