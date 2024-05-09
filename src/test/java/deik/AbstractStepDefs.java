package deik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractStepDefs {
    private static final int WAIT_TIME = 5;

    protected static final WebDriver driver;

    protected static HomePage homePage;

    protected static AccountInformationPage accountInformationPage;

    static {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME));
        homePage = new HomePage(driver);
        accountInformationPage = new AccountInformationPage(driver);
    }

    public void acceptCookiesIfNeeded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Consent']")));
            acceptButton.click();
/*            WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button")));
            acceptButton.click();
            WebElement acceptButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("button.fc-button.fc-cta-consent.fc-primary-button")));
            acceptButton2.click();*/
        } catch (TimeoutException e) {
            System.out.println("No cookies pop-up appeared.");
        }
    }

    public void closeAdsIfNeeded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement closeButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dismiss-button"))); // #dismiss-button
            closeButton2.click();
        } catch (TimeoutException e) {
            System.out.println("No ads pop-up appeared.");
        }
    }
}


