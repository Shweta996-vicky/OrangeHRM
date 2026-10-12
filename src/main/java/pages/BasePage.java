package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected void selectDropdownViaKeys(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        
        // Dynamic wait cushion for custom drop-down menu animations
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN) // Focuses Select placeholder
               .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN) // Moves to 'Admin'
               .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN) // Moves to 'ESS'
               .sendKeys(org.openqa.selenium.Keys.ENTER) // Selects 'ESS'
               .build()
               .perform();
    }
    
    public void clickElementJS(By locator) {
        org.openqa.selenium.WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}