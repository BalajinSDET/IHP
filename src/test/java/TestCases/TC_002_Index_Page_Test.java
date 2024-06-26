package TestCases;

import JobSeeker_pageObjects.index_page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.Selenium_Base;

public class TC_002_Index_Page_Test extends Selenium_Base {

    @BeforeTest
    public void setValues() {
        // These values are given for Extent report
      //  testCaseName = "IndexPageTest";
       // testDescription = "Index page test cases ";
    }

    @Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Sanity", "Regression", "Smoke"})
    public void ValidatePageTitle() {
        index_page ip = new index_page(); //node
        String act_title = ip.DisplayedPageTitle();
        Assert.assertEquals(act_title, "Home - IHP");
    }

    @Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Sanity", "Regression", "Smoke"})
    public void validateIHPLogo() {
        index_page ip = new index_page(); //node
        boolean logoDisplayedStatus = ip.ValidateLogo();
        Assert.assertTrue(logoDisplayedStatus);
    }

    @Test(priority = 3, alwaysRun = true, groups = {"Regression", "Smoke"})
    public void Validate_Global_Search_Test() {
        index_page ip = new index_page(); //node
        ip.EnterGlobalSearch();
        ip.ClickGlobalSearchButton();
        String Actual_Page = ip.GlobalSearchResultPage();
        Assert.assertEquals(Actual_Page, "Jobs - IHP");
    }
}
