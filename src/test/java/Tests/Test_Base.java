package Tests;


import Utilities.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.ITestResult;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class Test_Base {

    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser","url"})
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Automation Task", url = "http://www.musala.com/")
    public void startDriver(@Optional("chrome") String browserName,String url) {
        if (browserName.equalsIgnoreCase("chrome")) {

            // 0pen driver by using webDriver manager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();


        } else if (browserName.equalsIgnoreCase("chrome-headless")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920,1080");
            driver = new ChromeDriver(options);
        }



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to(url);


    }

    @AfterMethod
    public void screenshotFailure(ITestResult results) {
        if (results.getStatus() == ITestResult.FAILURE) {
            System.out.println("fail......!");
            System.out.println("taking screenshot........");
            Helper.captureScreenshotOnFailure(driver, results.getName());
        }

    }

    @AfterTest
    @Severity(SeverityLevel.MINOR)
    public void closeDriver() {
        driver.quit();

    }









}
