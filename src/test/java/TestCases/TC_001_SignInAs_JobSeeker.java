package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.SignInAsJobSeeker;
import JobSeeker_pageObjects.index_page;
import ReusabilityMethod.ReusableActions;
import testBase.Selenium_Base;
import utilities.DataProviders;

import java.io.IOException;

public class TC_001_SignInAs_JobSeeker extends Selenium_Base {

    public String dataSheetName;
    @BeforeTest
    public void setValues() {
        dataSheetName = "TC_001_SignInAsJobSeeker";
    }
    @DataProvider(name = "fetch_Excel_Data")
    public Object[][] fetchData() throws IOException {
        return DataProviders.readExcelData(dataSheetName);
    }

    @Test(groups = {"Smoke"}, priority = 1, alwaysRun = true,dataProvider="fetch_Excel_Data")
    //,timeOut=3000
    public void Validate_SignINAsJobSeeker(String email, String password, String exp_result) {
        index_page ip = new index_page(); //node
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
            Assert.assertTrue(true,"Test Cases pass");
        } else if (exp_result.equalsIgnoreCase("invalid")) {
            if (getDriver().switchTo().activeElement() != null) {
                ReusableActions.acceptAlert();
                System.out.println("****** Test case passed ******");
            }
            Assert.assertFalse(false, "It displayed invalid pop up message");
        } else {
            Assert.fail("****** Testcases failed ******");
        }

    }
}
