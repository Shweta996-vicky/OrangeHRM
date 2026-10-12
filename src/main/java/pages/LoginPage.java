package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LocatorLoader;

public class LoginPage extends BasePage {
	
    public LoginPage(WebDriver driver) { super(driver); }

    public void loginDetails() {
        enterText(By.xpath(LocatorLoader.getValue("login.username")), "Admin");
        enterText(By.xpath(LocatorLoader.getValue("login.password")), "admin123");
        clickElement(By.xpath(LocatorLoader.getValue("login.submitBtn")));
    }
}