package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xain on 4/13/2017.
 */
public class CreateAccountForm extends BasePage {

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(id = "add_account_button")
    private WebElement createAccountButton;

    /**
     * Creates an account with the given name.
     * @param accountName       the name of the account.
     * @return the AccountHome page object of the created account.
     */
    public AccountHome createAccount(final String accountName) {
        Actions.setTextField(accountNameTextField, accountName);
        Actions.clickElement(createAccountButton);
        return new AccountHome();
    }
}
