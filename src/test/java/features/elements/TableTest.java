//package features.elements;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.*;
//
//public class TableTest {
//
//    /*
//    Open browser
//    Navigate to https://the-internet.herokuapp.com/tables
//    Focus on table 1
//    The person who has largest due is "Doe Jacson"
//     */
//
//      /*
//    Open browser
//    Navigate to https://the-internet.herokuapp.com/tables
//    Focus on table 1
//    The person who has smallest due are "Smith John","Conway Tim"
//     */
//
//    /**
//     * Get list due -
//     * Tim max due -
//     * Get index of max due -
//     * Create List name (First name + Last name) -
//     * Get name[index]
//     * Assert name with max due
//     **/
//    WebDriver driver;
//    List<Double> dues;
//
//    @BeforeClass
//    void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/tables");
//        driver.manage().window().maximize();
//
//        dues = driver
//                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
//                .stream()
//                .map(WebElement::getText).toList()
//                .stream()
//                .map(s -> s.replace("$", "")).toList()
//                .stream().map(Double::valueOf).toList();
//    }
//
//
//    @Test
//    void verifyLargestDuePersonInTable1() {
//        Double maxDue = Collections.max(dues);
//        int maxDueIndex = dues.indexOf(maxDue);
//
//        Assert.assertEquals(getFullNameByIndex(maxDueIndex + 1), "Doe Jason");
//    }
//
//    @Test
//    void verifySmallestDuePersonsInTable1() {
//        Double minDue = Collections.min(dues);
//        List<String> smallestDuePersons = new ArrayList<>();
//        for (int i = 0; i < dues.size(); i++) {
//            if (Objects.equals(dues.get(i), minDue)) {
//                smallestDuePersons.add(getFullNameByIndex(i + 1));
//            }
//        }
//        Assert.assertEquals(smallestDuePersons, Arrays.asList("Smith John", "Conway Tim"));
//    }
//
//    String getFullNameByIndex(int index) {
//        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", index))).getText();
//        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", index))).getText();
//        return String.format("%s %s", lastName, firstName);
//    }
//
//    @AfterClass(alwaysRun = true)
//    void tearDown() {
//        driver.quit();
//    }
//}
