package JobProvider_pageObjects;

import ReusabilityMethod.ReusableActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.Selenium_Base;

import java.util.List;

public class Post_A_Job_Page extends Selenium_Base {
    public Post_A_Job_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder=\"Job Id \"]")
    WebElement jobIdPlaceholder;

    @FindBy(xpath = "//input[@placeholder=\"Responsibilities \"]")
    WebElement responsibilitiesTextBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div/div/div/form/div[1]/div[1]/div[1]/div/div/div[4]/div/div/input")
    WebElement jobTitleTextBox;

    @FindBy(xpath = "//textarea[@placeholder=\"Preferred Skills\"]")
    WebElement prefferedSkillsTxtBox;

    @FindBy(xpath = "//textarea[@placeholder=\"About This Job\"]")
    WebElement aboutThisJobTextBox;

    @FindBy(xpath = "//input[@placeholder=\"Job Keywords\"]")
    WebElement jobKeywordsTxtBox;

    @FindBy(xpath = "//input[@placeholder=\"Full Address\"]")
    WebElement fullAddressTxtBox;

    @FindBy(xpath = "//select[@placeholder=\"job_category*\"]")
    WebElement jobCategoryDropDown;

    @FindBy(xpath = "//span[contains(text(),'Required')]")
    List<WebElement> ValidationMessage;

    @FindBy(xpath = "//span[contains(text(),'Only alphanumeric characters are allowed')]")
    WebElement jobIdValidationMessage;

    @FindBy(xpath = "//div[contains(text(),'Posted Jobs')]")
    WebElement postedJobsCard;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div/div/div/form/div[1]/div[1]/div[1]/div/div/div[5]/div/div/select")
    WebElement selectHourDropDown;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div/form/div/div/div/form/div[1]/div[1]/div[1]/div/div/div[6]/div/div/select")
    WebElement jobTypeDropDown;

    @FindBy(xpath = "//select[@placeholder=\"Select Experience \"]")
    WebElement experienceDropDown;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div/div/div/form/div[1]/div[1]/div[1]/div/div/div[8]/div/div/select")
    WebElement salaryDropDown;

    @FindBy(xpath = "//select[@placeholder=\"Minimum Qualifications\"]")
    WebElement minimumQualificationDropDown;

    @FindBy(xpath = "//select[@placeholder=\"Select Education\"]")
    WebElement selectEducationDropDown;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div/div/div/form/div[1]/div[1]/div[1]/div/div/div[9]/div/div/select")
    WebElement workShceduleDropDown;

    @FindBy(xpath = "//select[@placeholder=\"country\"]")
    WebElement countryDropDown;

    @FindBy(xpath = "//select[@placeholder=\"state\"]")
    WebElement stateDropDown;

    @FindBy(xpath = "//select[@placeholder=\"city\"]")
    WebElement cityDropDown;

    @FindBy(xpath = "//select[@placeholder=\"contact_option\"]")
    WebElement contactOption;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div/div/div/form/button")
    WebElement submitBtn;

    @FindBy(xpath = "//div[contains(text(),'Your Job is Successfully Posted')]")
    WebElement jobPostedSuccessfullytxt;

    @FindBy(xpath = "(//div[@class='text-center marg']/following-sibling::div)[1]")
    public WebElement JobIDText;

    @FindBy(xpath = "//button[normalize-space()='View Job']")
    public WebElement viewjobbutton;

    @FindBy(xpath = "//h5[normalize-space()='Job Overview']")
    public WebElement JobOverviewPage;

    @FindBy(xpath = "//h5[contains(text(),'Posted Jobs')]")
    public WebElement PostedJobs;

    @FindBy(xpath = "(//div[contains(text(),'Home')])[2]")
    public WebElement HomeMenu;

    @FindBy(xpath = "(//div[contains(text(),'Posted Jobs')])[1]")
    public WebElement PostedJobsTile;

    @FindBy(xpath = "//div[@class='pl-5 pr-5 align-self-center  media-body']")
    public List<WebElement> ListOfPostedJobs;

    @FindBy(xpath = "//span[@class='text-danger']")
    public List<WebElement> ListOfValidationText;

    @FindBy(xpath = "//label[@class='text-left width100 font18']")
    public List<WebElement> ListOfLabels;

    @FindBy(xpath = "//*[@placeholder]")
    public List<WebElement> ListOfPlaceHolders;

    @FindBy(xpath = "//h5[contains(text(),'Post a Job')]")
    WebElement postAJobText;

    public boolean verifyPostAJobPage() {
        System.out.println("The Title of post a new job page is : " + getDriver().getTitle());
        ReusableActions.HighlightingElement(postAJobText);
        if (postAJobText.isDisplayed()) {
            System.out.println("Verifying the post a job page is landed status is : " + postAJobText.isDisplayed());
        }
        return true;
    }

    public String enterJobId(String Job_Id) { //String Job_Id
       String Val_Msg="";
        ReusableActions.clickAndType(jobIdPlaceholder, Job_Id);//"ST_001_ATE"
        if(jobIdValidationMessage.isDisplayed()){
        Val_Msg= jobIdValidationMessage.getText();
        }return Val_Msg;
    }

    public void enterjobTitle(String Job_Title) { //String Job_Title
        ReusableActions.clickAndType(jobTitleTextBox,Job_Title ); //"Software Test Engineer"
    }

    public void enterpreferedSkills(String Preferred_Skills) { //String Preferred_Skills
        ReusableActions.clickAndType(prefferedSkillsTxtBox,Preferred_Skills ); //"Automation, Selenium with Core Java, Cucumber BDD"
    }

    public void enterjobKeywords(String Trending_Keyword) { //String Trending_Keyword
        ReusableActions.clickAndType(jobKeywordsTxtBox,Trending_Keyword ); //"Test Engineer, Automation Tester, SDET"
    }

    public void enterAddress(String Full_Address) { //String Full_Address
        ReusableActions.clickAndType(fullAddressTxtBox,Full_Address ); //"Tidel park coimbatore"
    }

    public void enterResponsibilities(String Responsibilities) { //String Responsibilities
        ReusableActions.clickAndType(responsibilitiesTextBox,Responsibilities ); //"To deliver the Quality software to the client"
    }

    public void enterAboutTheJob(String About) { //String About
        ReusableActions.clickAndType(aboutThisJobTextBox, About); //"Software Testing which is part of software development process"
    }

    public void clickOnWorkinghourDropDown() { //String Working_Hours
        ReusableActions.DropDown(selectHourDropDown, "8", "VisibleText");
    }


    public void clickOnJobTypeDropDown() { //String Job_Type
        ReusableActions.DropDown(jobTypeDropDown, "Full Time", "VisibleText");
    }

    public void clickOnExperienceDropDown(String Experience) { //String Experience
        ReusableActions.DropDown(experienceDropDown,Experience , "VisibleText"); //"3-5 years Experience"
    }

    public void clickOnAnnualSalaryDropDown() { //String Annual_Salary
        ReusableActions.DropDown(salaryDropDown, "5L-10L", "VisibleText");
    }

    public void clickOnWorkSheduleDropDown(String Work_Schedule) { //String Work_Schedule
        ReusableActions.DropDown(workShceduleDropDown, Work_Schedule, "VisibleText"); //"Morning/Day/Night Shift"
    }

    public void clickOnmMinimumQualificationDropDown(String Minimum_Qualification) { //String Minimum_Qualification
        ReusableActions.DropDown(minimumQualificationDropDown, Minimum_Qualification, "VisibleText");//"B.E/B.Tech"
    }

    public void educationDropDown() { //String Education
        ReusableActions.DropDown(selectEducationDropDown, "B.E/B.Tech", "VisibleText");
    }

    public void selectState() { //String State
        ReusableActions.DropDown(stateDropDown, "Tamil Nadu---TN", "VisibleText");
    }

    public void selectCountry() { //String Country
        ReusableActions.DropDown(countryDropDown, "India---IN", "VisibleText");
    }

    public void selectCity() { //String City
        ReusableActions.DropDown(cityDropDown, "Alanganallur", "VisibleText");
    }

    public void selectContactOption() { //String Contact_Option
        ReusableActions.DropDown(contactOption, "Email/Call", "VisibleText");
    }

    public void clickOnSubmitButton() {
        System.out.println("Verifying the submit button is present status is : " + submitBtn.isDisplayed());
        ReusableActions.click(submitBtn);
    }

    public boolean jobPostedSuccessfullyPopupVisible() {
        ReusableActions.DelayWithGivenTime(3000);
        getDriver().switchTo().activeElement();
        ReusableActions.HighlightingElement(jobPostedSuccessfullytxt);
        jobPostedSuccessfullytxt.isDisplayed();

        String jobidtext = JobIDText.getText();
        System.out.println(jobidtext);
        return true;
    }

    public void clickOnJobCategoryDropDown(String Job_Category) { //String Job_Category
        ReusableActions.DropDown(jobCategoryDropDown,Job_Category , "VisibleText");//Information Technology"
    }

    public void clickOnPostedJobCard() {
        ReusableActions.click(postedJobsCard);
    }

    public void ClickPostedJob() {
        ReusableActions.click(PostedJobs);
    }

    public void ClickHomeMenu() {
        ReusableActions.click(HomeMenu);
    }

    public void ClickPostedJobs() {
        ReusableActions.click(PostedJobsTile);
    }

    public void VerifyNewJobPosted() {
        for (int i = 0; i < ListOfPostedJobs.size(); i++) {
            String New_Job = ListOfPostedJobs.get(0).getText();
            System.out.println("Posted New Job is :" + Keys.ENTER + New_Job);
            break;
        }
    }

    public void VerifyValidationMessage() {
        for (int i = 0; i < ListOfValidationText.size(); i++) {
            for (int j = 0; j < ListOfLabels.size(); j++) {
                ReusableActions.HighlightingElement(ListOfValidationText.get(i));
                ReusableActions.HighlightingElement(ListOfLabels.get(j));
                System.out.println("Displayed validation message of " + ListOfLabels.get(j).getText() + " field :" + ListOfValidationText.get(i).getText());
                break;
            }
        }
    }

    public void VerifyPlaceHolders() {
        for (int i = 0; i < ListOfPlaceHolders.size(); i++) {
            for (int j = 0; j < ListOfLabels.size(); j++) {
                String Placeholders = ListOfPlaceHolders.get(i).getAttribute("placeholder");
                String LabelName = ListOfLabels.get(j).getText();
                System.out.println("Placeholder present in the fields are : " + Placeholders);
                //  System.out.println(" "+LabelName + ":" + Placeholders);
                break;
            }
        }
    }

    public String ValidationMessage(String text) {
        String validation_message = "";
        switch (text) {
            case "job id":
                jobIdPlaceholder.sendKeys("TFYTFFHKGLGLJJK_jkNJK_kjj");
                jobCategoryDropDown.click();
                validation_message = jobIdValidationMessage.getText();
                //  ReusableActions.HighlightingElement(validation_message);
                System.out.println(validation_message);
                break;
            case "responsibilities":
                responsibilitiesTextBox.sendKeys("Test Web application");
                jobCategoryDropDown.click();
                validation_message = jobIdValidationMessage.getText();
                //  ReusableActions.HighlightingElement(validation_message);
                System.out.println(validation_message);
                break;
        }
        return validation_message;
    }

    public String Verify_PostAJobPage_ValidationMessage() {
        String validation = "";

        for(int i=0;i<ValidationMessage.size();i++){
            validation=ValidationMessage.get(i).getText();
            ReusableActions.HighlightingElement(ValidationMessage.get(i));
            System.out.println(validation);
        }
        return validation;
    }

}
