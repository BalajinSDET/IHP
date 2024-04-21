package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {

	static public WebDriver driver;
	//public WebDriver driver;// parallel testing
	public Logger logger;
	public Properties p;
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		
		//loading log4j 
		logger=LogManager.getLogger(this.getClass());//Log4j
				
				
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;

			default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("No matching browser..");
			return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	

	// Alternative method for setup 
	/*
	 * public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	 * 
	 * //loadConfig method is to load the configuration
	 * 
	 * @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" }) public void
	 * loadConfig() { ExtentManager.setExtent();
	 * DOMConfigurator.configure("log4j.xml");
	 * 
	 * try { prop = new Properties(); FileInputStream ip = new FileInputStream(
	 * System.getProperty("user.dir") + "\\Configuration\\config.properties");
	 * prop.load(ip);
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } }
	 * 
	 * public static WebDriver getDriver() { // Get Driver from threadLocalmap
	 * return driver.get(); }
	 * 
	 * public void launchApp(String browserName) { // String browserName =
	 * prop.getProperty("browser"); if (browserName.equalsIgnoreCase("Chrome")) {
	 * WebDriverManager.chromedriver().setup(); // Set Browser to ThreadLocalMap
	 * driver.set(new ChromeDriver()); } else if
	 * (browserName.equalsIgnoreCase("FireFox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver.set(new FirefoxDriver()); }
	 * else if (browserName.equalsIgnoreCase("IE")) {
	 * WebDriverManager.iedriver().setup(); driver.set(new
	 * InternetExplorerDriver()); } //Maximize the screen
	 * getDriver().manage().window().maximize(); //Delete all the cookies
	 * getDriver().manage().deleteAllCookies(); //Implicit TimeOuts
	 * getDriver().manage().timeouts().implicitlyWait
	 * (Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
	 * //PageLoad TimeOuts getDriver().manage().timeouts().pageLoadTimeout
	 * (Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
	 * //Launching the URL getDriver().get(prop.getProperty("url")); }
	 * 
	 * 
	 */	
	
	
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	public static void HighlightingElement(WebElement ele) {
		explicitWait(ele);
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].style.border='3px solid blue'", ele);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
}
