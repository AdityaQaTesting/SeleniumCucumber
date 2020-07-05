package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.addCustomer;
import pageObjects.loginPageObjects;
import pageObjects.searchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseClass{


    @Before
    public void setup() throws IOException {

        configprop = new Properties();
        FileInputStream configPropFile = new FileInputStream("confg.Properties");
        configprop.load(configPropFile);
        String br = configprop.getProperty("browser");
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }


    @Given("User Launch  Browser")
    public void user_Launch_Chrome_Browser()  {

        lp=new loginPageObjects(driver);

    }

    @When("user Opens URL {string}")
    public void user_Opens_URL(String url) {
        driver.get(url);
    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_Email_as_and_Password_as(String email, String password) {

      lp.getusername().sendKeys(email);
      lp.getPassword().sendKeys(password);
    }

    @When("Click on login")
    public void click_on_login() {
        lp.getSubmit().click();

    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String pagetitle) {

        Assert.assertEquals(pagetitle,driver.getTitle());
    }

    @When("User click on Logout link")
    public void user_click_on_Logout_link() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        lp.getLogout().click();


    }

    //@Then("Close Browser")
   /// public void close_Browser() {
       // driver.close();

   // }
// New Customer details

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard(){
        ac=new addCustomer(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",ac.getPageTitle());
    }
    @When("User click on customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        ac.getCustomerMenu().click();

    }
    @When("User click on customer menu in dropdown")
    public void user_click_on_customer_menu_in_dropdown() throws InterruptedException {

        ac.getCustomerMenuItem();
    }
    @When("Click on AddNew button")
    public void click_on_AddNew_button() throws InterruptedException {
        ac.getAddNew().click();

    }
    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",ac.getPageTitle());

    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        ac.getEmail("admin@yourstore.com");
        ac.getPassword("admin");
        ac.getFirstName().sendKeys("John");
        ac.getLastName().sendKeys("paul");
        ac.getGender("Female");
        ac.getDatOfBirth().sendKeys("9/11/2020");
        ac.getCompany().sendKeys("John.Paul&co");
        ac.getTaxExempt().click();
        ac.getCustomerRoles("Administrators").click();



    }
    @When("Click the save button")
    public void click_the_save_button() {

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
    }
    //Search customer steps

    @When("Enter customer EmailID")
    public void enter_customer_EmailID() {
        searchCust=new searchCustomerPage(driver);
        searchCust.setEmailID("victoria_victoria@nopCommerce.com");
    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();

    }

    @Then("User should found Email in the Search table")
    public void user_should_found_Email_in_the_Search_table() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       boolean status= searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertTrue(status);

    }

    @Then("Close Browser")
    public void close_Browser() {
        driver.close();

    }
//Search customer with name


    @When("Enter customer FirstName")
    public void enter_customer_FirstName() {
        searchCust=new searchCustomerPage(driver);
        searchCust.setFirstName("Victoria");
    }


    @When("Enter customer LastName")
    public void enter_customer_LastName() {
        searchCust.setLastName("Terces");

    }

    @Then("User should found Name in the Search table")
    public void user_should_found_Name_in_the_Search_table() {
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        boolean status=searchCust.searchCustomerByName("Victoria Terces");
        Assert.assertTrue(status);

    }



}
