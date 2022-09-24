package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.tagName("button");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/login");
    }
    public void submitCredentials(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }
}
