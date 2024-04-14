package parallel;

import Pages.CoreProduct.CoreProductActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ansh.utils.BaseFileHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.tinylog.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class StepDefs {

    CoreProductActions cpa;
    @Given("I am on the CP page")
    public void stepToHome() {
//        System.out.format("Thread ID -> %2d .\n",
//                Thread.currentThread().getId());

        cpa = new CoreProductActions(false);

    }

    @Given("I am on the CP menu page")
    public void stepToNews() {
//        System.out.format("Thread ID -> %2d .\n",
//                Thread.currentThread().getId());

        cpa = new CoreProductActions(true);

    }

    @When("I hover on threeDot and click News")
    public void click_on(){
        //Note: Not able to use perform the action as moveToElement Does not work.
        cpa.hoverOverMenu()
                .clickNewsLink();
    }

    @Then("the page url should contain {string}")
    public void checkUrl(String urlToAssert){
        Logger.debug("Current Url -> "+ cpa.getPageUrl());
        Assert.assertTrue(cpa.getPageUrl().contains(urlToAssert));

    }

    @Then("I count total video feeds and flag all video feeds more than {string}")
    public void getAllTime(String time){
        List<WebElement> allTimeData = cpa.getAllTimeData();
        Assert.assertTrue(!allTimeData.isEmpty(),"No Video Feed found!!! Video feed must be more than 0");

        List<String> allTimeDataForVideoFeeds = allTimeData.stream().map(WebElement::getText).collect(Collectors.toList());
        char[] timeCharArray = time.toCharArray();
        List<String> collect = allTimeDataForVideoFeeds.stream()
                .filter(t -> t.contains(String.valueOf(timeCharArray[1])))
                .collect(Collectors.toList());
        Logger.debug("The feeds that are in days -> "+ collect);

        List<String> collect1 = collect.stream()
                .filter(filteredTime ->
                        Integer.parseInt(String.valueOf(filteredTime.toCharArray()[0])) > Integer.parseInt(String.valueOf(timeCharArray[0]))
                ).collect(Collectors.toList());

        Logger.debug("The feeds that are more than "+ timeCharArray[0]+" days -> "+ collect1);
        Logger.debug("The count of feeds that are more than "+ timeCharArray[0]+" days -> "+ collect1.size());
    }
}
