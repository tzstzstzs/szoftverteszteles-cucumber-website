package deik;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

/*    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }*/

}
