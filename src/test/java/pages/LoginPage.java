package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class LoginPage extends Browser {

    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.tagName("button");


    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }
    public void submitCredentials(String user, String pass){
        fill(username,user);
        fill(password,pass);
        click(submit);

    }
}
