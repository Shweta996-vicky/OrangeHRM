package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LocatorLoader;

public class PimAddEmployee extends BasePage {
    public PimAddEmployee(WebDriver driver) { super(driver); }

    public void createNewEmployee() {
        clickElement(By.xpath(LocatorLoader.getValue("pim.menu")));
        clickElement(By.xpath(LocatorLoader.getValue("pim.addEmployeeBtn")));

        enterText(By.xpath(LocatorLoader.getValue("pim.firstName")), "Automation");
        enterText(By.xpath(LocatorLoader.getValue("pim.lastName")), "Tester");
        clickElement(By.xpath(LocatorLoader.getValue("pim.saveBtn")));
        
        // FIX: Override global timeout with a 20-second window to cushion slow demo server responses
        org.openqa.selenium.support.ui.WebDriverWait longWait = 
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        longWait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("viewPersonalDetails"));
    }
}