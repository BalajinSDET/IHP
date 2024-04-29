package JobProvider_pageObjects;

import ReusabilityMethod.ReusableActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testBase.Selenium_Base;
import utilities.OtpReader;

public class OTP_VerificationPage extends Selenium_Base {

    public OTP_VerificationPage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = " //div[contains(text(),'OTP Verification')]")
    public WebElement verifyHeading;

    @FindBy(xpath = "//input[@value='email']")
    public WebElement emailRBtn;

    @FindBy(xpath = "//button[contains (text(),'Submit')]")
    public WebElement submitBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/div[1]")
    public WebElement ClickOTPfield;

    @FindBy(xpath = "//input[@placeholder='Enter OTP']")
    public WebElement enterOTP;

    @FindBy(xpath = "//h5[contains(text(),'Submit ')]")
    public WebElement VerifyOTPSubmitBtn;


    public void VerifyOTPHeading() {
        try {
            Thread.sleep(500);
            ReusableActions.HighlightingElement(verifyHeading);
            String ActualHeading = verifyHeading.getText();
            String ExpectedHeading = "OTP Verification";
            Assert.assertEquals(ActualHeading, ExpectedHeading);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickEmailRadioBtn() {
        ReusableActions.click(emailRBtn);
    }

    public void ClickSubmitBtn() {
        ReusableActions.click(submitBtn);
    }

    public void EnterOTP() {
        ReusableActions.HighlightingElement(enterOTP);
        String otp = OtpReader.getOtp();
        enterOTP.sendKeys(otp);
    }

    public void ClickVerifiedOtpSubmitBtn() {
        ReusableActions.click(VerifyOTPSubmitBtn);
    }
}