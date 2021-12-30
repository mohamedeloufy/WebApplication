package Tests;

import Data.ReadProperties;
import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Company_Test_Case extends Test_Base{
    Home_Page homePageObject;
    Company_Page companyPageObject;
    FaceBook_Page facebookPageObject;


    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void VerifyCompanyTest() throws InterruptedException {
        homePageObject=new Home_Page(driver);
        homePageObject.Open_company_page();
        Thread.sleep(2000);
        System.out.print(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), ReadProperties.userDate.getProperty("CompanyUrl"));
        companyPageObject=new Company_Page(driver);
        companyPageObject.viewLeaderShipSection();
        Assert.assertTrue(companyPageObject.LeadersShip_Section.isDisplayed());
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
