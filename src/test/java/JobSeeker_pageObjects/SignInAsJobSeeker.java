package JobSeeker_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import ReusabilityMethod.ReusableActions;
import testBase.BaseClass;
import testBase.Selenium_Base;

public class SignInAsJobSeeker extends Selenium_Base {

    public SignInAsJobSeeker() {
        PageFactory.initElements(getDriver(), this);
        // TODO Auto-generated constructor stub
    }

    @FindBy(xpath = "//h4[contains(text(),'Sign in')]")
    protected WebElement SignInJobSeekerHeader;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement emailfield;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement passwordfield;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement signinbutton;

    public void ValidateSignInAsJobSeekerPage() {
        ReusableActions.HighlightingElement(SignInJobSeekerHeader);
        //SignInJobSeekerHeader.isDisplayed();
    }

    public void SetRegisteredEmailId(String email) {
        //	BaseClass.HighlightingElement(emailfield);
        ReusableActions.clickAndType(emailfield, "lgstester50@gmail.com");
        //emailfield.sendKeys("lgstester50@gmail.com");
    }

    public void SetPassword(String password) {
        //BaseClass.HighlightingElement(passwordfield);
        ReusableActions.clickAndType(passwordfield, "Test123");
        //passwordfield.sendKeys("Test123");
    }

    public void ClickSignInButton() {
        //	BaseClass.HighlightingElement(signinbutton);
        ReusableActions.click(signinbutton);
        //	signinbutton.click();
    }

}
