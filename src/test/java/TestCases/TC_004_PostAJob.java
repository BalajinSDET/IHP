package TestCases;

import JobProvider_pageObjects.Job_Provider_HomePage;
import JobProvider_pageObjects.Post_A_Job_Page;
import JobProvider_pageObjects.SignInAsJobProvider;
import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.index_page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.Selenium_Base;
import utilities.DataProviders;

import java.io.IOException;

public class TC_004_PostAJob extends Selenium_Base {
    public String dataSheetName;

    @BeforeTest
    public void setValues() {
        dataSheetName = "TC_003_JP_PostAJob";
    }

    @DataProvider(name = "fetch_Excel_Data")
    public Object[][] fetchData() throws IOException {
        return DataProviders.readExcelData(dataSheetName);
    }

    @Test(dataProvider = "fetch_Excel_Data", groups = {"Smoke"}, priority = 1)
//alwaysRun = true, enabled = true //dataProvider = "LoginData", dataProviderClass = DataProviders.class
    public void Validate_SignInAsJobProvider_PostAJob(String email, String password, String Job_Id, String Job_Category, String Responsibilities, String Job_Title, String Experience, String Work_Schedule,
                                                      String Minimum_Qualification, String Full_Address, String Preferred_Skills, String Trending_Keyword, String About, String exp_result) {
        index_page ip = new index_page();
        ip.ClickLoginAsJobProvider();

        SignInAsJobProvider jp = new SignInAsJobProvider();
        jp.VerifySignInJobProviderPage();
        jp.EnterRegisteredEmailField(email);
        jp.EnterPassword(password);
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
        JPHP.clickOnPostAJobCArd();

        if (exp_result.equalsIgnoreCase("valid")) {
            Post_A_Job_Page pjp = new Post_A_Job_Page();
            pjp.verifyPostAJobPage();
            pjp.enterJobId(Job_Id);
            pjp.clickOnJobCategoryDropDown(Job_Category);
            pjp.enterResponsibilities(Responsibilities);
            pjp.enterjobTitle(Job_Title);
            pjp.clickOnWorkinghourDropDown();
            pjp.clickOnJobTypeDropDown();
            pjp.clickOnExperienceDropDown(Experience);
            pjp.clickOnAnnualSalaryDropDown();
            pjp.clickOnWorkSheduleDropDown(Work_Schedule);
            pjp.educationDropDown();
            pjp.clickOnmMinimumQualificationDropDown(Minimum_Qualification);
            pjp.selectCountry();
            pjp.selectState();
            pjp.selectCity();
            pjp.enterAddress(Full_Address);
            pjp.enterpreferedSkills(Preferred_Skills);
            pjp.enterAboutTheJob(About);
            pjp.enterjobKeywords(Trending_Keyword);
            pjp.selectContactOption();
            pjp.clickOnSubmitButton();

            pjp.jobPostedSuccessfullyPopupVisible();
            Assert.assertTrue(pjp.jobPostedSuccessfullyPopupVisible(), "Job posted not successfully completed");
        } else {
            Assert.fail();
        }

    }

    @Test(groups = {"Smoke"}, priority = 2, alwaysRun = false)
    public void Verify_ValidationMessages_IsDisplayed(String email, String password) {
        index_page ip = new index_page(); //node
        ip.ClickLoginAsJobProvider();

        SignInAsJobProvider jp = new SignInAsJobProvider();
        jp.VerifySignInJobProviderPage();
        jp.EnterRegisteredEmailField("lgstester50@gmail.com"); //email
        jp.EnterPassword("Test123"); //password
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
        JPHP.clickOnPostAJobCArd();

        Post_A_Job_Page pjp = new Post_A_Job_Page();
        pjp.clickOnSubmitButton();
        Assert.assertEquals(pjp.Verify_PostAJobPage_ValidationMessage(), "Required");
        // Assert.assertEquals(pjp.ValidationMessage(text),"Only alphanumeric characters are allowed");

    }


}
