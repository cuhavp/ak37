package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    private By flashMessagesDiv = By.id("flash-messages");
    private By successMessageLabel = By.id("flash");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public boolean isLoggedInSuccessMessageDisplayed() {
        return driver
                .findElement(flashMessagesDiv).findElement(successMessageLabel).isDisplayed();
    }
}
