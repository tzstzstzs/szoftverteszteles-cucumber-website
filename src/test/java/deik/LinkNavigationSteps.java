package deik;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class LinkNavigationSteps extends AbstractStepDefs {

    private static final Map<String, By> linkNames = Map.of (
            "products", By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a"),
            "view_cart", By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[3]/a"),
            "login", By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"),
            "test_cases", By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a"),
            "api_list", By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[6]/a")
    );

    @Given("I am on the homepage of {string}")
    public void i_am_on_the_homepage_of(String url) {
        driver.get(url);
//        acceptCookiesIfNeeded();
//        closeAdsIfNeeded();
    }

    @When("I click on the link named {string}")
    public void i_click_on_the_link_with_name(String linkName) {
        WebElement element = driver.findElement(linkNames.get(linkName));
        element.click();
    }

    @Then("I should be redirected to {string}")
    public void i_should_be_redirected_to(String expectedUrl) {
        assert driver.getCurrentUrl().equals(expectedUrl) : "URL did not match the expected URL";
    }
}
