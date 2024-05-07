package deik;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class RegistrationSteps extends AbstractStepDefs {

    @Given("the user clicks on {string}")
    public void user_clicks_on_the_link_with_xpath(String xpath) {
        WebElement link = driver.findElement(By.xpath(xpath));
        link.click();
        acceptCookiesIfNeeded();
    }

    @Then("{string} should be visible")
    public void newUserSignupShouldBeVisible(String signupText) {
        WebElement signupLabel = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/h2"));
        assertEquals(signupText, signupLabel.getText());
    }

    @And("the user enters name {string} and email {string}")
    public void theUserEntersNameAndEmail(String arg0, String arg1) {
        WebElement nameTextField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]"));
        WebElement signupEmailTextField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]"));
        nameTextField.sendKeys(arg0);
        signupEmailTextField.sendKeys(arg1);
    }

    @Then("{string} button is clicked")
    public void buttonIsClicked(String arg0) {
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        acceptCookiesIfNeeded();
        closeAdsIfNeeded();
    }

    @And("{string} should be displayed")
    public void enterAccountInformationShouldBeVisible(String accountInformationText) {
        WebElement accountInfoLabel = driver.findElement(By.xpath("/html/body/section/div/div/div/div/h2/b"));
        assertEquals(accountInformationText, accountInfoLabel.getText());
    }

    @Given("the {string} button is selected")
    public void theTitleButtonIsSelected(String title) {
        regPage.selectTitle(title);
    }

    @And("the {string} field is filled with {string}")
    public void theNameFieldIsFilledWithName(String arg0, String arg1) {
        regPage.fillOutField(arg0, arg1);
    }

}
