package com.cydeo.library.step_definitions;

/*
In this class we will be able to pass pre- and post-condition to each scenario and step
 */

import com.cydeo.library.utilities.DBUtils;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //BrowserUtils.sleep(5);
        Driver.closeDriver(); // closes driver after every scenario

    }

    @Before("@db")
    public void setUpDB(){
        System.out.println("creating database conneciton...");
        DBUtils.createConnection();

    }

    @After("@db")
    public void tearDownDb(){
        System.out.println("ending database connection...");
        DBUtils.destroy();
    }


}
