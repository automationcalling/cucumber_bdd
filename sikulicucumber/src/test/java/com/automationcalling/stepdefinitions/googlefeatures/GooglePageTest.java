package com.automationcalling.stepdefinitions.googlefeatures;

import com.automationcalling.sikuli.SikuliUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.automationcalling.driverfactory.DriverInitalization;
import com.automationcalling.imageobjects.GoogleHomePage;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

public class GooglePageTest extends DriverInitalization {

    @Before
    public void init() {
        try {
            driver = getDriver();
            initalizeDriver(driver);
            Assert.assertNotNull(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("I open a browser")
    public void i_open_a_browser() {
        try {
            launchURL();
            maximizeWindow();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @When("I enter the following text in google search page")
    public void i_enter_the_following_text_in_google_search_page(DataTable dataTable) {
        try {
            new SikuliUtil().initializeImage(new GoogleHomePage().googleTextbox()).sikuliOperation(dataTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I click on google search button")
    public void i_click_on_google_search_button() {
        try {
            new SikuliUtil().initializeImage(new GoogleHomePage().googleSearchButton()).clickAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I use reusable Sikuli Utils with following actions")
    public void i_use_reusable_Sikuli_Utils_with_following_actions(DataTable dataTable) {
        try {
            new SikuliUtil().sikuliOperation(dataTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        destroyDriver();
    }


}
