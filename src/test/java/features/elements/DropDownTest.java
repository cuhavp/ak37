package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    @Test
    void verifySelectOption(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//        dropdown.selectByVisibleText("Option 1");
//        dropdown.selectByValue("1");
        dropdown.selectByIndex(1);
        /**
         * TagName = option
         * attr: value=1/selected=selected
         * text = Option 1
         */
//        WebElement option1 = driver.findElement(By.xpath("//option[@value='1']"));
//        WebElement option1 = driver.findElement(By.xpath("//option[@selected='selected']"));
//        WebElement option1 = driver.findElement(By.xpath("//option[text()='Option 1']"));
        WebElement option1 = driver.findElement(By.xpath("//option[.='Option 1']"));
        Assert.assertTrue(option1.isSelected());
        driver.quit();
    }
}
