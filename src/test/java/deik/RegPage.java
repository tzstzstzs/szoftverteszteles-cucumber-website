package deik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class RegPage {
    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

/*    @FindBy(id = "name")
    private WebElement name;*/

    private static final Map<String, By> textFields = Map.of (
            "Name", By.id("name"),
            "Password", By.id("password")
    );

    public RegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectTitle(String title) {
        if ("Mr".equalsIgnoreCase(title)) {
            mrRadioButton.click();
        } else if ("Mrs".equalsIgnoreCase(title)) {
            mrsRadioButton.click();
        }
    }

    public void fillOutField(String field, String text){
        WebElement element = driver.findElement(textFields.get(field));
        element.clear();
        element.sendKeys(text);
    }
}
