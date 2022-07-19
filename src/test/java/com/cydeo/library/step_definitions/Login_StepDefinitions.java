package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.DashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.email.sendKeys("librarian1@library");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.password.sendKeys("qU9mrvur");
        loginPage.signInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(basePage.libraryIcon.isDisplayed());
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.email.sendKeys("student1@library");
    }

    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.password.sendKeys("d5fv9BtX");
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

    @When("user enters credentials using {string} and {string}")
    public void user_enters_credentials_using_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("there should be {int} users")
    public void there_should_be(Integer expectedNumberOfUsers) {
        wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#dashboard"));

        Integer actualNumberOfUsers = Integer.parseInt(dashboardPage.numberOfUsers.getText());
        Assert.assertEquals(expectedNumberOfUsers, actualNumberOfUsers);
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        wait.until(ExpectedConditions.visibilityOf(basePage.accountHolder));
        Assert.assertEquals(expectedName, basePage.accountHolder.getText());
    }
}
