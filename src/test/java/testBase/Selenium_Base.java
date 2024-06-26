package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportManager;

import static utilities.ExtentManager.test;

public class Selenium_Base extends ExtentReportManager {
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
  //  @Before
    public void setup(@Optional ("chrome") String browser) {
        if (driver != null) {
            launchApp(browser);
        }

       // launchApp(browser);

    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
   // @After
    public void tearDown() {
        if (driver != null) {
            getDriver().quit();
        }

    }

    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

}
