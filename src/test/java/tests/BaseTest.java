package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.RegisterPage;
import utils.AllureUtils;

import static com.codeborne.selenide.Selenide.open;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    RegisterPage registerPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = Browsers.CHROME;
        } else if (browser.equalsIgnoreCase("edge")) {
            Configuration.browser = Browsers.EDGE;
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = Browsers.FIREFOX;
        }
        Configuration.timeout = 10000;
        open("https://log.finalsurge.com/register.cshtml");
        registerPage = new RegisterPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
    }
}