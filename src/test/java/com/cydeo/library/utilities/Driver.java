package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor so that we close the access to the object
    of this class from outside the class
     */
    private Driver() {}

    /*
    We make WebDriver private because we want to close the access from outside
    the class
    We make it static because we will use it in a static method. (It makes it belongs to the class.
    it makes it run before everything else)
     */
    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method, which will return the same driver instance
    when we call it
     */
    public static WebDriver getDriver(){
        if(driverPool.get() == null){ // driver

            /*
            We read our browserType from configuration.properties
            This way, we can control which browser is opened from outside our code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will be returned from the configuration.properties file
            switch statement will determine the case, and open the matching browser
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver()); // driver = new ChromeDriver();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver() {
        if (driverPool.get() != null) { // if there is an existing session
            driverPool.get().quit();   // terminate the existing session, value not will be even null
            driverPool.remove();  // setting drive value to null to make sure when browser is closed and session is terminated
            // it will be null again. when getDriver method is called, it will check if the driver is null and creates another one
        }
    }

}
