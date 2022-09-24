package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import supports.Browser;

public class CheckboxTest {

    CheckBoxPage checkboxPage;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @BeforeMethod
    void initCheckBoxPage(){
        checkboxPage = new CheckBoxPage();
        checkboxPage.open();
    }

    @Test
    void checkInCheckbox(){
        checkboxPage.check("1");
        Assert.assertTrue(checkboxPage.isCheckBoxChecked("1"));

        checkboxPage.check("2");
        Assert.assertTrue(checkboxPage.isCheckBoxChecked("2"));

    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
