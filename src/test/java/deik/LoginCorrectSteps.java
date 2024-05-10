package deik;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginCorrectSteps extends AbstractStepDefs {

    @Given("Homepage is opened")
    public void homepageIsOpened() {
        homePage.openPage();
    }

    @Given("the user clicks on Login link: {string}")
    public void theUserClicksOnLoginLink(String arg0) {
        WebElement link = driver.findElement(By.xpath(arg0));
        link.click();
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }

    @Then("{string} text should be visible")
    public void loginToYourAccountTextShouldBeVisible(String loginText) {
        WebElement loginLabel = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/h2"));
        assertEquals(loginText, loginLabel.getText());
    }

    @When("correct {string} and {string} entered")
    public void correctEmailAndPasswordEntered(String email, String password) {
        WebElement emailTextField = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        WebElement passwordTextField = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
    }

    @And("Login button is clicked")
    public void loginButtonIsClicked() {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }

    @Then("logged in as {string} is visible")
    public void loggedInAsNameIsVisible(String name) {
        WebElement loggedInName = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/b"));
        assertEquals(name, loggedInName.getText());
    }

    @Then("Logout link is clicked")
    public void logoutLinkIsClicked() {
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }
}
