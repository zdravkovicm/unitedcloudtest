package test.Tests;

import main.java.Pages.ChooseProfile.ChooseProfilePage;
import main.java.Pages.CreateProfile.ProfileCreationPage;
import main.java.Pages.Profile.ProfilePage;
import main.java.Utils.BaseClass;
import main.java.Utils.Constants;
import main.java.Utils.DateUtils;
import main.java.Utils.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ProfileCreationTest extends BaseClass {

    //Pages
    ChooseProfilePage chooseProfilePage = new ChooseProfilePage();
    ProfileCreationPage profileCreationPage = new ProfileCreationPage();
    DateUtils dateUtils = new DateUtils();
    ProfilePage profilePage = new ProfilePage();

    public static final int AVATAR_INDEX = 20;

    @Test(groups = Groups.PC, description = "Create profile successfully and delete it after it")
    public void profileCreation(){

        //Testing Steps
        Reporter.log("Click Create New Profile");
        chooseProfilePage.clickCreateProfileBtn();

        Reporter.log("Verify user is redirected to: " + Constants.Create_Profile_Page);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.Create_Profile_Page, "User is not redirected to correct page," +
                "\nexpected URL to be: " + Constants.Create_Profile_Page +
                ".\nCurrent URL: " + driver.getCurrentUrl());

        Reporter.log("Set Profile Name to [" + Constants.profileName + "]");
        profileCreationPage.setProfileName(Constants.profileName);
        Reporter.log("Set User's Age to [" + Constants.age_18 + "]");
        profileCreationPage.selectAge(Constants.age_18);
        Reporter.log("Set User's Year of birth to [" + dateUtils.correctYear() + "]");
        profileCreationPage.setYearOfBirth(dateUtils.correctYear());
        Reporter.log("Set User's Avatar to be the one with the index [" + AVATAR_INDEX + "]");
        profileCreationPage.selectAvatarByIndex(AVATAR_INDEX);
        Reporter.log("Click Submit Profile");
        profileCreationPage.clickSubmitBtn();

        Reporter.log("Verify user successfully created profile");
        Assert.assertTrue(isElementDisplayed(ProfilePage.userCard()), "User didn't create profile." +
                "\nCurrent URL: " + driver.getCurrentUrl());

        Reporter.log("Click Delete Profile");
        profilePage.deleteProfile();

        Assert.assertTrue(waitUntilUrlContainsBool(Constants.Choose_Profile), "User is not redirected to correct page," +
                "\nexpected URL to contains: " + Constants.Choose_Profile +
                ".\nCurrent URL: " + driver.getCurrentUrl());
    }


}
