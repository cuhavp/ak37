package pages;

import org.openqa.selenium.By;
import supports.Browser;

public class HomePage extends Browser {

    private By flashMessagesDiv = By.id("flash-messages");
    private By successMessageLabel = By.id("flash");



    public boolean isLoggedInSuccessMessageDisplayed() {
        return getElement(flashMessagesDiv).findElement(successMessageLabel).isDisplayed();
    }
}
