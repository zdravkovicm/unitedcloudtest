package main.java.Pages.ChooseProfile;

import main.java.Utils.BaseClass;
import main.java.Utils.WebElementLocator;
import main.java.Utils.WebElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static main.java.Utils.Constants.Create_Profile;

public class ChooseProfilePage extends BaseClass {

    // Web elements

    /**
     * Create new profile button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = ".button--primary")
    private static WebElement createProfileBtn() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ChooseProfilePage.class, "createProfileBtn")));
    }

    //Actions

    /**
     * Click 'Create Profile' Button
     *
     * @return Web element
     */
    public void clickCreateProfileBtn(){

        waitUntilElementIsClickable(createProfileBtn());
        createProfileBtn().click();
        waitUntilUrlContains(Create_Profile);
        waitImplicit(2000);
    }
}
