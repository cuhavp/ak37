package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class HomePage extends Browser {

    private By flashMessagesDiv = By.id("flash-messages");
    private By successMessageLabel = By.id("flash");



    public boolean isLoggedInSuccessMessageDisplayed() {
        return driver
                .findElement(flashMessagesDiv).findElement(successMessageLabel).isDisplayed();
    }
}
