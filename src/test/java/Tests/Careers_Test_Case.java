package Tests;

import Data.ReadProperties;
import Pages.Careers_Page;
import Pages.Home_Page;
import Pages.Job_Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Careers_Test_Case extends Test_Base{

    Home_Page homePageObject;
    Careers_Page careersPageObject;
    Job_Page jobPageObject;



    @Test
    public void Open_Careers_Page() {
        homePageObject = new Home_Page(driver);
        homePageObject.Open_careers_page();
        careersPageObject = new Careers_Page(driver);
        careersPageObject.open_check_on_careers();
        Assert.assertEquals(driver.getCurrentUrl(), ReadProperties.userDate.getProperty("JoinUsUrl"));
        careersPageObject.select_Location(ReadProperties.userDate.getProperty("LocationName"));
        careersPageObject.Select_Job_By_Name(ReadProperties.userDate.getProperty("JobName"));
        jobPageObject=new Job_Page(driver);
        jobPageObject.check_main_four_sections();
        Assert.assertEquals(jobPageObject.mainSections.size(),4);
        Assert.assertTrue(jobPageObject.apply_Button.isDisplayed());
        jobPageObject.open_Apply_Form();


    }

    @DataProvider(name = "userDataCredentials2")
    public static Object[][] userData2() {
        return new Object[][]
                {
                        {"","hello@go","1223444","linkedinLink","message"}
                };
    }
    @Test(dependsOnMethods = "Open_Careers_Page",dataProvider = "userDataCredentials2")
    public void Apply(String name,String email,String mobile,String linkedin,String message) throws InterruptedException {
        jobPageObject=new Job_Page(driver);
        jobPageObject.EnterDataToApplyForm(name,email,mobile,linkedin,message);
        Thread.sleep(5000);

    }


}
