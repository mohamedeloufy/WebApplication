package Tests;

import Data.ReadProperties;
import Pages.Careers_Page;
import Pages.Home_Page;
import Pages.Job_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Careers_Test_Case extends Test_Base{

    Home_Page homePageObject;
    Careers_Page careersPageObject;
    Job_Page jobPageObject;



    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case is used to test the apply scenario ")
    public void Open_Careers_Page() throws InterruptedException {
        homePageObject = new Home_Page(getDriver());
        homePageObject.Open_careers_page();
        careersPageObject = new Careers_Page(getDriver());
        careersPageObject.open_check_on_careers();
        Assert.assertEquals(getDriver().getCurrentUrl(), ReadProperties.userDate.getProperty("JoinUsUrl"));
        careersPageObject.select_Location(ReadProperties.userDate.getProperty("LocationName"));
        careersPageObject.Select_Job_By_Name(ReadProperties.userDate.getProperty("JobName"));
        jobPageObject=new Job_Page(getDriver());
        jobPageObject.check_main_four_sections();
        Assert.assertEquals(jobPageObject.mainSections.size(),4);
        Assert.assertTrue(jobPageObject.apply_Button.isDisplayed());
        jobPageObject.open_Apply_Form();
        Thread.sleep(3000);
        jobPageObject.EnterDataToApplyForm(ReadProperties.userDate.getProperty("EmptyName"),
                ReadProperties.userDate.getProperty("InvalidEmailFormat"),
                ReadProperties.userDate.getProperty("Mobile"),
                ReadProperties.userDate.getProperty("LinkedInProfile"),
                ReadProperties.userDate.getProperty("Message"));
        Assert.assertTrue(jobPageObject.emailErrorMessage.isDisplayed());


    }







}
