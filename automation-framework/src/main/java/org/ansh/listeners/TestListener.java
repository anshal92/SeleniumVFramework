package org.ansh.listeners;


import org.ansh.drivers.DriverManager;
import org.ansh.factory.DriverCreationFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import org.tinylog.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestListener implements ITestListener {

    public static final int MAX_THREADS = 5;

    @Override
    public void onTestStart(ITestResult result) {
        Logger.debug("---XXX On Test Start XXX---");

        String cloud = System.getProperty("web.cloud");
        Logger.debug("web.cloud -> " + cloud);

        String userCloud = System.getProperty("web.userCloud");
        Logger.debug("web.userCloud -> " + userCloud);

        cloud = userCloud.isEmpty() ? cloud : userCloud;

        Logger.debug("Final cloud set to -> " + cloud);

        List<String> parameters = getDataProviderParameters(result);
        Logger.debug("All parameter are -> " + parameters);

        try {
            Logger.debug("Running UI Test. Driver creation started...");
            DriverCreationFactory.setTestMethodName(result);
            WebDriver driver = DriverCreationFactory.getDriver(cloud);
            Logger.debug("Setting driver -> " + driver.toString() + " on DriverManager");
            DriverManager.setDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.debug("---XXX On Test Success XXX---");

        List<String> parameters = getDataProviderParameters(result);
        Logger.debug("All parameter are -> " + parameters);

        try {
            Logger.debug("Running UI Test. Driver quiting and unloading started...");
            DriverManager.getDriver().quit();
            DriverManager.unload();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.debug("---XXX On Test Failure XXX---");
        List<String> parameters = getDataProviderParameters(result);
        Logger.debug("All parameter are -> " + parameters);

        try {
            Logger.debug("Running UI Test. Driver quiting and unloading started...");
            DriverManager.getDriver().quit();
            DriverManager.unload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        Logger.debug("---XXX On Start XXX---");
        //ToDo: Check why it is not working
        Logger.debug("Default parallel -> "+ context.getCurrentXmlTest().getParallel());
        context.getCurrentXmlTest().setParallel(XmlSuite.ParallelMode.METHODS);

//        String property = System.getProperty("web.userDefinedThreads");
//        Logger.debug("web.userDefinedThreads -> "+ property);
//        int threadToUse = property == null ? MAX_THREADS : Integer.parseInt(property);
//        Logger.debug("Setting final thread count to -> "+ threadToUse);
//        context.getSuite().getXmlSuite().setThreadCount(threadToUse);
        context.getCurrentXmlTest().setThreadCount(MAX_THREADS);
        Logger.debug("Current Thread count is -> "+ context.getCurrentXmlTest().getThreadCount());


    }

    @Override
    public void onFinish(ITestContext context) {
        Logger.debug("---XXX On Finish XXX---");
        ITestListener.super.onFinish(context);
    }

    /**
     * Used to find the dataprovider parameters being passed in specified test
     */
    //ToDo: Can be modified later for other ITestResult use with enum
    private List<String> getDataProviderParameters(ITestResult result) {
        return Arrays.stream(result.getParameters()).map(obj -> String.valueOf(obj)).collect(Collectors.toList());
    }
}
