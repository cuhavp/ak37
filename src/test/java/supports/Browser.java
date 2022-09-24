package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckBoxPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    private static final Logger logger = LogManager.getLogger(Browser.class);

    protected static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver;
    }

    public static  int TIMEOUT = 30;
    public static void openBrowser(String name) {
        switch (name.toLowerCase()) {
            case "firefox": {
                driver=  WebDriverManager.firefoxdriver().create();
            }
            case "safari": {
                driver= new SafariDriver();
            }
            default:
            {
                 WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
        logger.info("Open browser "+name);
    }

    public static void openBrowser(String name, boolean setHeadless) {
        switch (name.toLowerCase()) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(setHeadless);
                driver= new FirefoxDriver(firefoxOptions);
            }
            default:
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(setHeadless);
                driver= new ChromeDriver(chromeOptions);
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
    }

    public static void visit(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static String getText(By locator){
        logger.info("get text from" +locator);
        return driver.findElement(locator).getText();
    }

    public static void captureScreenShot(String name){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./target/screenshots/"+name+"-"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void fill(By locator,String withValue){
        driver.findElement(locator).sendKeys(withValue);
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }
}
