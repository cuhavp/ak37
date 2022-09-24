package pages;

import features.elements.SeleniumTakeScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {
    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger logger = LogManager.getLogger(CheckBoxPage.class);


    private WebElement getCheckBoxElement(String checkbox ){
        logger.info("GET CHECKBOX "+checkbox);
        String checkBoxLocator =  String.format("//form[@id='checkboxes']/input[%s]",checkbox);
       return driver.findElement(By.xpath(checkBoxLocator));
    }

    public void check(String checkbox){
        if (!getCheckBoxElement(checkbox).isSelected()){
            getCheckBoxElement(checkbox).click();
        }
    }

    public boolean isCheckBoxChecked(String checkbox){
        return getCheckBoxElement(checkbox).isSelected();
    }


    public void open(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
}
