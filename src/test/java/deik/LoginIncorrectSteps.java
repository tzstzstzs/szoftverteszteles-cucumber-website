package deik;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginIncorrectSteps extends AbstractStepDefs {
    @Given("Homepage is opened again")
    public void homepageIsOpenedAgain() {
        homePage.openPage();
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }

    @Given("Login link is clicked: {string}")
    public void loginLinkIsLinked(String arg0) {
        WebElement link = driver.findElement(By.xpath(arg0));
        link.click();
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }

    @Then("{string} text should displayed")
    public void loginToYourAccountTextShouldDisplayed(String loginText) {
        WebElement loginLabel = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/h2"));
        assertEquals(loginText, loginLabel.getText());
    }

    @When("incorrect {string} and {string} entered")
    public void incorrectEmailAndPasswordEntered(String email, String password) {
        WebElement emailTextField = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        WebElement passwordTextField = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
    }

    @Then("error message should be displayed: {string}")
    public void errorMessageShouldBeDisplayed(String arg0) {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/p"));
        assertEquals(arg0, errorMessage.getText());
    }
}
