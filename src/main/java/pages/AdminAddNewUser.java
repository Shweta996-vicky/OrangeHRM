package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



import utils.LocatorLoader;

import org.openqa.selenium.Keys;

public class AdminAddNewUser extends BasePage {

    public AdminAddNewUser(WebDriver driver) {
        super(driver);
    }

    public void navigateAndFillForm() {
        // 1. Route to Admin panel via your custom framework JavaScript click
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LocatorLoader.getValue("admin.menu"))));
        clickElementJS(By.xpath(LocatorLoader.getValue("admin.menu")));
        clickElement(By.xpath(LocatorLoader.getValue("admin.addBtn")));
        
        // 2. Select User Role
        clickElement(By.xpath(LocatorLoader.getValue("user.userRoleDropdown")));
        clickElement(By.xpath(LocatorLoader.getValue("component.roleEssOption")));

        // 3. Handle Employee Name Field via target Keyboard Triggers
        WebElement nameInput = driver.findElement(By.xpath(LocatorLoader.getValue("user.empNameInput")));
        nameInput.clear();
        nameInput.sendKeys("Automation Tester");
        
        // Hard Pause to allow all options to complete rendering in the DOM layout
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Arrow down to highlight the first option and Enter to lock it in
        nameInput.sendKeys(Keys.ARROW_DOWN);
        nameInput.sendKeys(Keys.ENTER);
        
        // 4. Select Status Options
        clickElement(By.xpath(LocatorLoader.getValue("user.statusDropdown")));
        clickElement(By.xpath(LocatorLoader.getValue("component.statusEnabledOption")));

        // 5. Complete credential fields (Required by OrangeHRM to save)
        enterText(By.xpath(LocatorLoader.getValue("user.usernameInput")), "AutoUser_" + System.currentTimeMillis());
        enterText(By.xpath(LocatorLoader.getValue("user.passwordInput")), "Password123!");
        enterText(By.xpath(LocatorLoader.getValue("user.confirmPasswordInput")), "Password123!");

        // 6. Submit the form
        clickElement(By.xpath(LocatorLoader.getValue("user.saveBtn")));
    }
}