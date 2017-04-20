package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xain on 4/13/2017.
 */
public class AccountHome extends BasePage {
    @FindBy(css = "h2.account_name span")
    private WebElement accountNameLabel;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountsHeaderOption;

    @FindBy(css = ".buttons li a[href*='settings']")
    private WebElement settingsButton;

    /**
     * @return a String containing the name of the account in the account home page.
     */
    public String getAccountName() {
        return Actions.getElementText(accountNameLabel);
    }

    /**
     * Clicks the Account header option.
     * @return an Accounts page object.
     */
    public Accounts clickAccountsHeaderOption() {
        Actions.clickElement(accountsHeaderOption);
        return new Accounts();
    }

    /**
     * Clicks the Account header option.
     * @return an AccountSettings page object.
     */
    public AccountSettings clickSettingsButton() {
        Actions.clickElement(settingsButton);
        return new AccountSettings();
    }

}
