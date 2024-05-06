package deik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String PAGE_URL = "https://automationexercise.com/";
    private final WebDriver driver; // selenium driver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL); // ez nyitja meg a weboldalt
        PageFactory.initElements(driver, this);
    }
    public void closePage() {
        driver.quit();
    }
}
