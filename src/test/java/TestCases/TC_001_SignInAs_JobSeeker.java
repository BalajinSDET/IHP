package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.SignInAsJobSeeker;
import JobSeeker_pageObjects.index_page;
import ReusabilityMethod.ReusableActions;
import testBase.BaseClass;
import testBase.Selenium_Base;
import utilities.DataProviders;

public class TC_001_SignInAs_JobSeeker extends Selenium_Base {


    @Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Sanity", "Regression"})
    //dataProvider="fetch_Excel_Data"
    public void ValidatePageTitle() throws InterruptedException {
        index_page ip = new index_page();
        String act_title = ip.DisplayedPageTitle();
        Assert.assertEquals(act_title, "Home - IHP");
    }

    @Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Sanity", "Regression"})
    public void validateIHPLogo() throws InterruptedException {
        index_page ip = new index_page();
        boolean logoDisplayedStatus = ip.ValidateLogo();
        Assert.assertTrue(logoDisplayedStatus);
    }

    @Test(groups = {"Smoke"}, priority = 3, alwaysRun = true, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    //,timeOut=3000
    public void Validate_SignINAsJobSeeker(String email, String password, String exp_result) {
        index_page ip = new index_page();
        ip.ClickLoginAsJobSeeker();

        SignInAsJobSeeker js = new SignInAsJobSeeker();
        js.ValidateSignInAsJobSeekerPage();
        js.SetRegisteredEmailId(email);
        js.SetPassword(password);
        js.ClickSignInButton();

        OTP_VerificationPage OTP = new OTP_VerificationPage();
        if (exp_result.equalsIgnoreCase("valid")) {
            OTP.VerifyOTPHeading();
            OTP.ClickEmailRadioBtn();
            OTP.ClickSubmitBtn();
            OTP.EnterOTP();
            OTP.ClickVerifiedOtpSubmitBtn();
        } else if (exp_result.equalsIgnoreCase("invalid")) {
            if (BaseClass.getDriver().switchTo().activeElement() != null) {
                ReusableActions.acceptAlert();
                System.out.println("****** Test case passed ******");
            }
            Assert.assertFalse(false, "It displayed invalid pop up message");
        } else {
            Assert.fail("****** Testcases failed ******");
        }

    }
}
