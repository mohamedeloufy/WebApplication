package Tests;

import Data.ReadProperties;
import Pages.Home_Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Contact_Us_Test_Case extends Test_Base {


    Home_Page homepageObject;

   /*
     Annotation @DataProvider used to run the same test case multiple time with different data ,
     get the data from properties file and put it the array object by using
     ReadProperties.properties file name.getProperty(name of the value)
    */
    @DataProvider(name = "userDataCredentials")
    public static Object[][] userData() {
        return new Object[][]
                {
                        {ReadProperties.userDate.getProperty("Name"),ReadProperties.userDate.getProperty("FirstEmail"),ReadProperties.userDate.getProperty("Mobile"),ReadProperties.userDate.getProperty("Subject"),ReadProperties.userDate.getProperty("Message")},
                        {ReadProperties.userDate.getProperty("Name"),ReadProperties.userDate.getProperty("SecondEmail"),ReadProperties.userDate.getProperty("Mobile"),ReadProperties.userDate.getProperty("Subject"),ReadProperties.userDate.getProperty("Message")},
                        {ReadProperties.userDate.getProperty("Name"),ReadProperties.userDate.getProperty("ThirdEmail"),ReadProperties.userDate.getProperty("Mobile"),ReadProperties.userDate.getProperty("Subject"),ReadProperties.userDate.getProperty("Message")},
                        {ReadProperties.userDate.getProperty("Name"),ReadProperties.userDate.getProperty("FourthEmail"),ReadProperties.userDate.getProperty("Mobile"),ReadProperties.userDate.getProperty("Subject"),ReadProperties.userDate.getProperty("Message")},
                        {ReadProperties.userDate.getProperty("Name"),ReadProperties.userDate.getProperty("FifthEmail"),ReadProperties.userDate.getProperty("Mobile"),ReadProperties.userDate.getProperty("Subject"),ReadProperties.userDate.getProperty("Message")}
                };
    }


    // this Method to open_contact_us
    @Test
    public void open_contact_us_form()
   {
        homepageObject = new Home_Page(getDriver());
        homepageObject.Open_contact_Us_Form();
    }






    // this test run 5 times by using parameter data provider
    @Test(dependsOnMethods = "open_contact_us_form",dataProvider = "userDataCredentials")
    public void contact_us_credentials(String name,String email,String mobile,String subject,String message) throws InterruptedException {
        homepageObject = new Home_Page(getDriver());
        homepageObject.EnterDataToContactUs(name,email,mobile,subject,message);
        Thread.sleep(5000);
        Assert.assertTrue(homepageObject.errorMessage.isDisplayed());
        Assert.assertEquals(homepageObject.errorMessage.getText(),ReadProperties.userDate.getProperty("EmailErrorMessage"));



    }

    // this method to close contact us
    @Test(dependsOnMethods = "contact_us_credentials")
    public void close_form()
    {
        homepageObject=new Home_Page(getDriver());
        homepageObject.close_contact_us();
    }
}
