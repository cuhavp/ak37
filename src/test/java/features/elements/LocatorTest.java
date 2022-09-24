package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.com");

/**
 * 1 tagName:input
 * 2. attrs
 *      name: q
 *      title: "Tìm kiếm"
 *      aria-label:"Search"
 * 3. text: N/A
 */
        driver.findElement(By.name("q")).sendKeys("selenium webdriver");
//        driver.quit();
    }
}
