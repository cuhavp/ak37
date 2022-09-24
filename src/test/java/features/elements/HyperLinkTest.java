package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.StatusCodePage;
import supports.Browser;

public class HyperLinkTest {

    ChromeDriver driver;
    StatusCodePage statusCodePage;

    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }

    @BeforeMethod
    void openPage(){
        statusCodePage = new StatusCodePage();
        statusCodePage.open();
    }


    @DataProvider(name = "statusCode")
    Object[][] statusCode(){
        return new Object[][]{
                {"200"}  ,
                {"301"}  ,
                {"404"}  ,
                {"500"}
        };
    }

    @DataProvider(name = "statusCode1")
    Object[][] statusCode1(){
        return new Object[][]{
                {"200"}  ,
                {"301"}  ,
                {"404"}  ,
                {"500"}
        };
    }

    @Test(dataProvider = "statusCode",description = "")
    void verifyStatusPage(String status){
        statusCodePage.clickOnLink(status);
        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/"+status);
    }

    @AfterMethod
    void backToStatusPage(){
        Browser.getDriver().navigate().back();
    }

    @AfterClass
    void close(){
        Browser.quit();
    }
}
