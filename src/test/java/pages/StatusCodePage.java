package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class StatusCodePage extends Browser {

    public void open(){
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickOnLink(String linkText){
        click(By.linkText(linkText));
    }

    public void clickOnHereLink(){
       click(By.linkText("here"));
    }

}
