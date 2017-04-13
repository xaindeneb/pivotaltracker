package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by xain on 4/12/2017.
 */
public final class Actions {

    private static final WebDriver DRIVER = DriverManager.getInstance().getDriver();
    private static final WebDriverWait WAIT = DriverManager.getInstance().getWait();

    private Actions() {

    }

    public static void setTextField(final WebElement webElement, final String text) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void clickElement(final WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static String getElementText(final WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement.getText();
    }

    public static boolean isElementPresent(final By locator) {
        return DRIVER.findElements(locator).size() != 0;
    }

    public static void clickElement(final By locator) {
        WAIT.until(ExpectedConditions.elementToBeClickable(locator));
        DRIVER.findElement(locator).click();
    }

}
