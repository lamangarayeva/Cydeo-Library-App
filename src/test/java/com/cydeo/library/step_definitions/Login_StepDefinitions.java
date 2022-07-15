package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.email.sendKeys(ConfigurationReader.getProperty("librarian_email"));
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        loginPage.signInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(dashboardPage.libraryIcon.isDisplayed());
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.email.sendKeys(ConfigurationReader.getProperty("student_email"));
    }

    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("student_password"));
        loginPage.signInButton.click();
    }

    // login with parameters

    @When("user enters librarian username {string}")
    public void user_enters_librarian_username(String librarianUsername) {
       loginPage.email.sendKeys(librarianUsername);
    }

    @When("user enters librarian password {string}")
    public void user_enters_librarian_password(String librarianPassword) {
     loginPage.password.sendKeys(librarianPassword);
     loginPage.signInButton.click();
    }

    @When("user enters student username {string}")
    public void user_enters_student_username(String studentUsername) {
        loginPage.email.sendKeys(studentUsername);
    }

    @When("user enters student password {string}")
    public void user_enters_student_password(String studentPassword) {
       loginPage.password.sendKeys(studentPassword);
       loginPage.signInButton.click();
    }
}
