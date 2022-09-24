package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuTest {
    static WebDriver driver;


    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.manage().window().maximize();
    }
    @Test
    void rightClick(){
        Actions mouse = new Actions(driver);
        mouse
                .contextClick(driver.findElement(By.id("hot-spot")))
                .perform();
        driver.switchTo().alert().accept();
    }
}
