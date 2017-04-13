package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xain on 4/13/2017.
 */
public class AccountSettings extends BasePage {
    @FindBy(css = "form .description a[href*='accounts']")
    private WebElement deleteAccountLink;

    public void clickDeleteAccountLink() {
        Actions.clickElement(deleteAccountLink);
    }

    public void deleteAccount() {
        clickDeleteAccountLink();
        driver.switchTo().alert().accept();
    }

}
