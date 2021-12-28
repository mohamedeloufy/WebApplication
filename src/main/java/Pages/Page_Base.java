package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class Page_Base {
    protected WebDriver driver;
    public JavascriptExecutor jes;

    public Select select;

    public Page_Base(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    // Method : click on any element
    public static void clickOn(WebElement button)
    {
        button.click();
    }

    // Method : write data on text box
    public static void writeData(WebElement element, String value)
    {
        element.sendKeys(value);
    }

    // Method : scroll to the bottom of the screen
    public void scrollToBottom()
    {
        jes.executeScript("scrollBy(0,2500)");
    }

    //Method : scroll to the top of the screen
    public void scrollToUP()
    {
        jes.executeScript("scrollBy(2500,0)");
    }

    // Method : check the exist of the element
    public boolean isElementExist(WebElement we)
    {
        try
        {
            we.isDisplayed();
            return true;
        }catch(NoSuchElementException e)
        {
            return false;
        }
    }


}
