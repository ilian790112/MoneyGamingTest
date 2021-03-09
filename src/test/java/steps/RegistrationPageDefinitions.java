package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import registrationPage.RegistrationPage;

public class RegistrationPageDefinitions {

    WebDriver driver;
    RegistrationPage registrationPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeAllBrowsers() {
        driver.quit();
    }

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigateTo(url);
    }

    @Given("I click {string} button")
    public void iClickButton(String buttonLabel) {
        registrationPage.clickButtonLabel(buttonLabel);
    }


    @And("I select title {string}")
    public void iSelectTitle(String title) {
        registrationPage.selectTitle(title);
    }

    @And("I enter firstname and surname:")
    public void iEnterFirstnameAndSurname(DataTable data) {
        registrationPage.inputFirstName(data);
        registrationPage.inputSurName(data);
    }


    @And("I check the tickbox with text I accept the Terms and Conditions")
    public void iCheckTheTickboxWithTextIAcceptTheTermsAndConditions() {
        registrationPage.clickTermsAndConditionsCheckbox();
    }

    @Then("I should receive a validation message with text {string} under the date of birth box")
    public void iShouldReceiveAValidationMessageWithTextUnderTheDateOfBirthBox(String message) {
        registrationPage.verifyMessageReceived(message);
    }

    @When("I click submit button")
    public void iClickSubmitButton() {
        registrationPage.clickFormSubmitButton();
    }
}
