package JobProvider_pageObjects;

import ReusabilityMethod.ReusableActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.Selenium_Base;

public class SignInAsJobProvider extends Selenium_Base {
    public SignInAsJobProvider() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h4[contains(text(),'Sign in')]")
    protected WebElement SignInJobProviderHeader;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement emailfield;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement passwordfield;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement signinbutton;


    public boolean VerifySignInJobProviderPage() {
        ReusableActions.HighlightingElement(SignInJobProviderHeader);
        boolean PageDisplayed_Status = SignInJobProviderHeader.isDisplayed();
        return true;
    }

    public SignInAsJobProvider EnterRegisteredEmailField(String email){
        ReusableActions.clickAndType(emailfield,email); //"lgstester50@gmail.com"
        return this;
    }

    public SignInAsJobProvider EnterPassword(String password){
        ReusableActions.clickAndType(passwordfield,password); //"Test123"
        return this;
    }

    public OTP_VerificationPage ClickSignInButton(){
        ReusableActions.click(signinbutton);
        return new OTP_VerificationPage();
    }



}
