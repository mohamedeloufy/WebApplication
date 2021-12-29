package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Careers_Page extends Page_Base{
    public Careers_Page(WebDriver driver) {
        super(driver);
        jes=(JavascriptExecutor) driver;
    }

    @FindBy(css = "button.contact-label.contact-label-code.btn.btn-1b")
    public WebElement Check_our_open_positions;

    @FindBy(id = "get_location")
    public  WebElement locationMenu;

    ////article//div//a//div//div//h2


    @FindBy(xpath = "//article//div//a//div//div//h2")
    public List<WebElement> jobsName;




    public void open_check_on_careers()
    {
        clickOn(Check_our_open_positions);
    }

    public void select_Location(String value)
    {
        select =new Select(locationMenu);
        select.selectByValue(value);

    }

    public void Select_Job_By_Name(String value)
    {
        scrollToBottom();
        for (WebElement element:jobsName)
        {
            if (element.getText().equalsIgnoreCase(value))
            {
                clickOn(element);
                break;
            }
        }
    }


}
