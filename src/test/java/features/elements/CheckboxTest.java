package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckboxTest {

    static WebDriver driver;
    CheckBoxPage checkboxPage;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void initCheckBoxpage(){
        checkboxPage = new CheckBoxPage(driver);
        checkboxPage.open();
    }
    @Test
    void checkInCheckbox(){
        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isCheckBoxChecked("1"));

        checkboxPage.check("2");
        Assert.assertTrue(checkboxPage.isCheckBoxChecked("2"));

    }
}
