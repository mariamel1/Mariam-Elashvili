package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.FormPage;

@Epic("Homework 2")
@Feature("Forms")
public class FormTests extends BaseTest {

    @Test
    @Story("Submit form")
    @Severity(SeverityLevel.CRITICAL)
    public void submitFormTest() {
        FormPage formPage = new FormPage(driver);
        formPage.open();
        formPage.enterName("Mariam");
        formPage.submit();
    }
}
