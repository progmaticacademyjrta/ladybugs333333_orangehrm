package hu.ladybugs.myinfo;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.myinfo.pages.PersonalDetailsPage;

import org.testng.annotations.Test;

public class PersonalDetailsTests extends DriverBaseTest {
    PersonalDetailsPage personalDetailsPage;


    @Test(description = "")
    public void loadHomePageAndLogin() {
        personalDetailsPage = new PersonalDetailsPage(driver, wait);
        personalDetailsPage.loadHomePage();
        personalDetailsPage.loginWhitValidUsernameAndValidPwd();
    }

    @Test(description = "")
    public void personalDetailsDataFillingAndSaving() throws InterruptedException {
        personalDetailsPage = new PersonalDetailsPage(driver, wait);
        personalDetailsPage.loadHomePage();
        personalDetailsPage.loginWhitValidUsernameAndValidPwd();
        personalDetailsPage.personalDetailsDataFillingAndSaving();
    }

   /* @Test(description = "")
    public void personalDetailsAttachmentsAdd() throws InterruptedException {
        personalDetailsPage = new PersonalDetailsPage(driver, wait);
        personalDetailsPage.loadHomePage();
        personalDetailsPage.loginWhitValidUsernameAndValidPwd();
        personalDetailsPage.attachmentsAdd();

    }*/

    @Test(description = "")
    public void recordsFoundDeleteFunction() throws InterruptedException {
        personalDetailsPage = new PersonalDetailsPage(driver, wait);
        personalDetailsPage.loadHomePage();
        personalDetailsPage.loginWhitValidUsernameAndValidPwd();
        personalDetailsPage.recordsFoundDelete();

    }
    @Test(description = "")
    public void recordsFoundDeleteFunctionCancelDelete() throws InterruptedException {
        personalDetailsPage = new PersonalDetailsPage(driver, wait);
        personalDetailsPage.loadHomePage();
        personalDetailsPage.loginWhitValidUsernameAndValidPwd();
        personalDetailsPage.recordsFoundDeleteCancel();

    }

}
