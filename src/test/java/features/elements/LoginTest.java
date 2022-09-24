package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

    static WebDriver driver;
    LoginPage loginPage;
    String USER_NAME = "tomsmith";
    String PASSWORD = "SuperSecretPassword!";

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void openLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    void withValidCredentials(){
        loginPage.submitCredentials(USER_NAME,PASSWORD);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoggedInSuccessMessageDisplayed());
        Assert.assertEquals(homePage.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test
    void withInvalidCredentials(){
        loginPage.submitCredentials("tomsmith","SuperSecretPassword");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }

    @AfterClass
    void closeBrowser() {
        driver.quit();
    }
}
