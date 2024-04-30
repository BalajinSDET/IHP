package StepDefinition;

import JobSeeker_pageObjects.OTP_VerificationPage;
import JobSeeker_pageObjects.SignInAsJobSeeker;
import JobSeeker_pageObjects.index_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ReusabilityMethod.ReusableActions.node;

public class JobSeeker_SignIn_Steps {

    index_page ip = new index_page(); //node
    SignInAsJobSeeker sijs = new SignInAsJobSeeker();
    OTP_VerificationPage otp= new OTP_VerificationPage();
    @Given("User is enter the Ihp website URL")
    public void userIsEnterTheIhpWebsiteURL() {
        System.out.println("Browser launched");
     //   ip.ValidateLogo();
    }

    @When("the user click on login as job seeker at index page")
    public void theUserClickOnLoginAsJobSeekerAtIndexPage() {
        ip.ClickLoginAsJobSeeker();
    }

    @Then("User should navigated to the sign in page")
    public void userShouldNavigatedToTheSignInPage() {
        sijs.ValidateSignInAsJobSeekerPage();
    }

    @And("The user enter their Email Id as {string} and Password as {string}")
    public void theUserEnterTheirEmailIdAsAndPasswordAs(String email, String password) {
        sijs.SetRegisteredEmailId(email);
        sijs.SetPassword(password);
    }

    @When("User clicks on the sign in button")
    public void userClicksOnTheSignInButton() {
        sijs.ClickSignInButton();
    }

    @And("User should navigated to the KYC Verification")
    public void userShouldNavigatedToTheKYCVerification() {
    }

    @And("User clicks the email verification radio button and then user clicks the submit button")
    public void userClicksTheEmailVerificationRadioButtonAndThenUserClicksTheSubmitButton() {
        otp.ClickEmailRadioBtn();
        otp.ClickSubmitBtn();
        otp.EnterOTP();
        otp.ClickVerifiedOtpSubmitBtn();
    }

    @Then("User navigates to the dashboard page of the Ihp project successfully")
    public void userNavigatesToTheDashboardPageOfTheIhpProjectSuccessfully() {
    }

    @And("User validate the keep me sign in to this device checkbox and Click the checkbox")
    public void userValidateTheKeepMeSignInToThisDeviceCheckboxAndClickTheCheckbox() {
    }

    @And("User clicks the profile icon on job seeker dashboard page")
    public void userClicksTheProfileIconOnJobSeekerDashboardPage() {
    }

    @When("the user clicks logout button on job seeker and user should navigated to the homepage of the Ihp application")
    public void theUserClicksLogoutButtonOnJobSeekerAndUserShouldNavigatedToTheHomepageOfTheIhpApplication() {
    }

    @When("The user should able to click on the Login as Job Seeker button in the HomePage")
    public void theUserShouldAbleToClickOnTheLoginAsJobSeekerButtonInTheHomePage() {
    }

    @And("User validate the keep me sign in to this device checkbox")
    public void userValidateTheKeepMeSignInToThisDeviceCheckbox() {
    }
}
