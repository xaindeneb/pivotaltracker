package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xain on 4/13/2017.
 */
public class Dashboard extends BasePage {

    @FindBy(css = ".tc_profile_dropdown .tc_dropdown_name")
    private WebElement profileMenu;

    @FindBy(css = ".tc_profile_dropdown a[href='/accounts']")
    private WebElement accountsMenuOption;

    public Accounts clickAccountsProfileMenuOption() {
        Actions.clickElement(profileMenu);
        Actions.clickElement(accountsMenuOption);
        return new Accounts();
    }


}
