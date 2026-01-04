package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private WebDriver driver;

    private By nameInput = By.id("name");
    private By submitButton = By.id("submit");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open form page")
    public void open() {
        driver.get("YOUR_FORM_URL");
    }

    @Step("Enter name: {name}")
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Submit form")
    public void submit() {
        driver.findElement(submitButton).click();
    }
}
