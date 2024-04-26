package JobSeeker_pageObjects;

import ReusabilityMethod.ReusableActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.Selenium_Base;

import java.util.List;

public class Job_Seeker_Home_Page extends Selenium_Base {
    public Job_Seeker_Home_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    String location;
    @FindBy(xpath = "//input[@placeholder=\'Search Keywords\']")
    WebElement searchByKeywordlabel;

    @FindBy(xpath = "//input[@placeholder=\"Search by Location\"]")
    WebElement searchByLocationTxtBox;

    @FindBy(xpath = "//input[@placeholder=\"Search Keywords\"]")
    WebElement SearchByLocationlabel;

    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/div/div/div[1]/div[2]/div/div[2]/button ")
    WebElement searchbtn;

    @FindBy(xpath = "//li[1]//a[1]//div[1]")
    WebElement homeMenuVerification;

    @FindBy(xpath = "//div[contains(text(),'Developer')]")
    WebElement searchKeyword;

    @FindBy(xpath = "//input[@placeholder=\"Keyword e.g. (Job Title, Description, Tags)\"]")
    WebElement actualResult;

    @FindBy(xpath = "(//div[contains(text(),'Search Job')])[2]")
    WebElement searchJobCard;

    @FindBy(xpath = "//h3[contains(text(),'Features')]")
    WebElement featureTxt;

    @FindBy(xpath = "//div[contains(text(),'Preferred Job')]")
    WebElement preferredJobCard;

    @FindBy(xpath = "//h5[contains(text(),'Preferred Jobs')]")
    WebElement preferredJobTxt;

    @FindBy(xpath = "//div[contains(text(),'Saved Jobs')]")
    WebElement savedJobCard;

    @FindBy(xpath = "//h5[contains(text(),'Applied Jobs')]")
    WebElement appliedJobTxt;

    @FindBy(xpath = "//h3[contains(text(),'Favourite Links')]")
    WebElement favouriteLinkTxt;

    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    WebElement namePlaceholder;

    @FindBy(xpath = "//input[@placeholder=\"Link\"]")
    WebElement linkTextBox;

    @FindBy(xpath = "//button[contains(text(),\"Save\")]")
    WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Add Shortcut Link')]")
    WebElement addIcon;

    @FindBy(xpath = "(//*[name()='path'][@fill='currentColor'])[9]")
    WebElement cancelSymbol;

    @FindBy(xpath = "//div[contains(text(),'Google')]")
    WebElement googleFavouriteLink;

    @FindBy(xpath = "//h3[contains(text(),'Recent Jobs')]")
    WebElement recentJobTxt;

    @FindBy(xpath = "//button[contains(text(),'View Details')]")
    List<WebElement> viewDetailsBtn;

    @FindBy(xpath = "//h5[contains(text(),'Job Overview')]")
    WebElement jobOverview;

    @FindBy(xpath = "//h3[contains(text(),'Jobs by Location')]")
    WebElement jobsByLocationTxt;

    @FindBy(xpath = "//div[5]//div[1]//ul[1]//li[2]//div[1]//div[3]//div[1]//button[1]")
    List<WebElement> viewDetailsBtnInJobsByLocation;

    @FindBy(xpath = "(//img[@src='/static/media/humanLogo.98dd5966.png'])[1]")
    WebElement iHumanPowerLogo;

    @FindBy(xpath = "(//div[contains(text(),'Home')])[1]")
    WebElement homeTab;

    @FindBy(xpath = "(//div[contains(text(),'Dashboard')])[1]")
    WebElement dashboardTab;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/div/div[2]/div/nav/ul/li[7]/a/div")
    WebElement jobsTab;

    @FindBy(xpath = "(//div[contains(text(),'Search Jobs')])[1]")
    WebElement searchJobsTab;

    @FindBy(xpath = "//li[@class='paddingLeft575 dropdown forSameRow marg nav-item']//div//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement starIcon;

    @FindBy(xpath = "//div[2]//div[1]//nav[1]//ul[1]//li[10]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement mailIcon;

    @FindBy(xpath = "//div[2]//div[1]//nav[1]//ul[1]//li[11]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement chatIcon;

    @FindBy(xpath = "//li[@class='bellIconLeft dropdown forSameRow marg nav-item']//div//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement notificationIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/div/div[3]/div/div[1]/button/div/a/img")
    WebElement userProfileIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/div/div[3]/div/div[1]/div/div[1]/div[1]/div/img")
    WebElement userProfileIconDropbox;

    @FindBy(xpath = "//a[contains(text(),'Profile Setting')]")
    WebElement profileSettingLbl;

    @FindBy(xpath = "//h5[contains(text(),'en')]")
    WebElement languageSection;

    @FindBy(xpath = "//h5[contains(text(),'ta')]")
    WebElement tamilDropDown;

    @FindBy(xpath = "//button[contains(text(),' Tamil ')]")
    WebElement tamilLanguageTxt;

    @FindBy(xpath = "//div[contains(text(),'வேலைகளைத் தேடுங்கள்')]")
    WebElement tamilTxt;

    @FindBy(xpath = "//button[contains(text(),'English')]")
    WebElement englishTxt;

    @FindBy(xpath = "//h3[contains(text(),'Recently Posted Jobs')]")
    WebElement recentlyPostedJobsSection;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div/form/div/div/div[2]/div/input")
    WebElement locationTxt;
    @FindBy(xpath = "(//img[@alt='logo'])[1]")
    public WebElement IHPLogo;

    @FindBy(xpath = "//*[@class='font19 marg25 text-center fontweight600 black' and contains(text(),'Search Job')]")
    public WebElement SearchjobTile;


    @FindBy(xpath = "(//div[contains(@class,'marg25 homeBox borderRadiusBottom thinBorderRed width94 cardTransition threed')])[5]")
    public WebElement interviewInvites;

    @FindBy(xpath = "//img[@alt='user profile1']")
    public WebElement profileicon;

    @FindBy(xpath = "//a[contains(text(),'Profile Setting')]")
    public WebElement profilesetting;

    @FindBy(xpath = "//a[normalize-space()='KYC Verification']")
    public WebElement KYCVerification;

    @FindBy(xpath = "//a[contains(@class,'active')]")
    public WebElement Logout;

    @FindBy(xpath = "//div[text()='Posted Jobs']")
    public WebElement postedjobstile;

    @FindBy(xpath = "//div[contains(text(),'Saved Jobs')]")
    public WebElement savedjobstile;

    @FindBy(xpath = "//div[@class = 'font12 marg5 text-center lightGray']")
    List<WebElement> ListOfCreatedDate;

    @FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='View Details'])")
    List<WebElement> ViewDetailsList;

    @FindBy(xpath = "//h3[contains(text(),'Features')]")
    public WebElement FeaturesSection;

    public boolean IsJobSeekerDashboardPageDisplayed() {
        ReusableActions.HighlightingElement(FeaturesSection);
        boolean Act_Status = FeaturesSection.isDisplayed();
        return true;
    }

    public void SearchByKeywordlabel(String searchKeyword) throws InterruptedException {
        Thread.sleep(5000);
        if (searchKeyword.equals("Keyword")) {
            searchByKeywordlabel.click();
            searchByKeywordlabel.sendKeys("developer");
        } else {
            searchByLocationTxtBox.click();
            searchByLocationTxtBox.click();
            ReusableActions.HighlightingElement(searchByLocationTxtBox);

            Thread.sleep(3000);
            searchByLocationTxtBox.sendKeys("Pune");
            location = searchByLocationTxtBox.getText();
        }
    }

    public void SearchButton() {
        searchbtn.click();
    }

    public String verifyHomeMenuPage() throws InterruptedException {
        Thread.sleep(2000);
        homeMenuVerification.getText();
        return homeMenuVerification.getText();
    }

    public boolean verifySearchKeyword() throws InterruptedException {
        Thread.sleep(3000);
        String searchKeyword1 = searchKeyword.getText();
        String searchKeyword2 = actualResult.getText();
        boolean result;
        if (searchKeyword1.equals(searchKeyword2)) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public void clickOnSearchJobCard() {
        searchJobCard.click();
    }

    public void verifyFeatureTxt() {
        featureTxt.isDisplayed();
    }

    public void clickOnPreferredJobCard() {
        preferredJobCard.click();
    }

    public void VerifyPreferredJobPage() {
        preferredJobTxt.isDisplayed();
    }

    public void clickOnSavedJobCard() {
        savedJobCard.click();
    }

    public void SearchByKeywordlabel() {
        searchByKeywordlabel.click();
        searchByKeywordlabel.sendKeys("developer");
    }

    public void verifyAppliedJobPage() {
        appliedJobTxt.isDisplayed();
    }

    public void clickOnFavouriteLinkSection() throws InterruptedException {
        if (cancelSymbol.isDisplayed()) {
            cancelSymbol.click();
        }
        favouriteLinkTxt.isDisplayed();
        Thread.sleep(3000);
        addIcon.isDisplayed();
        addIcon.click();
    }

    public void enterTheNameInNameTextBox() {
        // ReusableActions.windowHandle();
        namePlaceholder.sendKeys("Google");
    }

    public void enterLinkInLinkTextBox() {
        linkTextBox.sendKeys("https://www.google.com/");
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public boolean verifyFavouriteLinkIsGettingAdded() throws InterruptedException {
        Thread.sleep(1000);
        getDriver().switchTo().alert().accept();
        googleFavouriteLink.isDisplayed();
        googleFavouriteLink.click();
        return true;
    }

    public boolean verifyRecentJobSection() {
        recentJobTxt.isDisplayed();
        return true;

    }

    public void clickOnViewDetailsSection() {
        for (int i = 0; i < viewDetailsBtn.size(); i++) {
            if (viewDetailsBtn.get(i).isDisplayed()) {
                viewDetailsBtn.get(i).click();
                break;
            }
        }
    }

    public boolean verifyJobOverviewPage() throws InterruptedException {
        Thread.sleep(2000);
        jobOverview.isDisplayed();
        return true;
    }

    public void verifyJobByLocationSection() {
        jobsByLocationTxt.isDisplayed();
    }

    public void clickOnViewDetailsButtonInLatestJobSection() {
        for (int i = 0; i < viewDetailsBtnInJobsByLocation.size(); i++) {
            ReusableActions.HighlightingElement(viewDetailsBtnInJobsByLocation.get(i));
            if (viewDetailsBtnInJobsByLocation.get(i).isDisplayed()) {
                viewDetailsBtnInJobsByLocation.get(i).click();
                break;
            }
        }
    }

    public void verifyIHumanPowerLogo() {
        iHumanPowerLogo.isDisplayed();
    }

    public void verifyHomeTab() {
        homeTab.isDisplayed();
    }

    public void verifyDashboardTab() {
        dashboardTab.isDisplayed();
    }

    public void verifyJobTab() throws InterruptedException {
        jobsTab.isDisplayed();
        Thread.sleep(1000);
        jobsTab.click();
    }

    public void verifySearchJobsTab() {
        searchJobsTab.isDisplayed();
        searchJobsTab.click();
    }

    public void clickOnSaveIcon() {
        starIcon.click();
    }

    public void clickOnMailIcon() {
        mailIcon.click();
    }

    public void clickOnChatIcon() {
        chatIcon.click();
    }

    public void clickOnNotificationIcon() {
        notificationIcon.click();
    }

    public void verifyProfileIcon() {
        userProfileIcon.isDisplayed();
    }

    public void clickOnProfileIcon() {
        userProfileIcon.click();
    }

    public void verifyProfileIconDropBox() {
        userProfileIconDropbox.isDisplayed();
    }

    public void clickOnProfileSettingLabel() {
        profileSettingLbl.click();
    }

    public void clickOnLanguageSection() {
        try {
            languageSection.click();
        } catch (Exception e) {
            tamilDropDown.click();
        }
    }

    public void clickOnLanguage(String languageOption) {
        if (languageOption.equals("Tamil")) {
            tamilLanguageTxt.click();
        } else {
            englishTxt.click();
        }
    }

    public void verifyTamilScreen() {
        tamilTxt.isDisplayed();
    }

    public void verifyEnglishScreen() {
        homeTab.isDisplayed();
    }

    public void verifyRecentlyPostedJobSection() {
        recentlyPostedJobsSection.isDisplayed();
    }

    public boolean verifySearchByLocation() {
        String searchKeyword3 = actualResult.getText();
        if (location.equals(searchKeyword3)) {
            System.out.println(location);
            return true;
        }
        return false;
    }


    public void ClickSearchJobTile() {
        ReusableActions.HighlightingElement(SearchjobTile);
        SearchjobTile.click();
    }

    public void ClickInterviewInvites() {
        ReusableActions.click(interviewInvites);
    }

    public void ClickProfileIcon() {
        ReusableActions.click(profileicon);
    }

    public void ClickProfileSetting() throws InterruptedException {
        Thread.sleep(2000);
        ReusableActions.click(profilesetting);
    }

    public void ClickKycVerification() {
        ReusableActions.click(KYCVerification);
    }

    public void ClickLogout() {
        ReusableActions.click(Logout);
    }

    public void ClickIHPLOGO() {
        ReusableActions.click(IHPLogo);
    }

    public void ClickPostedJobsTile() {
        ReusableActions.click(postedjobstile);
    }

    public void ClickSavedJobs() {
        ReusableActions.click(savedjobstile);
    }

    public void VerifyRecentJobsSection() {
        boolean recentJobs = recentJobTxt.isDisplayed();
        ReusableActions.HighlightingElement(recentJobTxt);
        System.out.println("Recent Jobs status is :" + recentJobs);
    }

    public void GetJobCreatedDate() {

        String Exp_CreatedDate = "Created on: 05 July 2021";

        String listCreatedDate = ListOfCreatedDate.get(0).getText();
        System.out.println(listCreatedDate);

        if (listCreatedDate.equalsIgnoreCase(Exp_CreatedDate)) {
            ViewDetailsList.get(0).click();
        } else {
            System.out.println("View button not interactable");
        }
    }

    public void ClickNotificationIcon() {
        ReusableActions.click(notificationIcon);
    }

}