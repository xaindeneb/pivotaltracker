package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ariel Mattos on 4/12/2017.
 */
public class Login extends BasePage {

    @FindBy(id = "credentials_username")
    private WebElement usernameTextField;

    @FindBy(css = "form[action='/signin?return_to='] .credentials_password")
    private WebElement passwordTextField;

    @FindBy(css = "input[value='NEXT']")
    private WebElement nextButton;

    @FindBy(css = "input[value='SIGN IN']")
    private WebElement signInButton;

    /**
     * Sets the username in the Username TextField.
     * @param username      the username to be set.
     */
    public void setUsernameTextField(final String username) {
        Actions.setTextField(usernameTextField, username);
    }

    /**
     * Sets the password in the Password TextField.
     * @param password      the password to be set.
     */
    public void setPasswordTextField(final String password) {
        Actions.setTextField(passwordTextField, password);
    }

    /**
     * Clicks the Next button.
     */
    public void clickNextButton() {
        Actions.clickElement(nextButton);
    }

    /**
     * Clicks the Sign In button.
     */
    public void clickSignInButton() {
        Actions.clickElement(signInButton);
    }

    /**
     * Login as with the specified username and password.
     * @param username      the username.
     * @param password      the password.
     * @return a Dashboard page object.
     */
    public Dashboard loginAs(final String username, final String password) {
        setUsernameTextField(username);
        clickNextButton();
        setPasswordTextField(password);
        clickSignInButton();
        return new Dashboard();
    }
}
