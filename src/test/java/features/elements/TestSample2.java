package features.elements;

import org.testng.annotations.*;

public class TestSample2 {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("TestSample2:Before Suite:");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("TestSample2:Before Test");
    }

    @Parameters({"browser"})
    @BeforeClass
    void beforeClass(String browser){
        System.out.println("Before Class: TestSample2 "+browser);
    }

    @BeforeGroups
    void beforeGroup(){
        System.out.println("TestSample2:Before Group");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("TestSample2:Before Method");
    }


    @Test(description = "",groups = {"smoke-test"})
    public void tc01(){
        System.out.println("TestSample2:tc01");
    }

    @Test(description = "")
    public void tc02(){
        System.out.println("TestSample2:tc02");
    }

    @Test(description = "")
    public void tc03(){
        System.out.println("TestSample2:tc03");
    }

    @Test(description = "")
    public void tc04(){
        System.out.println("TestSample2:tc04");
    }

    @Test(description = "")
    public void tc05(){
        System.out.println("TestSample2:tc05");
    }



    @AfterMethod
    void afterMethod(){
        System.out.println("TestSample2:After method");
    }

    @AfterGroups
    void afterGroup(){
        System.out.println("TestSample2:After Groups");
    }

    @AfterClass
    void afterClass(){
        System.out.println("TestSample2:After Class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("TestSample2:After Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("TestSample2:After Suite");
    }

}
