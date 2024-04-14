package org.ansh;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.tinylog.Logger;

public class AbstractCucumberWebTest extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass(ITestContext context) {
        Logger.debug("Inside AbstractCucumberWebTest");
        Logger.debug("Thread count from AbstractCucumberWebTest -> "+context.getCurrentXmlTest().getThreadCount());
        Logger.debug("Inside AbstractCucumberWebTest Parallel mode is -> "+context.getCurrentXmlTest().getParallel());

        super.setUpClass(context);
    }
}
