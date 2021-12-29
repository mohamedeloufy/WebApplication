package Tests;

import Data.ReadProperties;
import Pages.Company_Page;
import Pages.FaceBook_Page;
import Pages.Home_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Company_Test_Case extends Test_Base{
    Home_Page homePageObject;
    Company_Page companyPageObject;
    FaceBook_Page facebookPageObject;

    @Test
    public void VerifyCompanyPage()
    {
        homePageObject=new Home_Page(driver);
        homePageObject.Open_company_page();
        Assert.assertEquals(driver.getCurrentUrl(), ReadProperties.userDate.getProperty("CompanyUrl"));
    }
    @Test(dependsOnMethods = "VerifyCompanyPage")
    public void verifyLeaderShip()
    {
        companyPageObject=new Company_Page(driver);
        companyPageObject.viewLeaderShipSection();
        Assert.assertTrue(companyPageObject.LeadersShip_Section.isDisplayed());
    }
    @Test(dependsOnMethods = "verifyLeaderShip")
    public void openFaceBookPage() throws InterruptedException {
        companyPageObject=new Company_Page(driver);
        companyPageObject.OpenFaceBookTab();
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),ReadProperties.userDate.getProperty("FaceBookUrl"));
        facebookPageObject=new FaceBook_Page(driver);
        Assert.assertTrue(facebookPageObject.profilePicture.isDisplayed());
        driver.switchTo().window(tabs_windows.get(0));
        Thread.sleep(2000);



    }



}
