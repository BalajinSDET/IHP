package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class SignInAsJobSeeker extends BasePage {

	public SignInAsJobSeeker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h4[contains(text(),'Sign in')]")
	protected WebElement SignInJobSeekerHeader;
	
	@FindBy(xpath="//input[@type='email']")
	protected WebElement emailfield;
	
	@FindBy(xpath="//input[@type='password']")
	protected WebElement passwordfield;
	
	@FindBy(xpath="//button[@type='submit']")
	protected WebElement signinbutton;
	
	public void ValidateSignInAsJobSeekerPage() {
		BaseClass.HighlightingElement(SignInJobSeekerHeader);
		SignInJobSeekerHeader.isDisplayed();
	}

	public void SetRegisteredEmailId() {
		BaseClass.HighlightingElement(emailfield);

		emailfield.sendKeys("lgstester50@gmail.com");
	}
	
	public void SetPassword() {
		BaseClass.HighlightingElement(passwordfield);
		passwordfield.sendKeys("Test123");
	}
	
	public void ClickSignInButton() {
		BaseClass.HighlightingElement(signinbutton);
		signinbutton.click();
	}
	
}
