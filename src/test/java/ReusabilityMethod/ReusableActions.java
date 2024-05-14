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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testBase.Selenium_Base;
import utilities.ColorUtils;

import static utilities.ColorUtils.stringToColor;

public class ReusableActions extends Selenium_Base {
    public static ExtentTest node;

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
            //  reportStep("The Element is " + text + " clicked successfully", "pass");
            //    System.out.println("The Element " + text + " clicked successfully ==> Test Pass");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The Element " + text + " could not be clicked ==> Test fail");
            //    reportStep("The Element is" + text + " could not be clicked", "fail");
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

    public static void JsScrollClick(WebElement ele) {
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
            //   reportStep("The Element is " + text + " entered successfully", "pass");
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

    public static void JSDatePicker(WebElement ele, String dateval) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ele));
        HighlightingElement(ele);
        JavascriptExecutor JS = (JavascriptExecutor) getDriver();
        JS.executeScript("arguments[0].setAttribute('value','" + dateval + "');", ele);
    }

    public static void JsScrollClickAndEnter(WebElement ele, String data) {
        String text = "";
        try {
            explicitWait(ele);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].scrollIntoView();", ele);
            clickAndType(ele, data);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void fluentWait(WebElement ele) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<>((WebDriver) getDriver())
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(4))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(ele));
            ele.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void VerifyAutocompletion(WebElement ele, String singlecharacter, List<WebElement> listofoptions, String Expected_Text) {
        click(ele);
        ele.sendKeys(singlecharacter); //s
        explicitWait(ele);
        System.out.println(listofoptions.size());
        for (WebElement option : listofoptions) {
            if (option.getText().equals(Expected_Text)) {  //expected text = selenium
                option.click();
                break;
            }
        }
    }

    public static void VerifyFileDownLoad(WebElement element, String pathfile, String filename) {
        click(element);
        File filelocation = new File(pathfile);
        File[] totalfiles = filelocation.listFiles();

        for (File file : totalfiles) {
            if (file.getName().equals(filename)) {
                System.out.println("File is download successfully");
                break;
            }
        }
    }

    public static void VerifyStaticWebTable(WebElement Table) {
        List<WebElement> rows = Table.findElements(By.tagName("tr"));
        List<WebElement> columns = Table.findElements(By.tagName("th"));

        System.out.println("Total Number of Columns count are : " + columns.size());
        System.out.println("Total Number of Rows count are : " + rows.size());

        DelayWithGivenTime(3000);

        for (WebElement ColumnElement : columns) {
            String ColumnName = ColumnElement.getText();
            System.out.print(" | " + ColumnName + "\t");
        }
        for (WebElement rowElement : rows) {
            List<WebElement> cells = rowElement.findElements(By.tagName("td"));
            for (WebElement cellElement : cells) {
                HighlightingElement(cellElement);
                String cellData = cellElement.getText();
                System.out.print("| " + cellData + "\t");
            }
            System.out.println(" | ");
        }
        System.out.println(" ------------------------------------------------- ");
// To get specific row values...
       /* for(int r=1;r<=rows.size()-1;r++)
        {
            String EmployeeName=getDriver().findElement(By.xpath("//table[@id='tabledata2']//tbody//tr["+r+"]//td[3]")).getText();
            String ApprovalCount=getDriver().findElement(By.xpath("//table[@id='tabledata2']//tbody//tr["+r+"]//td[6]")).getText();
            String Avg_Response_Time=getDriver().findElement(By.xpath("//table[@id='tabledata2']//tbody//tr["+r+"]//td[7]")).getText();
            System.out.println("Displayed Employee Name is :"+  EmployeeName + " Total Approval Count are : " +ApprovalCount+" Average Response time taken : "+Avg_Response_Time);
        }
        System.out.println(" ------------------------------------------------- ");*/
    }

    public static void GetSumOfValues(WebElement Total) {
        try {
            int sumOfFields = 0;
            WebElement[] fields = new WebElement[]{//Field1, Field2, Field3, Field4, Field5, Field6, Field7,
                    // Field8, Field9, Field10, Field11, Field12, Field13
            };

            for (WebElement field : fields) {
                String fieldValue = field.getAttribute("value");
                int fieldValueInt = Integer.parseInt(fieldValue);
                sumOfFields += fieldValueInt;
            }
            String No_OF_CUSTOMERS = String.valueOf(sumOfFields);
            System.out.println("The integer as a string: " + No_OF_CUSTOMERS);
            System.out.println("Sum of fields: " + sumOfFields);

            String TotalNoOfCustomer = Total.getAttribute("value");
            System.out.println("Total number of customers: " + Integer.parseInt(TotalNoOfCustomer));

            if (No_OF_CUSTOMERS.equals(TotalNoOfCustomer)) {
                System.out.println("The Total No Of Customers are " + No_OF_CUSTOMERS);
            } else {
                System.out.println("Sum of fields is" + No_OF_CUSTOMERS + " not equal to total number of customers" + TotalNoOfCustomer);
                Assert.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void HandleAnalogClock(String OutTime, WebElement outtime) {
        String OT = OutTime; //5:30 PM
        click(outtime);
        DelayWithGivenTime(2000);
        getDriver().switchTo().activeElement();

        String[] dt = OT.split(":");
        System.out.println("Hour is :" + dt[0]);
        System.out.println("Minutes is :" + dt[1]);

        WebElement SelectHour = getDriver().findElement(By.xpath("//div[@class='mdtimepicker']//section[@class='mdtp__clock_holder']//span[contains(text()," + dt[0] + ")]"));
        DelayWithGivenTime(2000);
        click(SelectHour);

        WebElement SelectMinute = getDriver().findElement(By.xpath("//div[@class='mdtp__minute_holder']//span[contains(text(), " + dt[1].substring(0, 1) + ")]"));
        click(SelectMinute);

        WebElement PMbutton = getDriver().findElement(By.xpath("(//span[@class = 'mdtp__pm active'])[1]"));
        JsScrollClick(PMbutton);

        WebElement okbutton = getDriver().findElement(By.xpath("(//span[@class='mdtp__button ok'])[1]"));
        JsScrollClick(okbutton);
    }

    public static void DatePicker(WebElement ele) {
        String monthyear = "March, 2024";
        String day = "6";
        click(ele);
        //Month & Year text on calendar
        explicitWait(getDriver().findElement(By.xpath("(//td[@class='dp_caption'])[3]")));

        while (true) {
            String text = getDriver().findElement(By.xpath("(//td[@class='dp_caption'])[3]")).getText();
            //  System.out.println("Displayed month & year is : " + text);
            if (text.equals(monthyear)) {
                break;
            }
            // calendar arrow button to change month it can be either forward or backward
            WebElement NextArrow = getDriver().findElement(By.xpath("(//td[@class='dp_next'])[2]"));
            click(NextArrow);
        }
        // Store the list of date elements
        List<WebElement> alldates = getDriver().findElements(By.xpath("(//table[@class='dp_daypicker'])[2]//tr//td"));
        for (WebElement element : alldates) {
            String days = element.getText();
            if (days.equals(day)) {
                // actionClick(element);
                element.click();
                break;
            }
        }
    }

    public static void SwitchToWindowByIndex(int i) {
        Set<String> windowIds = getDriver().getWindowHandles();
        List<String> windowIdslist = new ArrayList<>(windowIds);

        String parentWinId = windowIdslist.get(0);
        String childWindowId2 = windowIdslist.get(i);
        System.out.println("Total Number of Windows Currently Opened are : " + windowIdslist.size());
        getDriver().switchTo().window(childWindowId2);
        System.out.println("Displayed title of page is : " + getDriver().getTitle());
    }

    public String getBackgroundColor(WebElement ele) {
        String cssValue = ele.getCssValue("color");
        return cssValue;
    }

    public String getTypedText(WebElement ele) {
        String attributeValue = ele.getAttribute("value");
        return attributeValue;
    }

    public void drawSignature(WebElement ele) {
        try {
            Actions actionBuilder = new Actions(getDriver());
            Action drawOnCanvas = actionBuilder
                    .moveToElement(ele, 8, 8)
                    .clickAndHold(ele)
                    .moveByOffset(120, 120)
                    .moveByOffset(60, 70)
                    .moveByOffset(-140, -140)
                    .release(ele)
                    .build();
            drawOnCanvas.perform();
            // reportStep("Signature drawn successfully", "pass");
        } catch (StaleElementReferenceException e) {
            //  reportStep("Signature could not been drawn successfully", "fail");
            throw new RuntimeException();
        } catch (Exception e) {
            //  reportStep("Signature "+e+" could not been drawn successfully", "fail");
            throw new RuntimeException();
        }
    }

    public void sendImageFile(String querySelector, String imageName) throws InterruptedException {
        String text = "";
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            WebElement chooseImage = (WebElement) jse.executeScript(" return " + querySelector + "");
            File file = new File("./file/" + imageName + ".png");
            chooseImage.sendKeys(file.getAbsolutePath());

            //   reportStep("The Image " + imageName + " Uploaded Successfully", "pass");
        } catch (StaleElementReferenceException e) {
            //   reportStep("The Element " + e + " could not be Uploaded Successfully", "fail");
            throw new RuntimeException();
        } catch (Exception e) {
            //   reportStep("The Element " + e + " could not be Uploaded Successfully", "fail");
            throw new RuntimeException();
        }
    }

    public void jsTypeAndEnter(WebElement ele, String data) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].value='" + data + "'", ele);
            ele.sendKeys(Keys.ENTER);
            //  reportStep("The Data :" + data + " entered Successfully", "pass");
        } catch (ElementNotInteractableException e) {
            //  reportStep("The Element " + ele + " is not Interactable", "fail");
            throw new RuntimeException();
        } catch (Exception e) {
            //  reportStep("The Element " + e + " could not be clicked", "fail");
            throw new RuntimeException();
        }
    }

    public static long takeSnap() {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),
                    new File("./reports/images/" + number + ".jpg"));
        } catch (WebDriverException e) {
            System.out.println("The browser has been closed.");
        } catch (IOException e) {
            System.out.println("The snapshot could not be taken");
        }
        return number;
    }

    public void GetCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }


    public void switchToFrame(int index) {
        //Use it when one frame present
        getDriver().switchTo().frame(index);
    }

    public void switchToFrame(WebElement ele) {
        getDriver().switchTo().frame(ele);
    }

    public void switchToFrame(String idOrName) {
        getDriver().switchTo().frame(idOrName);
    }

    public void defaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public boolean verifyUrl(String url) {
        if (getDriver().getCurrentUrl().equals(url)) {
            System.out.println("The url: " + url + " matched successfully");
            return true;
        } else {
            System.out.println("The url: " + url + " not matched");
        }
        return false;
    }


    public boolean verifyTitle(String title) {
        if (getDriver().getTitle().equals(title)) {
            System.out.println("Page title: " + title + " matched successfully");
            return true;
        } else {
            System.out.println("Page url: " + title + " not matched");
        }
        return false;
    }

    public String getCurrentUrl() {
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    public static void reportStep(String dec, String status, boolean bSnap) {


        Media img = null;
        if (bSnap && !status.equalsIgnoreCase("INFO")) {

            long snapNumber = 100000L;
            snapNumber = takeSnap();
            img = MediaEntityBuilder.createScreenCaptureFromPath
                    ("./../Reports/images/" + snapNumber + ".jpg").build();
        }

        if (status.equalsIgnoreCase("pass")) {
            node.pass(dec, img);
        } else if (status.equalsIgnoreCase("fail")) {
            node.fail(dec, img);
        }
    }

    public static void reportStep(String desc, String status) {
        reportStep(desc, status, true);
    }

    public static void ValidateElementColor(WebElement ele) {
        String colorele = ele.getCssValue("color");
        String hex_code = Color.fromString(colorele).asHex();
        System.out.println("Displayed heading color is : " + colorele);
        System.out.println("Displayed heading hex color code is : " + hex_code);
        java.awt.Color c = stringToColor(hex_code);
        System.out.println("Displayed heading exact color name is : " + ColorUtils.getColorNameFromColor(c));
    }





}
