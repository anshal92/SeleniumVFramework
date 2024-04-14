package PageTest;

import io.cucumber.testng.CucumberOptions;
import org.ansh.AbstractCucumberWebTest;
import org.ansh.listeners.DataProviderListener;
import org.ansh.listeners.ExecutionListener;
import org.ansh.listeners.SuiteListener;
import org.ansh.listeners.TestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(features = {"src/test/resources/PageTest/"},
        glue = {"PageTest"},
        tags = "@DP2",
        plugin = {
                "json:build/cucumber-reports/cucumber.json"
        })
@Listeners({ExecutionListener.class, SuiteListener.class, DataProviderListener.class, TestListener.class})
public class TestRunner extends AbstractCucumberWebTest {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
