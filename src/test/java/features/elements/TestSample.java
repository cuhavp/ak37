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

    @Parameters({"browser"})
    @BeforeClass
    void beforeClass(String browser){
        System.out.println("Before Class "+browser);
        System.out.println("Open Browser");
    }


    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }


    @Test(description = "",groups = {"smoke-test","regression"})
    public void tc01(){
        System.out.println("tc01");
    }

    @Test(description = "")
    public void tc02(){
        System.out.println("tc02");
    }

    @Test(description = "",groups = {"smoke-test"},dependsOnMethods = {"tc01"})
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


    @Parameters({ "first-name" })
    @Test
    public void testSingleString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "Cedric".equals(firstName);
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
