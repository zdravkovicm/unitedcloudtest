package test.Tests;

import main.java.Pages.ChooseProfile.ChooseProfilePage;
import main.java.Pages.CreateProfile.ProfileCreationPage;
import main.java.Pages.Login.LoginPage;
import main.java.Utils.BaseClass;
import main.java.Utils.Constants;
import main.java.Utils.Groups;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ProfileCreationIncorrectData extends BaseClass {

    public static final int AVATAR_INDEX = 20;

    //Pages
    ChooseProfilePage chooseProfilePage = new ChooseProfilePage();
    ProfileCreationPage profileCreationPage = new ProfileCreationPage();


    @Test(groups = Groups.PC, description = "Leave empty field for profile name")
    public void emptyProfileName(){

        //Testing Steps
        Reporter.log("Click Create New Profile");
        chooseProfilePage.clickCreateProfileBtn();
        Reporter.log("Set Profile Name to [" + Constants.emptyField + "]");
        profileCreationPage.setProfileName(Constants.emptyField);
        Reporter.log("Click Submit Profile");
        profileCreationPage.clickSubmitBtn();

        Reporter.log("Verify user is still on the page: " + Constants.Create_Profile_Page);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.Create_Profile_Page, "User is redirected to the next page," +
                "\nexpected URL to be: " + Constants.Create_Profile_Page +
                ".\nCurrent URL: " + driver.getCurrentUrl());
    }

    @Test(groups = Groups.PC, description = "Insert name longer than max number of characters")
    public void longProfileName(){

        //Testing Steps
        Reporter.log("Click Create New Profile");
        chooseProfilePage.clickCreateProfileBtn();
        Reporter.log("Set Profile Name to [" + Constants.longTerm + "]");
        profileCreationPage.setProfileName(Constants.longTerm);

        Reporter.log("Verify user can't use name longer than max number of characters");
        Assert.assertTrue(profileCreationPage.isNameLonger(),
                "Number of characters is longer than 32." +
                        "\nCurrent URL: " + driver.getCurrentUrl());
    }

    @Test(groups = Groups.PC, description = "Leave empty field year of birth")
    public void emptyYearOfBirth(){

        //Testing Steps
        Reporter.log("Click Create New Profile");
        chooseProfilePage.clickCreateProfileBtn();
        Reporter.log("Set Profile Name to [" + Constants.profileName + "]");
        profileCreationPage.setProfileName(Constants.profileName);
        profileCreationPage.selectAge(Constants.age_18);
        Reporter.log("Set User's Year of birth to [" + Constants.emptyField + "]");
        profileCreationPage.setYearOfBirth(Constants.emptyField);
        Reporter.log("Set User's Avatar to be the one with the index [" + AVATAR_INDEX + "]");
        profileCreationPage.selectAvatarByIndex(AVATAR_INDEX);
        Reporter.log("Click Submit Profile");
        profileCreationPage.clickSubmitBtn();

        Reporter.log("Verify user is still on the page: " + Constants.Create_Profile_Page);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.Create_Profile_Page, "User is redirected to the next page," +
                "\nexpected URL to be: " + Constants.Create_Profile_Page +
                ".\nCurrent URL: " + driver.getCurrentUrl());
    }



}
