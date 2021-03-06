package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Home_Page extends Page_Base{
    public Home_Page(WebDriver driver) {
        super(driver);
        jes=(JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//*[@class='nav']/li/a[@class='main-link']")
    public List<WebElement> listOfElements;

    @FindBy(css = "button.contact-label.btn.btn-1b")
    WebElement contact_us;

    @FindBy(id = "cf-1")
    public WebElement nameTextBox;

    @FindBy(id = "cf-2")
    public WebElement emailTextBox;

    @FindBy(id = "cf-3")
    public WebElement mobileTextBox;

    @FindBy(id = "cf-4")
    public WebElement subjectTextBox;

    @FindBy(id = "cf-5")
    public WebElement messageTextBox;


    @FindBy(css = "input.wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
    public WebElement sendButton;

    @FindBy(className = "wpcf7-not-valid-tip")
    public WebElement errorMessage;

    @FindBy(id = "fancybox-close")
    public WebElement close_contact_us;

    public void EnterDataToContactUs(String name ,String email,String mobileNumber,String subject,String Message)
    {

        writeData(nameTextBox,name);
        writeData(emailTextBox,email);
        writeData(mobileTextBox,mobileNumber);
        writeData(subjectTextBox,subject);
        writeData(messageTextBox,Message);
        clickOn(sendButton);
    }



    public void Open_contact_Us_Form()
    {
        scrollToBottom();
        clickOn(contact_us);
    }

    public void Open_company_page()
    {
        for (WebElement element:listOfElements)
        {
            if (element.getText().equalsIgnoreCase("company"))
            {
                clickOn(element);
                break;
            }
        }
    }
    public void close_contact_us()
    {
        clickOn(close_contact_us);
        scrollToUP();
    }

    public void Open_careers_page()
    {
        for (WebElement element:listOfElements)
        {
            if (element.getText().equalsIgnoreCase("careers"))
            {
                clickOn(element);
                break;
            }
        }
    }
}
