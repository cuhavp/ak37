package pages;

import org.openqa.selenium.By;
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
        return getText(resultLabel);
    }

    public void cleanUpForm(){
        click(clearButton);
    }

    public void fillForm(String age, String gender, String height, String weight) {
        fill(ageTextBox,age);
        if (gender.equalsIgnoreCase("male")) {
            click(maleCheckBox);
        } else click(femaleCheckBox);

        fill(heightTextBox,height);
        fill(weightTextBox,weight);
        click(calculateButton);

    }

    public void selectMetricUnit() {
        click(metricUnitTab);
    }
}
