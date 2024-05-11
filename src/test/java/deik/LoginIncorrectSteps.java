package deik;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginIncorrectSteps extends AbstractStepDefs {

    @Then("error message should be displayed: {string}")
    public void errorMessageShouldBeDisplayed(String arg0) {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/p"));
        assertEquals(arg0, errorMessage.getText());
    }
}
