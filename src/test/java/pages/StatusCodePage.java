package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodePage {
    WebDriver driver;

    public StatusCodePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickOnLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickOnHereLink(){
        driver.findElement(By.linkText("here")).click();
    }

}
