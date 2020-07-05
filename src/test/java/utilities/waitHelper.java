package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

public class waitHelper {
    public WebDriver driver;

    public waitHelper(WebDriver driver){ this.driver=driver;}
    public void WaitForElement(WebElement element,long timeOutInSeconds){
        WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
