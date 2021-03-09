package registrationPage;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickButtonLabel(String buttonLabel) {
        driver.findElement(By.xpath("//a[contains(text(),'" + buttonLabel + "')]")).click();
    }

    public void selectTitle(String title) {
        Select titleDropdown = new Select(driver.findElement(By.name("map(title)")));
        titleDropdown.selectByValue(title);
    }

    public void inputFirstName(DataTable data) {
        Map<String, String> rawData = data.transpose().asMap(String.class, String.class);
        driver.findElement(By.id("forename")).sendKeys(rawData.get("firstName"));
    }

    public void inputSurName(DataTable data) {
        Map<String, String> rawData = data.transpose().asMap(String.class, String.class);
        driver.findElement(By.name("map(lastName)")).sendKeys(rawData.get("surName"));
    }

    public void clickTermsAndConditionsCheckbox() {
        driver.findElement(By.id("checkbox")).click();
    }

    public void clickFormSubmitButton() {
        driver.findElement(By.id("form")).click();
    }

    public void verifyMessageReceived(String message) {
        Assert.assertEquals(message, driver.findElement(By.xpath("//label[@for='dob']")).getText());
    }
}
