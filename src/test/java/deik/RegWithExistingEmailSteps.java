package deik;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegWithExistingEmailSteps extends AbstractStepDefs {
    @Then("error message should be visible: {string}")
    public void errorMessageShouldBeVisible(String arg0) {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/p"));
        assertEquals(arg0, errorMessage.getText());
    }
}
