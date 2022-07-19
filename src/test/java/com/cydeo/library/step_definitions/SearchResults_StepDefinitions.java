package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.UserManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResults_StepDefinitions {

    BasePage basePage = new BasePage();
    UserManagementPage userManagementPage = new UserManagementPage();

    @Given("user clicks on {string} link")
    public void user_clicks_on_link(String link) {
        basePage.navigateTo(link);
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumns) {
        List<String> actualColumns = new ArrayList<>();

        for (WebElement eachColumn : userManagementPage.columns) {
            actualColumns.add(eachColumn.getText());
        }

        Assert.assertEquals(expectedColumns, actualColumns);
    }

}
