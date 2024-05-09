package deik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class AccountInformationPage {
    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckbox;

    @FindBy(id = "optin")
    private WebElement partnerCheckbox;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    private static final Map<String, By> textFields = Map.of (
            "Name", By.id("name"),
            "Password", By.id("password"),
            "FirstName", By.id("first_name"),
            "LastName", By.id("last_name"),
            "Address", By.id("address1"),
            "State", By.id("state"),
            "City", By.id("city"),
            "Zipcode", By.id("zipcode"),
            "MobileNumber", By.id("mobile_number")
    );

    public AccountInformationPage(WebDriver driver) {
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

    public void setDateOfBirth(String day, String month, String year) {
        selectDropdownByValue(daysDropdown, day);
        selectDropdownByValue(monthsDropdown, month);
        selectDropdownByValue(yearsDropdown, year);
    }

    private void selectDropdownByValue(WebElement dropdownElement, String value) {
        new Select(dropdownElement).selectByValue(value);
    }

    public void checkNewsletterCheckbox() {
        if (!newsLetterCheckbox.isSelected()) {
            newsLetterCheckbox.click();
        }
    }

    public void checkPartnersCheckbox() {
        if (!partnerCheckbox.isSelected()) {
            partnerCheckbox.click();
        }
    }

    public void selectCountry(String country) {
        selectDropdownByValue(countryDropDown, country);
    }
}