package testCases;

import org.testng.annotations.Test;
import pageObjects.OTP_VerificationPage;
import pageObjects.SignInAsJobSeeker;
import pageObjects.index_page;
import testBase.BaseClass;

public class TC_EndToEnd_IHP_testcases extends BaseClass
{
	@Test(priority=1)
	public void validateIHPLogo() throws InterruptedException {
		index_page ip = new index_page(driver);
		ip.DisplayedPageTitle();
	}


	@Test(priority=2)
	public void ValidatePageTitle() throws InterruptedException {
		index_page ip = new index_page(driver);
		ip.ValidateLogo();

	}

	@Test(priority=3)
	public void Validate_SignINAsJobSeeker() {
		index_page ip = new index_page(driver);
		ip.ClickLoginAsJobSeeker();
		SignInAsJobSeeker js = new SignInAsJobSeeker(driver);
		js.ValidateSignInAsJobSeekerPage();
		js.SetRegisteredEmailId();
		js.SetPassword();
		js.ClickSignInButton();
		OTP_VerificationPage OTP =new OTP_VerificationPage(driver);
		OTP.VerifyOTPHeading();
		OTP.ClickEmailRadioBtn();
		OTP.ClickSubmitBtn();
		OTP.EnterOTP();
		OTP.ClickVerifiedOtpSubmitBtn();
	}

	/*
	 * @Test(groups= {"sanity","master"}) public void verify_login() {
	 * logger.info("**** Starting TC_002_LoginTest  ****");
	 * logger.debug("capturing application debug logs...."); try { //Home page
	 * HomePage hp=new HomePage(driver); hp.clickMyAccount();
	 * logger.info("clicked on myaccount link on the home page.."); hp.clickLogin();
	 * //Login link under MyAccount
	 * logger.info("clicked on login link under myaccount..");
	 * 
	 * //Login page LoginPage lp=new LoginPage(driver);
	 * logger.info("Entering valid email and password..");
	 * lp.setEmail(p.getProperty("email"));
	 * lp.setPassword(p.getProperty("password")); lp.clickLogin(); //Login button
	 * logger.info("clicked on ligin button..");
	 * 
	 * //My Account Page MyAccountPage macc=new MyAccountPage(driver);
	 * 
	 * boolean targetPage=macc.isMyAccountPageExists();
	 * 
	 * Assert.assertEquals(targetPage, true,"Login failed");
	 * 
	 * } catch(Exception e) { Assert.fail("An exception occurred: " +
	 * e.getMessage()); }
	 * 
	 * logger.info("**** Finished TC_002_LoginTest  ****"); }
	 */
}
