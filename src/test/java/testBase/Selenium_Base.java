package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Base {
    public static Properties prop;

    // Declare ThreadLocal Driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    //loadConfig method is to load the configuration
    @BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
    public void loadConfig() {


        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }

    public void launchApp(String browserName) {
        // String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            // Set Browser to ThreadLocalMap
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait
                (Duration.ofSeconds(30));
        //PageLoad TimeOuts
        getDriver().manage().timeouts().pageLoadTimeout
                (Duration.ofSeconds(30));
        //Launching the URL
        getDriver().get(prop.getProperty("appURL"));
    }

    @AfterSuite(groups = {"Smoke", "Regression", "Sanity"})
    public void afterSuite() {

    }

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }


}
