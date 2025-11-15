package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends BaseTest {

    @Test
    public void verifyTextInPromptAlert() {

        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.cssSelector("button.btn.btn-info")).click();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

        String fullName = "Mariam Elashvili";
        promptAlert.sendKeys(fullName);
        promptAlert.accept();

        WebElement resultMsg = driver.findElement(By.id("demo1"));

        Assert.assertTrue(
                resultMsg.getText().contains(fullName),
                "The alert text is not displayed correctly!"
        );
    }
}
