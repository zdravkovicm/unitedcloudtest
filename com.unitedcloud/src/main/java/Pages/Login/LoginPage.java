package main.java.Pages.Login;

import main.java.Utils.BaseClass;
import main.java.Utils.Constants;
import main.java.Utils.WebElementLocator;
import main.java.Utils.WebElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass {

    // Web elements

    /**
     * Username input field
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#username")
    private static WebElement usernameInput() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(LoginPage.class, "usernameInput")));
    }

    /**
     * Password input field
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#password")
    private static WebElement passwordInput() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(LoginPage.class, "passwordInput")));
    }

    /**
     * Login Button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "button[type='submit']")
    private static WebElement loginBtn() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(LoginPage.class, "loginBtn")));
    }

    //Actions

    /**
     * Login User with the provided credentials
     *
     * @param username - for username input field
     * @param password - for password input field
     */
    public void loginUser(String username, String password){

        waitUntilElementIsVisible(usernameInput());
        usernameInput().clear();
        usernameInput().sendKeys(username);
        passwordInput().clear();
        passwordInput().sendKeys(password);
        loginBtn().click();
        waitUntilUrlContains(Constants.Choose_Profile);
        waitImplicit(2000);
    }

}
