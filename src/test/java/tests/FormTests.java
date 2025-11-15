package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTests extends BaseTest {

    @Test
    public void fillFormWithScrolling() {
        driver.get("https://demoqa.com/automation-practice-form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.findElement(By.id("firstName")).sendKeys("Mariam");
        driver.findElement(By.id("lastName")).sendKeys("Elashvili");
        driver.findElement(By.id("userEmail")).sendKeys("elashvili1@example.com");
        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("579222555");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--013")).click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("science");
        subjects.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        submitBtn.click();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        Assert.assertTrue(modal.isDisplayed(), "Modal did not appear!");

        String tableContent = driver.findElement(By.className("table-responsive")).getText();
        Assert.assertTrue(tableContent.contains("Mariam"), "First name missing!");
        Assert.assertTrue(tableContent.contains("Elashvili"), "Last name missing!");
        Assert.assertTrue(tableContent.contains("elashvili1@example.com"), "Email missing!");
        Assert.assertTrue(tableContent.contains("579222555"), "Mobile missing!");
        Assert.assertTrue(tableContent.contains("science"), "Subject missing!");
        Assert.assertTrue(tableContent.contains("Sports"), "Hobby missing!");
        Assert.assertTrue(tableContent.contains("Tbilisi, Georgia"), "Address missing!");

        driver.findElement(By.id("closeLargeModal")).click();
    }
}
