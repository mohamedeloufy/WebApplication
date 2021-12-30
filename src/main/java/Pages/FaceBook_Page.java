package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaceBook_Page extends Page_Base{
    public FaceBook_Page(WebDriver driver) {
        super(driver);
        jes=(JavascriptExecutor) driver;

    }


    @FindBy(xpath = "//div[@id='entity_sidebar'] /div/div/div/div/a/div/img")
    public WebElement profilePicture;
}
