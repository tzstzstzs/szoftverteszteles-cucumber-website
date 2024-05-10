package deik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.devtools.v124.network.model.RequestPattern;
import org.openqa.selenium.devtools.v124.network.model.ResourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

        // Initialize the DevTools and create a session
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable Network domain in DevTools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Define the pattern for URLs to block
        List<String> blockedUrlPatterns = Arrays.asList(
                "*.googleads.*",
                "*.doubleclick.net*",
                "*.googlesyndication.*"
        );

        // Block requests matching the defined patterns
        devTools.send(Network.setBlockedURLs(blockedUrlPatterns));

        homePage = new HomePage(driver);
        accountInformationPage = new AccountInformationPage(driver);
    }


    public void acceptCookiesIfNeeded() {
        long startTime = System.currentTimeMillis();
        boolean clicked = false;

        while ((System.currentTimeMillis() - startTime) < 5000 && !clicked) {  // Try for up to 5 seconds
            try {
                List<WebElement> acceptButtons = driver.findElements(By.cssSelector("button[aria-label='Consent'], button.fc-button.fc-cta-consent.fc-primary-button"));
                if (!acceptButtons.isEmpty() && acceptButtons.get(0).isDisplayed()) {
                    acceptButtons.get(0).click();
                    System.out.println("Clicked on the cookie acceptance button.");
                    clicked = true;
                }
            } catch (Exception e) {
                System.out.println("Trying to find the cookie button...");
                try {
                    Thread.sleep(500);  // Sleep for 500ms before trying again
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (!clicked) {
            System.out.println("No cookies pop-up appeared after waiting.");
        }
    }

    public void closeAdsIfNeeded() {
        long startTime = System.currentTimeMillis();
        boolean clicked = false;

        // Try for up to 5 seconds to find and click the close button of ads
        while ((System.currentTimeMillis() - startTime) < 5000 && !clicked) {
            try {
                // Find all elements that could be the ad's close button
                List<WebElement> closeButtons = driver.findElements(By.cssSelector("button[id='dismiss-button'], button[class*='close'], a[class*='close'], " +
                        "div#dismiss-button, div.ns-brono-e-14.button-common.close-button, div.close-button[aria-label='Close ad']" +
                        "div[role='button'][aria-label='Close ad']"));

                // Attempt to click the first visible close button
                for (WebElement button : closeButtons) {
                    if (button.isDisplayed()) {
                        button.click();
                        System.out.println("Clicked on the ad close button.");
                        clicked = true;
                        break;  // Exit the loop once the ad has been closed
                    }
                }
            } catch (Exception e) {
                System.out.println("Trying to find and close the ad...");
                try {
                    Thread.sleep(500);  // Wait for 500ms before trying again
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (!clicked) {
            System.out.println("No ads pop-up appeared or were clickable after waiting.");
        }
    }

}


