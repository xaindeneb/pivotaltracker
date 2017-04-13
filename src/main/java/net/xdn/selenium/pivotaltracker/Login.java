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

    public void setUsernameTextField(final String username) {
        Actions.setTextField(usernameTextField, username);
    }

    public void setPasswordTextField(final String password) {
        Actions.setTextField(passwordTextField, password);
    }

    public void clickNextButton() {
        Actions.clickElement(nextButton);
    }

    public void clickSignInButton() {
        Actions.clickElement(signInButton);
    }

    public Dashboard loginAs(final String username, final String password) {
        setUsernameTextField(username);
        clickNextButton();
        setPasswordTextField(password);
        clickSignInButton();
        return new Dashboard();
    }
}
