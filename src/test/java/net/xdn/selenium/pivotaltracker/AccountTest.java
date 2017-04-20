package net.xdn.selenium.pivotaltracker;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Ariel Mattos on 4/12/2017.
 */
public class AccountTest {

    private static final String ACCOUNT_NAME = "Test8";
    private static final String USERNAME = Environment.getInstance().getUsername();
    private static final String PASSWORD = Environment.getInstance().getPassword();
    private static Dashboard dashboard;
    private static Accounts accounts;
    private static AccountHome accountHome;

    /**
     * Precondition: the user must log in to the application.
     */
    @BeforeTest
    public void setUp() {
        Login login = new Login();
        dashboard = login.loginAs(USERNAME, PASSWORD);
    }

    /**
     * It should be possible to create an account.
     */
    @Test
    public void shouldCreateAnAccount() {
        accounts = dashboard.clickAccountsProfileMenuOption();
        CreateAccountForm createAccountForm = accounts.clickCreateAccountButton();
        accountHome = createAccountForm.createAccount(ACCOUNT_NAME);

        assertEquals(accountHome.getAccountName(), ACCOUNT_NAME);
        accounts = accountHome.clickAccountsHeaderOption();
        assertTrue(accounts.isAccountInAccountsIOwn(ACCOUNT_NAME));
    }

    /**
     * PostCondition: The created account is deleted.
     */
    @AfterTest
    public void tearDown() {
        accountHome = accounts.clickAccount(ACCOUNT_NAME);
        AccountSettings accountSettings = accountHome.clickSettingsButton();
        accountSettings.deleteAccount();
    }
}
