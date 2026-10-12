package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageHub;

public class OrangeHRMTest {
    private WebDriver driver;
    private PageHub pageHub;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageHub = new PageHub(driver);
        driver.get(utils.LocatorLoader.getValue("app.url"));
    }

    @Test
    public void executeApp() {
        // Step 1: Log in
        pageHub.loginPage().loginDetails();
        
        // Step 2: Go to PIM and create the profile
        pageHub.pimPage().createNewEmployee();
        
        // Step 3: Go to Admin, find that profile, and create the user account
        pageHub.adminPage().navigateAndFillForm();
    }
    

  /*  @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } */
}