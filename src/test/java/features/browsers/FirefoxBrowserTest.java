package features.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FirefoxBrowserTest {

    @Test
    void openNormal(){
        WebDriverManager.firefoxdriver().setup();
        new FirefoxDriver();
    }

    @Test
    void openHeadlessMode(){
        WebDriverManager.firefoxdriver().setup();

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        new FirefoxDriver(firefoxOptions);
    }
}
