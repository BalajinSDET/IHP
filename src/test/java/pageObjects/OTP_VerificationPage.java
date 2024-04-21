package pageObjects;

import utilities.OtpReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class OTP_VerificationPage extends BasePage {

    public OTP_VerificationPage(WebDriver driver) {
        super(driver);
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
            BaseClass.HighlightingElement(verifyHeading);
            String ActualHeading = verifyHeading.getText();
            String ExpectedHeading = "OTP Verification";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClickEmailRadioBtn() {
        BaseClass.HighlightingElement(emailRBtn);
        BaseClass.explicitWait(emailRBtn);
        emailRBtn.click();
    }

    public void ClickSubmitBtn() {
        BaseClass.HighlightingElement(submitBtn);
        BaseClass.explicitWait(submitBtn);
        submitBtn.click();
    }

    public void EnterOTP() {
        BaseClass.HighlightingElement(enterOTP);
        String otp = OtpReader.getOtp();
        enterOTP.sendKeys(otp);
    }

    public void ClickVerifiedOtpSubmitBtn() {
        BaseClass.HighlightingElement(VerifyOTPSubmitBtn);
        VerifyOTPSubmitBtn.click();
    }
}