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

    public static final String ACCOUNT_NAME = "Test8";
    public static final String USERNAME = "xaindeneb@gmail.com";
    public static final String PASSWORD = "Control.123";
    public static Dashboard dashboard;
    public static Accounts accounts;
    public static AccountHome accountHome;

    @BeforeTest
    public void setUp() {
        Login login = new Login();
        dashboard = login.loginAs(USERNAME, PASSWORD);
    }

    @Test
    public void shouldCreateAnAccount() throws Exception {
        accounts = dashboard.clickAccountsProfileMenuOption();
        CreateAccountForm createAccountForm = accounts.clickCreateAccountButton();
        accountHome = createAccountForm.createAccount(ACCOUNT_NAME);

        assertEquals(accountHome.getAccountName(),ACCOUNT_NAME);
        accounts = accountHome.clickAccountsHeaderOption();
        assertTrue(accounts.isAccountInAccountsIOwn(ACCOUNT_NAME));
    }

    @AfterTest
    public void tearDown() {
        accountHome = accounts.clickAccount(ACCOUNT_NAME);
        AccountSettings accountSettings = accountHome.clickSettingsButton();
        accountSettings.deleteAccount();
    }
}