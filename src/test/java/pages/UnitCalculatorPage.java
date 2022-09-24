package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class UnitCalculatorPage extends Browser {
    private By resultLabel = By.className("bigtext");
    private By clearButton = By.className("clearbtn");
    private By ageTextBox = By.id("cage");
    private By maleCheckBox = By.xpath("//label[normalize-space()='Male']");
    private By femaleCheckBox = By.xpath("//label[normalize-space()='Female']");
    private By heightTextBox = By.id("cheightmeter");
    private By weightTextBox = By.id("ckg");
    private By calculateButton = By.xpath("//input[@value='Calculate']");
    private By metricUnitTab = By.xpath("//a[normalize-space()='Metric Units']");


    public String getResult() {
        return driver.findElement(resultLabel).getText();
    }

    public void cleanUpForm(){
        driver.findElement(clearButton).click();
    }

    public void fillForm(String age, String gender, String height, String weight) {
        driver.findElement(ageTextBox).sendKeys(age);
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleCheckBox).click();
        } else driver.findElement(femaleCheckBox).click();

        driver.findElement(heightTextBox).sendKeys(height);
        driver.findElement(weightTextBox).sendKeys(weight);

        driver.findElement(calculateButton).click();
    }

    public void selectMetricUnit() {
        driver.findElement(metricUnitTab).click();
    }
}
