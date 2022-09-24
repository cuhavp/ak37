package features.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTest {

    /**
     * TC 01: create new to do
     * 1. Open browser
     * 2. Navigate to https://todomvc.com/examples/vanillajs/
     * 3. Fill in new todo with "Do Homework".
     * 4. Verify new todo is appear all/active view
     * 5. Number item left +1
     */

    @Test
    void createNew(){
        String taskName="Do Homework";
        String toDoLocator = String.format("//label[.='%s']",taskName);

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/vanillajs/");
        driver.manage().window().maximize();

       String currentTodos = driver.findElement(By.className("todo-count"))
               .findElement(By.tagName("strong")).getText();

//       LowerCase/UpperCase
        /**
         * Login equalsIgnoreCase login TRUE
         * LOGIN equalsIgnoreCase login TRUE
         * LogIn equalsIgnoreCase login TRUE
         */

        if(currentTodos.equalsIgnoreCase("")){
            currentTodos = "0";
        }
        driver.findElement(By.className("new-todo")).sendKeys("Do Homework",Keys.ENTER);
        Assert.assertTrue(  driver.findElement(By.xpath(toDoLocator)).isDisplayed());

        driver.findElement(By.xpath("//a[.='Active']")).click();
        Assert.assertTrue(  driver.findElement(By.xpath(toDoLocator)).isDisplayed());

        int toDoCount = Integer.parseInt(driver.findElement(By.className("todo-count"))
                .findElement(By.tagName("strong")).getText());


        Assert.assertEquals(toDoCount,Integer.parseInt(currentTodos)+1);

    }


}
