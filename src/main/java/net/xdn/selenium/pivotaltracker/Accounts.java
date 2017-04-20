package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xain on 4/13/2017.
 */
public class Accounts extends BasePage {
    private static final String ACCOUNT_HEADER = "//h3/div/div[text() = '%s']";
    private static final String MANAGE_ACCOUNT =
            "//h3/div/div[text() = '%s']/../following::a[contains(@href,'accounts')]";

    @FindBy(id = "new_account_link")
    private WebElement createAccountButton;

    /**
     * Clicks the Create Account button.
     * @return a CreateAccountForm page object.
     */
    public CreateAccountForm clickCreateAccountButton() {
        Actions.clickElement(createAccountButton);
        return new CreateAccountForm();
    }

    /**
     * Verifies if the specified account is already created.
     * @param accountName       The name of the account to search.
     * @return 'true' if the account is found, and false otherwise.
     */
    public boolean isAccountInAccountsIOwn(final String accountName) {
        return Actions.isElementPresent(By.xpath(String.format(ACCOUNT_HEADER, accountName)));
    }

    /**
     * Clicks the specified account.
     * @param accountName       The name of the account to click.
     * @return an AccountHome page object.
     */
    public AccountHome clickAccount(final String accountName) {
        final By accountLocator = By.xpath(String.format(MANAGE_ACCOUNT, accountName));
        if (Actions.isElementPresent(accountLocator)) {
            Actions.clickElement(accountLocator);
        }

        return new AccountHome();
    }
}
