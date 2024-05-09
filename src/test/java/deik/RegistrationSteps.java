package deik;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        WebElement signUpLabel = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/h2"));
        assertEquals(signupText, signUpLabel.getText());
    }

    @When("the user enters name {string} and email {string}")
    public void theUserEntersNameAndEmail(String arg0, String arg1) {
        WebElement nameTextField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]"));
        WebElement signupEmailTextField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]"));
        nameTextField.sendKeys(arg0);
        signupEmailTextField.sendKeys(arg1);
    }

    @And("Signup button is clicked")
    public void buttonIsClicked() {
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        acceptCookiesIfNeeded();
        closeAdsIfNeeded();
    }

    @Then("{string} should be displayed")
    public void enterAccountInformationShouldBeVisible(String accountInformationText) {
        WebElement accountInfoLabel = driver.findElement(By.xpath("/html/body/section/div/div/div/div/h2/b"));
        assertEquals(accountInformationText, accountInfoLabel.getText());
    }

    @When("the {string} button is selected")
    public void theTitleButtonIsSelected(String title) {
        accountInformationPage.selectTitle(title);
    }

    @And("the {string} field is filled with {string}")
    public void theNameFieldIsFilledWithName(String arg0, String arg1) {
        accountInformationPage.fillOutField(arg0, arg1);
    }


    @And("the {string}, {string} and {string} of birth is set")
    public void theDayMonthAndYearOfBirthIsSet(String day, String month, String year) {
        accountInformationPage.setDateOfBirth(day, month, year);
    }

    @And("newsletter checkbox is checked")
    public void newsletterCheckboxIsChecked() {
        accountInformationPage.checkNewsletterCheckbox();
    }

    @And("partners checkbox is checked")
    public void partnersCheckboxIsChecked() {
        accountInformationPage.checkPartnersCheckbox();
    }

    @And("the {string} is seleced")
    public void theCountryIsSeleced(String country) {
        accountInformationPage.selectCountry(country);
    }

    @And("Create Account button is clicked")
    public void createAccountButtonIsClicked() {
        driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/button")).click();
        acceptCookiesIfNeeded();
        closeAdsIfNeeded();
    }

    @Then("{string} should be seen")
    public void messageShouldBeSeen(String accountCreatedText) {
        WebElement accountCreatedLabel = driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b"));
        assertEquals(accountCreatedText, accountCreatedLabel.getText());
    }

    @When("Continue button is clicked")
    public void continueButtonIsClicked() {
        driver.findElement(By.xpath("/html/body/section/div/div/div/div/a")).click();
        acceptCookiesIfNeeded();
        closeAdsIfNeeded();
    }

    @Then("logged in as {string} label is seen")
    public void loggedInAsNameLabelIsSeen(String name) {
        WebElement loggedInName = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/b"));
        assertEquals(name, loggedInName.getText());
    }

    @When("Delete button is clicked")
    public void deleteButtonIsClicked() {
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a")).click();
        acceptCookiesIfNeeded();
        closeAdsIfNeeded();
    }

    @Then("Account deleted text should be seen")
    public void accountDeletedTextShouldBeSeen() {
        WebElement accountDeletedText = driver.findElement(By.xpath("/html/body/section/div/div/div/h2/b"));
        assertEquals("ACCOUNT DELETED!", accountDeletedText.getText());
    }
}
