package TestSuites;


import Common.Header;
import PageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterPageTests {


    //Create new objects
    static WebDriver driver;
    public static Header headercomm;
    public  static RegisterPage registerP;


    @BeforeTest
    public static void printbeforeTest(){
        System.out.println("Starting Execution");
    }

    @BeforeClass
    public static void printbeforeClass(){
        System.out.println("Executing class: Register Page");
    }

    @BeforeMethod
    public static void setupTest(){
        driver = new ChromeDriver();
        headercomm = new Header(driver);
        registerP  =  new RegisterPage(driver);
    }

    @Test
    public void practice1() throws InterruptedException {
        //Dividir los tests, nombre significativo
        driver.get("http://qa-trainingw7:86/");
        //Click on Register Link
        headercomm.registerLinkClick();
        //Field Validation a+aumentar mas las verificaciones
        Assert.assertTrue(registerP.email.isDisplayed());
        //Click on Submit Button
        registerP.clicksubmitbtn();
        //Warning Validation
        //Cambiar y crear un metodo en Register Page
        Assert.assertTrue(registerP.firstnameRequired.isDisplayed());
        Assert.assertTrue(registerP.lastnameRequired.isDisplayed());
        Assert.assertTrue(registerP.passwordRequired.isDisplayed());
        Assert.assertTrue(registerP.confirmpasswordRequired.isDisplayed());
        Assert.assertTrue(registerP.emailRequired.isDisplayed());
        Assert.assertTrue(registerP.usernameRequired.isDisplayed());
        Assert.assertTrue(registerP.questionRequired.isDisplayed());
        Assert.assertTrue(registerP.answerRequired.isDisplayed());
        registerP.createdusername("karla.mata");
        Assert.assertEquals(registerP.getwarningusername(), "User name is required and must be less than 40 characters long and contain only alphanumerics, apostrophes, spaces, or periods.");
        registerP.incorrectmatchpassword("KkMm123#","'KkMm135#");
        Assert.assertEquals(registerP.passwordCompare.getText(), "The password and confirmation password must match.");
    }

    @AfterClass
    public static void printafterMethod(){
        System.out.println("Completing execution class: Register Page");
    }

    @AfterMethod
    public static void quitdriver(){
        driver.quit();
    }

    @AfterTest()
        public static void printafterTest(){
            System.out.println("Completing Execution");
        }


}
