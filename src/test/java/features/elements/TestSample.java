package features.elements;

import org.testng.annotations.*;

public class TestSample {

    @BeforeSuite(alwaysRun = true)
    void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }


    @Test
    public void tc01(){
        System.out.println("tc01");
    }

    @Test(description = "")
    public void tc02(){
        System.out.println("tc02");
    }

    @Test
    public void tc03(){
        System.out.println("tc03");
    }

    @Test(description = "")
    public void tc04(){
        System.out.println("tc04");
    }

    @Test(description = "")
    public void tc05(){
        System.out.println("tc05");
    }



    @AfterMethod
    void afterMethod(){
        System.out.println("After method");
    }

    @AfterGroups
    void afterGroup(){
        System.out.println("After Groups");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class");
        System.out.println("Close Browser");
    }

    @AfterTest
    void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("After Suite");
    }

}
