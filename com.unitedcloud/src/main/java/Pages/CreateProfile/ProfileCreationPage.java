package main.java.Pages.CreateProfile;

import main.java.Utils.BaseClass;
import main.java.Utils.WebElementLocator;
import main.java.Utils.WebElementLocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileCreationPage extends BaseClass {

    // Web elements

    /**
     * Profile Name Input Field
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#profile-name")
    private static WebElement profileNameInputField() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "profileNameInputField")));
    }

    /**
     * Profile Name Input Field
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "button[type='submit']")
    private static WebElement submitBtn() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "submitBtn")));
    }

    /**
     * Age 0 - 6 button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#AGE_0_6")
    private static WebElement age0() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "age0")));
    }

    /**
     * Age 7 - 11 button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#AGE_7_11")
    private static WebElement age7() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "age7")));
    }

    /**
     * Age 12 - 14 button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#AGE_12_14")
    private static WebElement age12() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "age12")));
    }

    /**
     * Age 15 - 17 button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#AGE_15_17")
    private static WebElement age15() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "age15")));
    }

    /**
     * Age 18+ Button
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#AGE_18_PLUS")
    private static WebElement age18() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "age18")));
    }

    /**
     * Year of Birth Input Field
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = "#year")
    private static WebElement yearOfBirthInputField() {
        return driver.findElement(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "yearOfBirthInputField")));
    }

    /**
     * List of Avatars displayed
     *
     * @return Web element
     */
    @WebElementLocator(webDesktop = ".avatars .avatar")
    private static List<WebElement> avatarsList() {
        return driver.findElements(By.cssSelector(new WebElementLocatorFactory().getLocator(ProfileCreationPage.class, "avatarsList")));
    }


    //Actions

    /**
     * Set Profile Name to provided value
     *
     * @param profileName - name to be used
     */
    public void setProfileName(String profileName){

        waitUntilElementIsVisible(profileNameInputField());
        profileNameInputField().clear();
        profileNameInputField().sendKeys(profileName);
        waitImplicit(2000);
    }

    /**
     * Click submit button
     *
     */
    public void clickSubmitBtn(){

        waitUntilElementIsClickable(submitBtn());
        submitBtn().click();
        waitImplicit(2000);
    }

    /**
     * Get value set in the Profile Name input field
     *
     * @return profile name input text
     */
    public String getProfileNameInputFieldValue(){

        return profileNameInputField().getAttribute("value");
    }

    /**
     * Check if inputted value for profile name is not longer than max number of characters (32)
     *
     * @return boolean
     */
    public boolean isNameLonger(){

        return getProfileNameInputFieldValue().length() <= 32;
    }

    /**
     * Select User's Age based on provided value
     *
     * @param age - Age to select
     */
    public void selectAge(String age){

        switch (age) {
            case "0-6":
                age0().click();
                waitImplicit(2000);
            case "7-11":
                age7().click();
                waitImplicit(2000);
            case "12-14":
                age12().click();
                waitImplicit(2000);
            case "15-17":
                age15().click();
                waitImplicit(2000);
            case "18+":
                jsElementClick(age18());
                waitImplicit(2000);
            default:
                System.out.println("Value not supported");
        }

    }

    /**
     * Set year of birth to provided value
     *
     * @param year - year to be used
     */
    public void setYearOfBirth(String year){

        waitUntilElementIsVisible(yearOfBirthInputField());
        yearOfBirthInputField().clear();
        yearOfBirthInputField().sendKeys(year);
        waitImplicit(2000);
    }

    /**
     * Select Avatar By given index
     *
     * @param index - index of the avatar to be selected
     */
    public void selectAvatarByIndex(int index){

        waitUntilElementIsClickable(avatarsList().get(index));
        avatarsList().get(index).click();
        waitImplicit(2000);
    }
}
