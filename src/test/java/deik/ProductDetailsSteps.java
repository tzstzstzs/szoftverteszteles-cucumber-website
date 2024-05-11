package deik;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDetailsSteps extends AbstractStepDefs {
    @Then("{string} is visible")
    public void allPRODUCTSIsVisible(String arg0) {
        WebElement allProductsLabel = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
        assertEquals(arg0, allProductsLabel.getText());
    }

    @When("view product {string} is clicked")
    public void viewProductButtonIsClicked(String selectorOfButton) {
        driver.findElement(By.cssSelector(selectorOfButton)).click();
    }

    @Then("the {string} of the product matches")
    public void theNameOfTheProductMatches(String productName) {
        WebElement nameOfProduct = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
        assertEquals(productName, nameOfProduct.getText());
    }

    @And("the {string} of the product is correct")
    public void thePriceOfTheProductIsCorrect(String price) {
        WebElement priceOfProduct = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
        assertEquals(price, priceOfProduct.getText());
    }

    @And("the {string} matches")
    public void theAvailabilityMatches(String availability) {
        WebElement availabilityOfProduct = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
        assertEquals(availability, availabilityOfProduct.getText());
    }
}
