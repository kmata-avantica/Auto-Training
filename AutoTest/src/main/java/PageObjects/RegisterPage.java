package PageObjects;

import Common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends BasePage {


    @FindBy (css = "[type='submit']")
    public WebElement submitBtn;

    @FindBy (css =" input[id$='_FirstName']")
    public WebElement firstName;

    @FindBy (css =" input[id$='_LastName']")
    public WebElement lastName;

    @FindBy (css =" input[id$='_Email']")
    public WebElement email;

    @FindBy (css =" input[id$='_UserName']")
    public WebElement userName;

    @FindBy (css =" input[id$='_Password']")
    public WebElement password;

    @FindBy (css =" input[id$='_ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy (css =" input[id$='_Question']")
    public WebElement question;

    @FindBy (css =" input[id$='_Answer']")
    public  WebElement answer;

    @FindBy (css ="span[id$='_FirstNameRequired']")
    public WebElement firstnameRequired;

    @FindBy (css ="span[id$='_LastNameRequired']")
    public WebElement lastnameRequired;

    @FindBy (css ="span[id$='_EmailRequired']")
    public WebElement emailRequired;

    @FindBy (css ="span[id$='_UserNameRequired']")
    public WebElement usernameRequired;

    @FindBy (css ="span[id$='_PasswordRequired']")
    public WebElement passwordRequired;

    @FindBy (css ="span[id$='_ConfirmPasswordRequired']")
    public WebElement confirmpasswordRequired;

    @FindBy (css ="span[id$='_QuestionRequired']")
    public WebElement questionRequired;

    @FindBy (css ="span[id$='_AnswerRequired']")
    public WebElement answerRequired;

    @FindBy (xpath = "/html//div[@id='col_main_right']/div[@class='content_right']//table[@class='register_text']/tbody/tr[1]//table//span[@title='A valid user name is required.']")
    public WebElement usernameformat;

    @FindBy (xpath ="/html//div[@id='col_main_right']/div[@class='content_right']//table[@class='register_text']/tbody/tr[1]//table//span[.='The password and confirmation password must match.']")
    public WebElement passwordCompare;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clicksubmitbtn () {
        submitBtn.click();
    }
// Quitar datos quemados
    public void createdusername(String usernam)  {

        userName.sendKeys(usernam);
        submitBtn.click();

    }

    public String getwarningusername(){
        return usernameformat.getText();
    }

    //Cambiar nombres para inicio en masyuscula!
    public void incorrectmatchpassword(String pass, String confirmpass){
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmpass);
        submitBtn.click();
    }

    public String getpasswordcompare(){
        return passwordCompare.getText();
    }

}
