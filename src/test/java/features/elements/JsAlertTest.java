package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsAlertTest {

    static WebDriver driver;


    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

    @Test
    void clickForJsAlert() {
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");

    }

    @Test
    void jsConfirmOK() {
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Ok");
    }

    @Test
    void jsConfirmCancel() {
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    void jsPrompt() {
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: Hello");
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }


}
