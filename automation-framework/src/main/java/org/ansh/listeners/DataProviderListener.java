package org.ansh.listeners;

import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.tinylog.Logger;

public class DataProviderListener implements IDataProviderListener {
    @Override
    public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method, ITestContext iTestContext) {
        Logger.debug("Inside DataProviderListener");
        Logger.debug("The data provider thread count is ->"+ iTestContext.getCurrentXmlTest().getThreadCount());
        Logger.debug("The data provider parallel is ->"+ dataProviderMethod.isParallel());

        IDataProviderListener.super.beforeDataProviderExecution(dataProviderMethod, method, iTestContext);
    }
}
