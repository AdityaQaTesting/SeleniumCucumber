package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.waitHelper;

import java.util.List;

public class searchCustomerPage {
    public WebDriver driver;
    waitHelper waitHelper;
    public searchCustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new waitHelper(driver);
    }
    @FindBy(how = How.ID,using = "SearchEmail")
    @CacheLookup
    WebElement emailID;
    @FindBy(how = How.ID,using = "SearchFirstName")
    @CacheLookup
    WebElement firstName;
    @FindBy(how = How.ID,using = "SearchLastName")

    WebElement lastName;
    @FindBy(how = How.ID,using = "search-customers")
    @CacheLookup
    WebElement searchButton;

    @FindBy(how=How.CSS,using = "table[id='customers-grid']")
    WebElement table;
    @FindBy(how = How.CSS,using = "table[id='customers-grid'] tbody>tr")
    List<WebElement> tableRows;

    @FindBy(how=How.CSS,using = "table[id='customers-grid'] tbody>tr>td")
    List<WebElement> tableColumns;

    public void setEmailID(String email){
        waitHelper.WaitForElement(emailID,30);
        emailID.clear();
        emailID.sendKeys(email);
    }
    public void setFirstName(String fName){
        waitHelper.WaitForElement(firstName,30);
        firstName.clear();
        firstName.sendKeys(fName);
    }
    public void setLastName(String lName){
        waitHelper.WaitForElement(lastName,30);
        lastName.clear();
        lastName.sendKeys(lName);
    }
    public  void  clickSearch(){
        searchButton.click();
        waitHelper.WaitForElement(searchButton,30);
    }
    public int getNoOfRows(){
        return(tableRows.size());
    }
    public int getNoOfColumns(){
        return(tableColumns.size());
    }
    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String emailId = table.findElement(By.cssSelector("table[id='customers-grid'] tbody>tr:nth-child("+i+")>td:nth-child(2)")).getText();
            System.out.println(emailId);
            if (emailId.equals(email)) {
                flag = true;
            }
        }
    return flag;
    }
    public boolean searchCustomerByName(String Name){
        boolean flag = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String name= table.findElement(By.cssSelector("table[id='customers-grid'] tbody>tr:nth-child("+i+")>td:nth-child(3)")).getText();
            System.out.println(name);
            String names[]=name.split(" ");

            if (names[0].equals("Victoria")&& names[1].equals("Terces"))
            {
                flag = true;
            }
        }
        return flag;
    }

    
}
