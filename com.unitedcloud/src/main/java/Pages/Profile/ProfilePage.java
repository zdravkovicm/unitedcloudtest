package main.java.Pages.Profile;

import main.java.Utils.BaseClass;
import main.java.Utils.WebElementLocator;
import main.java.Utils.WebElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BaseClass {

    /**
     * User's Wrapper with avatar and details
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = ".card")
    public static WebElement userCard() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfilePage.class, "userCard")));
    }

    /**
     * Delete Profile Button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = ".card__delete")
    private static WebElement deleteProfileBtn() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfilePage.class, "deleteProfileBtn")));
    }


    //Actions

    /**
     * Click On Delete Profile Button
     *
     */
    public void deleteProfile(){
        waitImplicit(2000);
        waitUntilElementIsVisible(deleteProfileBtn());
        waitUntilElementIsClickable(deleteProfileBtn());
        deleteProfileBtn().click();
        waitImplicit(2000);
    }
}
