package JobProvider_pageObjects;

import ReusabilityMethod.ReusableActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.Selenium_Base;

import java.util.List;

public class Job_Provider_HomePage extends Selenium_Base {

    public Job_Provider_HomePage() {
        PageFactory.initElements(getDriver(),this);
    }


    @FindBy(xpath = "//div[contains(text(),'Home')]")
    WebElement homeTab;

    @FindBy(xpath = "//div[contains(text(),'Dashboard')]")
    WebElement dasboardTab;

    @FindBy(xpath = "//div[contains(text(),'Jobs')]")
    List<WebElement> jobsTab;

    @FindBy(xpath = "//a[contains(@href,'/JobPost')]//div[contains(@class,'text-center')][normalize-space()='Jobs']")
    public WebElement JobsMenu;

    @FindBy(xpath = "//div[contains(text(),'Search Resumes')]")
    WebElement searchResumesTab;

    @FindBy(xpath = "//img[@alt='logo']")
    WebElement humanPowerLogo;

    @FindBy(xpath = "//li[@class='paddingLeft575 dropdown forSameRow marg nav-item']//div//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement starIcon;

    @FindBy(xpath = "//div[2]//div[1]//nav[1]//ul[1]//li[10]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement mailIcon;

    @FindBy(xpath = "(//*[name()='svg'][@class='svg-inline--fa fa-comment-dots fa-w-16 iconColor'])[1]")
    WebElement chatIcon;

    @FindBy(xpath = "//li[@class='bellIconLeft dropdown forSameRow marg nav-item']//div//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement notificationIcon;

    @FindBy(xpath = "//img[@alt=\"user profile\"]")
    WebElement userProfileIcon;

    @FindBy(xpath = "//h3[contains(text(),'Features')]")
    WebElement featureTxt;

    @FindBy(xpath = "//div[contains(text(),'Post a New Job')]")
    WebElement postAJobCard;

    @FindBy(xpath = "//div[contains(text(),'Posted Jobs')]")
    WebElement postedJobsCard;

    @FindBy(xpath = "//div[contains(text(),'Saved Search')]")
    WebElement savedSearchCard;

    @FindBy(xpath = "//div[contains(text(),'Search by Keywords')]")
    WebElement searchByKeywordsCard;

    @FindBy(xpath = "//div[contains(text(),'Bulk Resume Download')]")
    WebElement bulkResumeDownloadCard;

    @FindBy(xpath = "//div[contains(text(),'Chat & Email')]")
    WebElement chatEmailCard;

    @FindBy(xpath = "//h3[contains(text(),'Favourite Links')]")
    WebElement favouriteLinkTxt;

    @FindBy(xpath = "//div[contains(text(),'Add Shortcut Link')]")
    WebElement addIcon;

    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    WebElement namePlaceholder;

    @FindBy(xpath = "//input[@placeholder=\"Link\"]")
    WebElement linkTextBox;

    @FindBy(xpath = "//button[contains(text(),\"Save\")]")
    WebElement saveButton;

    @FindBy(xpath = "//body/div[@id='root']/div[@class='animate fadeIn']/div[@class='fullBackground row']/div[@class='col-12 col-sm-12 col-md-12 col-lg-12']/div[@class=' jobPaddingHome margBottom40 row']/div[@class='forSameRow ']/div[@class='cardTransition hoverr width130']/div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement cancelSymbol;

    @FindBy(xpath = "//h3[contains(text(),'Posted Job Categories')]")
    WebElement postedJobCategoriesText;

    @FindBy(xpath = "//div[contains(text(),'Design, Art & Multimedia')]")
    WebElement designArtMultimediaCard;

    @FindBy(xpath = "//div[contains(text(),'Accounting / Finance')]")
    WebElement accountingFinanceCard;

    @FindBy(xpath = "//div[contains(text(),'Human Resource')]")
    WebElement humanResourceCard;

    @FindBy(xpath = "//div[contains(text(),'Telecommunication')]")
    WebElement telecommunicationCard;

    @FindBy(xpath = "//div[contains(text(),'Restaurant / Food Services')]")
    WebElement restaurantFoodServicesCard;

    @FindBy(xpath = "//div[contains(text(),'Construction and facilities')]")
    WebElement constructionAndFacilitiesCard;

    @FindBy(xpath = "//h3[contains(text(),'Recently Posted Jobs')]")
    WebElement recentlyPostedJobsSection;

    @FindBy(xpath = "//h3[contains(text(),'Featured Candidates')]")
    WebElement featuredCandidatesText;

    @FindBy(xpath = "//div[contains(text(),'Google')]")
    WebElement googleFavouriteLink;

    @FindBy(xpath = "//h5[contains(text(),'Post a Job')]")
    WebElement postAJobText;

    @FindBy(xpath = "//h5[contains(text(),'Posted Jobs')]")
    WebElement postedJobText;

    @FindBy(xpath = "//h5[contains(text(),'Saved Search')]")
    WebElement savedSearchText;

    @FindBy(xpath = "//div[contains(text(),'Bulk Resume Download')]")
    WebElement bulkResumeDownloadText;

    @FindBy(xpath = "//div[contains(text(),'Chat')]")
    WebElement chatText;

    @FindBy(xpath = "//div[@class='greyHeight row']//div[3]//div[1]")
    public WebElement mailsubmenu;

    @FindBy(xpath = "//h5[contains(text(),'Search Resume')]")
    public WebElement searchResumeTxt;

    @FindBy(xpath = "//h5[contains(text(),'Saved Search')]")
    WebElement savedSearchTxt;

    @FindBy(xpath = "(//h5[contains(text(),'Profile Details')])[1]")
    WebElement profileDetailsTxt;

    @FindBy(xpath = "(//a[contains(text(),'Subscription')])[1]")
    WebElement subscriptionLabel;

    @FindBy(xpath = "//h3[contains(text(),'Featured Candidates')]")
    WebElement featuredCandidatesSection;

    @FindBy(xpath = "//h3[contains(text(),'Featured Candidates')]//following ::button")
    List<WebElement> viewDetailsSectionInFeaturedSection;

    @FindBy(xpath = "//h5[contains(text(),'Profile Overview')]")
    WebElement profileOverviewPage;
    @FindBy(xpath = "//img[@class='headerProfileImageSize media-object']")
    public WebElement profileIcon;

    @FindBy(xpath = "//a[contains(@class,'active')]")
    public WebElement logout;

    @FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='View Details'])")
    List<WebElement> ViewDetailsList;

    @FindBy(xpath = "//div[@class='font12 marg5 text-center lightGray']")
    List<WebElement> ListOfCreatedJob;



    public void ClickIHPLOGO() {
        ReusableActions.click(humanPowerLogo);
    }

    public void ClickPostedJobsTile() {
        ReusableActions.click(postedJobsCard);
    }

    public void ClickJobsMenu() {
        ReusableActions.click(JobsMenu);
    }

    public void ClickMailSubmenu() {
        ReusableActions.click(mailsubmenu);
    }

    public void ClickMailInboxIcon() {
        ReusableActions.click(mailIcon);
    }

    public void ClickChatandMail() {
        ReusableActions.click(chatEmailCard);
    }


    public String VerifyJobProviderHomePage(){
        String Act_Page = getDriver().getTitle();
        return Act_Page;
    }


    public Post_A_Job_Page clickOnPostAJobCArd() {
        ReusableActions.click(postAJobCard);
        return new Post_A_Job_Page();
    }

    public void clickOnSavedSearchCard() {
        ReusableActions.click(savedSearchCard);
    }



    public void GetJobCreatedDate() throws InterruptedException {
        String Exp_CreatedDate = "Created on: 09 Feb 2024";
        String listCreatedDate = ListOfCreatedJob.get(0).getText();
        Thread.sleep(3000);
        if (listCreatedDate.equalsIgnoreCase(Exp_CreatedDate)) {
            Thread.sleep(3000);
            ViewDetailsList.get(0).click();
        } else {
            System.out.println("View button not interactable");
        }
    }
    public void verifyFeaturedCandidateSection() {
        featuredCandidatesSection.isDisplayed();
    }

    public void clickOnViewDetailsButtonInLatestJobSection() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < viewDetailsSectionInFeaturedSection.size(); i++) {
            ReusableActions.HighlightingElement(viewDetailsSectionInFeaturedSection.get(i));
            if (viewDetailsSectionInFeaturedSection.get(i).isDisplayed()) {
                viewDetailsSectionInFeaturedSection.get(i).click();
                break;
            }
        }
    }



}