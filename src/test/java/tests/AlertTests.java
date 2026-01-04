package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AlertPage;

@Epic("Homework 2")
@Feature("Alerts")
public class AlertTests extends BaseTest {

    @Test
    @Story("Accept alert")
    @Severity(SeverityLevel.NORMAL)
    public void alertTest() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.open();
        alertPage.clickAlert();
        alertPage.acceptAlert();
    }
}
// Git test change
