package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

public class CheckBoxPage extends Browser {

    private static final Logger logger = LogManager.getLogger(CheckBoxPage.class);

    private WebElement getCheckBoxElement(String checkbox ){
        logger.info("GET CHECKBOX "+checkbox);
        String checkBoxLocator =  String.format("//form[@id='checkboxes']/input[%s]",checkbox);
       return getElement(How.XPATH,checkBoxLocator);
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

       visit("https://the-internet.herokuapp.com/checkboxes");
    }
}
