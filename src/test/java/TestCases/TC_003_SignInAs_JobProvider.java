package TestCases;

import JobProvider_pageObjects.Job_Provider_HomePage;
import JobProvider_pageObjects.SignInAsJobProvider;
import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.SignInAsJobSeeker;
import JobSeeker_pageObjects.index_page;
import ReusabilityMethod.ReusableActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.BaseClass;
import testBase.Selenium_Base;
import utilities.DataProviders;

import java.io.IOException;

public class TC_003_SignInAs_JobProvider extends Selenium_Base {
    public String dataSheetName;
    public  String browserName;
    @BeforeTest
    public void setValues() {
       // browserName = "Chrome";
        dataSheetName = "TC_002_SignInAsJobProvider";
    }

    @DataProvider(name = "fetch_Excel_Data")
    public Object[][] fetchData() throws IOException {
        return DataProviders.readExcelData(dataSheetName);
    }
//dataProvider="fetch_Excel_Data"

    @Test(groups = {"Smoke"}, priority = 1, alwaysRun = true)
    //dataProvider = "LoginData", dataProviderClass = DataProviders.class
    public void Validate_SignInAsJobProvider(String email, String password) { //String email, String password, String exp_result
        index_page ip = new index_page(); //node
        ip.ClickLoginAsJobProvider();

        SignInAsJobProvider jp = new SignInAsJobProvider();
        jp.VerifySignInJobProviderPage();
        jp.EnterRegisteredEmailField(email); //email
        jp.EnterPassword(password); //password
        jp.ClickSignInButton();

        OTP_VerificationPage OTP = new OTP_VerificationPage();
        OTP.VerifyOTPHeading();
        OTP.ClickEmailRadioBtn();
        OTP.ClickSubmitBtn();
        OTP.EnterOTP();
        OTP.ClickVerifiedOtpSubmitBtn();
        Assert.assertTrue(true, "Test Cases pass");
        Job_Provider_HomePage JPHP = new Job_Provider_HomePage();
        Assert.assertEquals(JPHP.VerifyJobProviderHomePage(), "Home - IHP");
    }

}





