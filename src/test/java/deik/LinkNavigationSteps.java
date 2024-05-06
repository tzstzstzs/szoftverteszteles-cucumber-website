package deik;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkNavigationSteps extends AbstractStepDefs {

    @Given("I am on the homepage of {string}")
    public void i_am_on_the_homepage_of(String url) {
        driver.get(url);
    }

    @When("I click on the link with xpath {string}")
    public void i_click_on_the_link_with_xpath(String xpath) {
        WebElement link = driver.findElement(By.xpath(xpath));
        link.click();
    }

    @Then("I should be redirected to {string}")
    public void i_should_be_redirected_to(String expectedUrl) {
        assert driver.getCurrentUrl().equals(expectedUrl) : "URL did not match the expected URL";
    }
}