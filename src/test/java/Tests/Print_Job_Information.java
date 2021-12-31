package Tests;

import Data.ReadProperties;
import Pages.Careers_Page;
import Pages.Home_Page;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Print_Job_Information extends Test_Base{
    Home_Page homePageObject;
    Careers_Page careersPageObject;

    @Test
    @Severity(SeverityLevel.MINOR)
    public void Open_Careers_Page()  {


        homePageObject = new Home_Page(getDriver());
        homePageObject.Open_careers_page();
        careersPageObject = new Careers_Page(getDriver());
        careersPageObject.open_check_on_careers();
        Assert.assertEquals(getDriver().getCurrentUrl(), ReadProperties.userDate.getProperty("JoinUsUrl"));
        careersPageObject.select_Location(ReadProperties.userDate.getProperty("LocationNameSofia"));
        careersPageObject.jobsInCity();
        careersPageObject.select_Location(ReadProperties.userDate.getProperty("LocationNameSkopje"));
        careersPageObject.jobsInCity();
    }
}
