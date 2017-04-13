package net.xdn.selenium.pivotaltracker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ariel Mattos on 4/12/2017.
 */
public final class DriverManager {

    private static final int IMPLICIT_WAIT_TIME = 30;
    private static final int EXPLICIT_WAIT = 60;

    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String WEBDRIVER_PATH = "chromedriver.exe";

    private static final String URL = "https://www.pivotaltracker.com/signin";

    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;


    /**
     * DriverManager.
     */
    private DriverManager() {
        System.setProperty(WEBDRIVER, WEBDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        driver.get(URL);
    }

    /**
     * getInstance.
     * @return the DriverManager instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * getDriver.
     * @return a WebDriver Object
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * getWait.
     * @return a WebDriverWait Object
     */
    public WebDriverWait getWait() {
        return wait;
    }

}
