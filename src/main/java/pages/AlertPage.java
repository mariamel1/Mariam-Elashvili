package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {

    private WebDriver driver;

    private By alertButton = By.id("alertBtn");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open alert page")
    public void open() {
        driver.get("YOUR_ALERT_URL");
    }

    @Step("Click alert button")
    public void clickAlert() {
        driver.findElement(alertButton).click();
    }

    @Step("Accept alert")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
