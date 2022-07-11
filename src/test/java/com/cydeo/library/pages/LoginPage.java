package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.module.Configuration;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "inputEmail")
    public WebElement email;

    @FindBy (id = "inputPassword")
    public WebElement password;

    @FindBy (tagName = "button")
    public WebElement signInButton;

    public void login(){
        email.sendKeys(ConfigurationReader.getProperty("librarian_email"));
        password.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        signInButton.click();
    }

}
