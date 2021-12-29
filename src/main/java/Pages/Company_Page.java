package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Company_Page extends Page_Base{
    public Company_Page(WebDriver driver) {
        super(driver);
        jes=(JavascriptExecutor) driver;
    }

    @FindBy(className = "company-members")
    public WebElement LeadersShip_Section;

    @FindBy(xpath = "//div[@class='links-buttons']/a/span[@class='musala musala-icon-facebook']")
    public  WebElement facebookIcon;





    public void OpenFaceBookTab()
    {
        clickOn(facebookIcon);
    }

    public void viewLeaderShipSection()
    {
        scrollToBottom();
    }
}
