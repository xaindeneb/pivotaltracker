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

    /**
     * Private constructor.
     */
    private Actions() {

    }

    /**
     * Sets the specified text in the specified TextField.
     * @param webElement        The text field.
     * @param text              The text to be set.
     */
    public static void setTextField(final WebElement webElement, final String text) {
        WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Clicks the specified WebElement.
     * @param webElement        The WebElement to be clicked.
     */
    public static void clickElement(final WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Returns the text property of the specified WebElement.
     * @param webElement        The WebElement from which the text property will be obtained.
     * @return a String containing the text property of the specified WebElement.
     */
    public static String getElementText(final WebElement webElement) {
        WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if the specified element is present.
     * @param locator           The locator of the element to search.
     * @return true if the element is present, false otherwise.
     */
    public static boolean isElementPresent(final By locator) {
        return !DRIVER.findElements(locator).isEmpty();
    }

    /**
     * Clicks the specified element.
     * @param locator           The locator of the element.
     */
    public static void clickElement(final By locator) {
        WAIT.until(ExpectedConditions.elementToBeClickable(locator));
        DRIVER.findElement(locator).click();
    }
}
