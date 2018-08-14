package Common;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    long timeOutInSeconds = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean waitForElementVisible(WebElement element) {

        try {
            this.waitForJsProcess();
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            System.out.println("[ERROR] Element is not present: "+ e.getMessage());
            return false;
        }
    }

    protected boolean  waitForElementNotVisible(WebElement element){
        try {
            this.waitForJsProcess();
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return false;
        } catch (Exception e) {
            System.out.println("[ERROR] Element is present: "+ e.getMessage());
            return true;
        }
    }

    protected boolean waitForElementEnabled (WebElement element){
        try {
            this.waitForJsProcess();
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeSelected(element));
            return true;
        } catch (Exception e) {
            System.out.println("[ERROR] Element is not enabled: "+ e.getMessage());
            return false;
        }
    }


    private boolean waitForJsProcess() {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(new ExpectedCondition< Boolean >() {
            public Boolean apply(WebDriver arg0) {
                return (Boolean)  ((JavascriptExecutor) driver).executeScript("return document.readyState == 'complete'");
            }
        });
    }

    protected String getElementText(WebElement element){
        String text = "";
        try{
            if (waitForElementVisible(element)==true){
                text = element.getText();
            }
        }catch(Exception e){
            System.out.println("Unable to find the element" + element);
        }
        return text;
    }


    protected String  waitForElementPresenceAndGetText(WebElement element){
        String text = "";
        try {
            if(waitForElementVisible(element) == true){
                text = element.getText();
            }
        } catch (Exception e) {
            System.out.println("Unable to find and get text from the element. "+ e.getMessage());
        }

        return text;
    }

    public void ClickOnElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            (new Actions(driver)).click(element).perform();

            System.out.println("Button clicked: " + element);
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                (new Actions(driver)).click(element).perform();
            } catch (Exception e2) {

                System.out
                        .println("Unable to perform the click on element "
                                + element);
            }
        }
    }



}
