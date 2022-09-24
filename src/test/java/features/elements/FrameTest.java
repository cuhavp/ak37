package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest {

    @Test
    void tc01(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
//        // origin session
        driver.switchTo().frame(0); // frame-top
        driver.switchTo().frame("frame-middle"); // frame-middle

        String content = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(content,"MIDDLE");

        driver.switchTo().parentFrame(); //   // origin session
        driver.switchTo().frame("frame-left");// frame-left
        content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"LEFT");

        driver.switchTo().parentFrame(); //   // origin session
        driver.switchTo().frame("frame-right");// frame-right
        content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"RIGHT");

        driver.switchTo().defaultContent(); //   // origin session
        driver.switchTo().frame("frame-bottom");// frame-top
        content = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(content,"BOTTOM");

        driver.quit();
    }
}
