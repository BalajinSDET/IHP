package ReusabilityMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testBase.Selenium_Base;

public class ReusableActions extends Selenium_Base {


    public static void HighlightingElement(WebElement ele) {
        explicitWait(ele);

        JavascriptExecutor JS = (JavascriptExecutor) getDriver();
        JS.executeScript("arguments[0].style.border='3px solid blue'", ele);
    }

    public static void explicitWait(WebElement element) {
        WebDriverWait wait =
                new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void click(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            HighlightingElement(ele);
            text = ele.getText();
            ele.click();
        //    System.out.println("The Element " + text + " clicked successfully ==> Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The Element " + text + " could not be clicked ==> Test fail");
        }
    }

    public static void actionClick(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            Actions action = new Actions(getDriver());
            text = ele.getText();
            HighlightingElement(ele);
            action.moveToElement(ele).click().build().perform();
         //   System.out.println("The Element " + text + " clicked" + "Passed");
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The Element " + text + " could not be clicked" + "fail");
            Assert.fail();
        }
    }

    public void JSScrollClick(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(ele));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            text = ele.getText();
            HighlightingElement(ele);
            ele.click();
            System.out.println("The Element " + text + " clicked" + "Passed");
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actionScrollClick(WebElement ele) throws InterruptedException {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(ele));
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(ele);
            Actions action = new Actions(getDriver());
            action.scrollFromOrigin(scrollOrigin, 100, 200)
                    .perform();
            HighlightingElement(ele);
            actionClick(ele);
            System.out.println("The Element " + text + " clicked" + "Passed");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void JsScrollClick(WebElement ele) throws InterruptedException {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(ele));
            HighlightingElement(ele);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].scrollIntoView();", ele);
            click(ele);
            System.out.println("The Element " + text + " clicked" + "Passed");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public static void clearAndType(WebElement ele, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(ele));
            HighlightingElement(ele);
            ele.clear();
            ele.sendKeys(data);
        } catch (ElementNotInteractableException e) {
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void clickAndType(WebElement ele, String data) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            text = ele.getText();
            HighlightingElement(ele);
            ele.click();
            Thread.sleep(1000);
            ele.sendKeys(data);
         //   System.out.println("The Element " + text + " entered success Test Pass");
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void DropDown(WebElement ele, String value, String usingmethod) {
        Select select = new Select(ele);

        switch (usingmethod) {
            case "index":
                HighlightingElement(ele);
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                HighlightingElement(ele);
                select.selectByValue(value);
                break;
            case "VisibleText":
                click(ele);
                HighlightingElement(ele);
                select.selectByVisibleText(value);
                break;
            default:
                break;
        }
    }

    public void fluentWait(WebDriver driver, WebElement ele) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(4))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String acceptAlert() {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            text = alert.getText();

            System.out.println("Displayed pop up text is :" + text);
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("There is no alert present -----> fail");
        } catch (WebDriverException e) {
            System.out.println("WebDriverException : " + e.getMessage());
        }

        return text;
    }

    public static void uploadFile(WebElement ele, String filepath) throws AWTException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(ele));
        HighlightingElement(ele);
        ele.click(); // Click on browse option on the webpage
        Thread.sleep(2000); // suspending execution for specified time period

        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void DelayWithGivenTime(int i) {
        try {
            Robot robot = new Robot();
            robot.delay(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void JSDatePicker(WebDriver driver, WebElement ele, String dateval) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
        HighlightingElement(ele);
        JavascriptExecutor JS = (JavascriptExecutor) driver;
        JS.executeScript("arguments[0].setAttribute('value','" + dateval + "');", ele);
    }

    public static void SearchAndSelectDropDown(WebElement ele, WebElement text_box, String data) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        HighlightingElement(ele);
        click(ele);
        DelayWithGivenTime(2000);
        HighlightingElement(text_box);
        clickAndType(text_box, data + Keys.ENTER);
    }

    public static void MouseHover(WebElement ele) {
        String text = "";
        try {
            Actions action = new Actions(getDriver());
            action.moveToElement(ele).build().perform();
            text = ele.getAttribute("title");
            System.out.println("Displayed tooltip info is : " + text);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    public static void switchWindowByIndex(int index) {
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        String window = windows.get(index);
        getDriver().switchTo().window(window);
        System.out.println("Displayed Page title is : " + getDriver().getTitle());
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

    public String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
      /*  // This new path for jenkins
        String newImageString = "http://localhost:8080/job/IHP_Demo_Test/ws/reports/" + filename + "_"
                + dateName + ".png";
        return newImageString;*/


        return dateName;
    }
}
