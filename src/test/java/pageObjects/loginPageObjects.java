package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.waitHelper;

import java.util.concurrent.TimeUnit;

public class loginPageObjects {
    public  WebDriver driver;
    waitHelper waitHelper;
    public  loginPageObjects(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitHelper=new waitHelper(driver);
    }


    @FindBy(id="Email")
    WebElement username;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(css = "input[type='submit']")
    WebElement submit;

    @FindBy(css = "a[href='/logout']")
    WebElement logout;

    public WebElement getusername(){
        username.clear();
        waitHelper.WaitForElement(username,30);
        return username;
    }
    public WebElement getPassword(){

        password.clear();
     waitHelper.WaitForElement(password,30);
        return password;
    }
    public WebElement getSubmit(){
        waitHelper.WaitForElement(submit,30);
        return submit;
    }
    public WebElement getLogout(){
        waitHelper.WaitForElement(logout,30);
        return logout;
    }

}
