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
    }

    public void SetRegisteredEmailId(String email) {
        ReusableActions.clickAndType(emailfield, "lgstester50@gmail.com");
    }

    public void SetPassword(String password) {
        ReusableActions.clickAndType(passwordfield, "Test123");
    }

    public void ClickSignInButton() {
        ReusableActions.click(signinbutton);
    }

}
