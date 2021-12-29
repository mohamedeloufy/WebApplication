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

    // fe issue fel inspect bta3 el image
    @FindBy(xpath = "//div[@id='u_0_d_/R']//div/div/div/a")
    public WebElement profilePicture;
}
