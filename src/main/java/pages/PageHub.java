package pages;

import org.openqa.selenium.WebDriver;

public class PageHub {
    private WebDriver driver;
    private LoginPage loginPage;
    private PimAddEmployee pimPage;
    private AdminAddNewUser adminPage;

    public PageHub(WebDriver driver) { this.driver = driver; }

    public LoginPage loginPage() {
        if (loginPage == null) loginPage = new LoginPage(driver);
        return loginPage;
    }

    public PimAddEmployee pimPage() {
        if (pimPage == null) pimPage = new PimAddEmployee(driver);
        return pimPage;
    }

    public AdminAddNewUser adminPage() {
        if (adminPage == null) adminPage = new AdminAddNewUser(driver);
        return adminPage;
    }
}