package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class addCustomer {

    public WebDriver driver;
    public addCustomer(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "ul.sidebar-menu.tree>li:nth-child(4)>a>i.fa.fa-user")
    WebElement customerMenu;
    By customerMenuItem=By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/span[1]");
    @FindBy(css = "a.btn.bg-blue")
    WebElement addNew;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement password;
    @FindBy(id = "FirstName")
    WebElement firstname;
    @FindBy(id = "LastName")
    WebElement lastname;
    @FindBy(id="Gender_Male")
    WebElement maleRadioButton;
    @FindBy(id="Gender_Female")
    WebElement femaleRadioButton;
    @FindBy(id="DateOfBirth")
    WebElement datOfBirth;
    @FindBy(id = "Company")
    WebElement company;
    @FindBy(id="IsTaxExempt")
    WebElement taxExempt;

    @FindBy(css = "div.panel-body>div:nth-child(10)>div>div>div>div")
    WebElement customerRoles;
    @FindBy(css = "div.panel-body>div:nth-child(11)>div.col-md-9>select")
    WebElement managerOfVend0r;
    @FindBy(id="AdminComment")
    WebElement comment;
    @FindBy(xpath = "//li[contains(text(),'Administrators')]")
    WebElement listAdministrators;
    @FindBy(xpath = "//li[contains(text(),'Registered')]")
    WebElement listRegistered;
    @FindBy(xpath = "//li[contains(text(),'Guests')]")
    WebElement listGuests;
    @FindBy(xpath = "//li[contains(text(),'Vendors')]")
    WebElement listVendors;
    @FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
    WebElement listForumModerators;



    public String getPageTitle(){
        return driver.getTitle();
    }

    public WebElement getCustomerMenu() {
        return customerMenu;
    }
    public void getCustomerMenuItem() {
        driver.findElement(customerMenuItem).click();

    }
    public WebElement getAddNew() {
        return addNew;
    }
    public WebElement getEmail(String emailid){
         email.sendKeys(emailid);
         return email;
    }
    public WebElement getPassword(String passwd){
        password.sendKeys(passwd);
        return password;
    }


    public WebElement getFirstName() {
        return firstname;
    }
    public WebElement getLastName() {
        return lastname;
    }
    public WebElement getGender(String gender) {
        if (gender.equals("Male")){
            maleRadioButton.click();
            return maleRadioButton;
        }
        else if (gender.equals("Female")){
            femaleRadioButton.click();
            return femaleRadioButton;
        }
        else
        {
            maleRadioButton.click();
            return maleRadioButton;
        }

    }
    public WebElement getDatOfBirth()
    {  return datOfBirth;


    }
    public WebElement getCompany() {
        return company;
    }
    public WebElement getTaxExempt() {
        return taxExempt;

    }
    public WebElement getCustomerRoles(String role) {
        customerRoles.clear();
        customerRoles.click();



        if(role.equals("Administrators")){

            listAdministrators.click();
            return listAdministrators;
        }
        else if(role.equals("Forum Moderators")){

             listForumModerators.click();
            return  listForumModerators;
        }
        else if(role.equals("Guests")){

            listGuests.click();
            return listGuests;
        }
        else if(role.equals("Registered")){

             listRegistered.click();
             return listRegistered;
        }
        else if (role.equals("Vendors")){

            listVendors.click();
            return listVendors;

        }
        return customerRoles;



    }
    public WebElement getManagerOfVend0r() {
        return managerOfVend0r;
    }
    public WebElement getComment() {
        return comment;
    }

}
