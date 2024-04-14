package PageTest;

import Pages.DerivedProduct2.DerivedProduct2Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ansh.utils.BaseFileHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StepDef {
    DerivedProduct2Actions dp2a;
    List<String> allHrefLinks;
    List<String> allDuplicates;
    @Given("I am on the DP2 page")
    public void step() {
//        System.out.format("Thread ID -> %2d .\n",
//                Thread.currentThread().getId());
        dp2a = new DerivedProduct2Actions();

    }

    @When("I get all anchor links present")
    public void getAllAnchorLinks(){
        List<WebElement> allAnchorLinksFromFooter = dp2a.getAllAnchorLinksFromFooter();
        allHrefLinks = allAnchorLinksFromFooter.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .collect(Collectors.toList());
        Logger.debug(allHrefLinks);
    }

    @Then("I store all links and find duplicates")
    public void storeAllLinkAndDuplicate(){

        long count = allHrefLinks.size();
        Logger.debug("Initial Hrefs -> "+ allHrefLinks);
        long distinct = allHrefLinks.stream().distinct().count();
        Logger.debug("Count -> "+ count);
        Logger.debug("Distinct -> "+ distinct);

        allDuplicates = getAllDuplicates(allHrefLinks);

        Logger.debug("All duplicates -> "+ allDuplicates);
    }

    @Then("I write them to a CSV file[output.csv] and flag duplicates")
    public void storeToCSV(){
        BaseFileHelper.writeStringToFile(allHrefLinks.toString(), true);
        Assert.assertTrue(allDuplicates.isEmpty(),"Duplicate found!!! \n Duplicate is -> "+ allDuplicates);
    }

    private List<String> getAllDuplicates(List<String> list){
        return new ArrayList<>(allHrefLinks.stream()
                .filter(link -> Collections.frequency(allHrefLinks, link) > 1)
                .collect(Collectors.toSet()));
    }
}
