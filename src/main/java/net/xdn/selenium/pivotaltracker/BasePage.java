package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ariel Mattos on 4/12/2017.
 */
public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
}
