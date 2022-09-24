package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.StatusCodePage;

public class HyperLinkTest {

    ChromeDriver driver;
    StatusCodePage statusCodePage;

    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    void openPage(){
        statusCodePage = new StatusCodePage(driver);
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/"+status);
    }

    @AfterMethod
    void backToStatusPage(){
        driver.navigate().back();
    }

    @AfterClass
    void close(){
        driver.quit();
    }
}
