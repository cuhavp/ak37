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
import supports.Browser;

public class LoginTest {

    LoginPage loginPage;
    String USER_NAME = "tomsmith";
    String PASSWORD = "SuperSecretPassword!";

    @BeforeClass
    public static void setUp() {
        Browser.openBrowser("chrome");
    }

    @BeforeMethod
    void openLoginPage(){
        loginPage = new LoginPage();
        loginPage.open();
    }

    @Test
    void withValidCredentials(){
        loginPage.submitCredentials(USER_NAME,PASSWORD);
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isLoggedInSuccessMessageDisplayed());
        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test
    void withInvalidCredentials(){
        loginPage.submitCredentials("tomsmith","SuperSecretPassword");
        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }

    @AfterClass
    void closeBrowser() {
        Browser.quit();
    }
}
