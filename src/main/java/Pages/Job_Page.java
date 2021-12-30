package Pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;



import java.util.List;

public class Job_Page extends Page_Base{
    public Job_Page(WebDriver driver) {
        super(driver);
        jes=(JavascriptExecutor) driver;

    }




    @FindBy(xpath = "//div[@class='entry-content']/div[@class='joinus-content']//div//div[@class='content-title']//h2")
    public List<WebElement> mainSections;



    @FindBy(xpath = "//a/input")
    public WebElement apply_Button;

    @FindBy(id = "cf-1")
    public WebElement nameTextBox;

    @FindBy(id = "cf-2")
    public WebElement emailTextBox;

    @FindBy(id = "cf-3")
    public WebElement mobileTextBox;

    @FindBy(id = "cf-4")
    public WebElement fileUploader;

    @FindBy(id = "cf-5")
    public WebElement linkedInUrl;

    @FindBy(id = "cf-6")
    public  WebElement message;

    @FindBy(css = "input.wpcf7-form-control.has-spinner.wpcf7-submit.btn-cf-submit")
    public WebElement sendButton;

    @FindBy(className = "wpcf7-not-valid-tip")
    public WebElement emailErrorMessage;









    public void EnterDataToApplyForm(String name ,String email,String mobileNumber,String linkedin,String Message) throws InterruptedException {

        writeData(nameTextBox,name);
        writeData(emailTextBox,email);
        writeData(mobileTextBox,mobileNumber);
        upload();
        writeData(linkedInUrl,linkedin);
        writeData(message,Message);
        scrollToBottom();
        Thread.sleep(3000);
        clickOn(sendButton);
    }


    // upload file
    public void upload()
    {
        String cv="mohamed.pdf";
        String cv_Path=System.getProperty("user.dir")+"/uploads/"+cv;
        fileUploader.sendKeys(cv_Path);
    }










    public void check_main_four_sections()
    {

        for (WebElement element:mainSections)
        {
            element.isDisplayed();
        }

    }

    public void open_Apply_Form()
    {

        jes.executeScript("arguments[0].click()",apply_Button);
        //clickOn(apply_Button);
    }
}
