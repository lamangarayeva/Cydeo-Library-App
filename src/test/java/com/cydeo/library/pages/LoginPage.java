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

    @FindBy (xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy (xpath = "//div//h2[.='9524']")
    public WebElement numberOfUsers;

    public void login(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signInButton.click();
    }

}
