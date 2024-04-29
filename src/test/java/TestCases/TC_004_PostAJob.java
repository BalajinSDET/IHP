package TestCases;

import JobProvider_pageObjects.Job_Provider_HomePage;
import JobProvider_pageObjects.Post_A_Job_Page;
import JobProvider_pageObjects.SignInAsJobProvider;
import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.index_page;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.Selenium_Base;

public class TC_004_PostAJob extends Selenium_Base {

    @Test(groups = {"Smoke"}, priority = 1, alwaysRun = true)
    public void Validate_SignInAsJobProvider() { //String email, String password, String exp_result
        index_page ip = new index_page();
        ip.ClickLoginAsJobProvider();

        SignInAsJobProvider jp = new SignInAsJobProvider();
        jp.VerifySignInJobProviderPage();
        jp.EnterRegisteredEmailField(); //email
        jp.EnterPassword(); //password
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
        pjp.verifyPostAJobPage();
        pjp.enterJobId();
        pjp.clickOnJobCategoryDropDown();
        pjp.enterResponsibilities();
        pjp.enterjobTitle();
        pjp.clickOnWorkinghourDropDown();
        pjp.clickOnJobTypeDropDown();
        pjp.clickOnExperienceDropDown();
        pjp.clickOnAnnualSalaryDropDown();
        pjp.clickOnWorkSheduleDropDown();
        pjp.educationDropDown();
        pjp.clickOnmMinimumQualificationDropDown();
        pjp.selectCountry();
        pjp.selectState();
        pjp.selectCity();
        pjp.enterAddress();
        pjp.enterpreferedSkills();
        pjp.enterAboutTheJob();
        pjp.enterjobKeywords();
        pjp.selectContactOption();
        pjp.clickOnSubmitButton();

        pjp.jobPostedSuccessfullyPopupVisible();
        Assert.assertTrue( pjp.jobPostedSuccessfullyPopupVisible(),"Job posted not successfully completed");
    }

}
