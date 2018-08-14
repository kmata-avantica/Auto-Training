package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {

    @FindBy(xpath = "//div[@id='nav_login']/a[@href='Register.aspx']")
    public WebElement registerLink;

    @FindBy (css = "a[id$='_LoginLink']")
    public WebElement LoginLink;

    @FindBy (id="ctl00_BrowseAllLink")
    public WebElement BrowseCategory;

    @FindBy (css ="[href='\\/default\\.aspx']")
    public WebElement HomeLink;

    @FindBy (xpath =  "//div[@id='crumbs_text']/span//a[@href='/MyAds.aspx']")
    public WebElement MyAdds;

    @FindBy (xpath = "//div[@id='nav_header']/ul//a[@href='/']")
    public WebElement HomeTab;

    @FindBy (xpath = "//div[@id='nav_header']//a[@href='/PostAd.aspx']/span[.='Post an Ad']")
    public WebElement PostAdTab;

    @FindBy (xpath = "//div[@id='nav_header']/ul//a[@href='/MyAds.aspx']")
    public WebElement ProfileTab;

    public Header(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void registerLinkClick(){
        this.registerLink.click();
    }

    public void goHome(){
        HomeTab.click();
    }


}
