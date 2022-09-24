package features.bmi;

import features.bmi.models.BMITestModel;
import features.elements.SeleniumTakeScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.UnitCalculatorPage;
import supports.Browser;

public class UnitCalculatorTest {
    private static final Logger logger = LogManager.getLogger(UnitCalculatorTest.class);

    UnitCalculatorPage unitCalculatorPage;

    @Parameters({"browser","url"})
    @BeforeClass
     public void setUp(String browser,String url) {
       Browser.openBrowser(browser,true);
        Browser.visit(url);
        unitCalculatorPage = new UnitCalculatorPage();
        unitCalculatorPage.selectMetricUnit();
        logger.info(String.format("START TEST .... on %s and %s ",browser,url));
    }

    @BeforeMethod
    public void selectUnit() {
        unitCalculatorPage.cleanUpForm();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]
                {
                        {new BMITestModel("25", "male", "180", "65", "BMI = 20.1 kg/m2(Normal)")},

                };
    }

    @Test(dataProvider = "testData")
    public void bmiTest(BMITestModel bmiTestModel) {
        unitCalculatorPage.fillForm(bmiTestModel.getAge(),
                bmiTestModel.getGender(),
                bmiTestModel.getHeight(),
                bmiTestModel.getWeight());
        String result = unitCalculatorPage.getResult();
        Assert.assertEquals(result, bmiTestModel.getExpectedResult());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            Browser.captureScreenShot(iTestResult.getName());
        }
    }



    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Browser.quit();
    }
}
