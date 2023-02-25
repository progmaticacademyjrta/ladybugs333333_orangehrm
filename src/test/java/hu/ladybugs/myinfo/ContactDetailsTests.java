package hu.ladybugs.myinfo;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.myinfo.pages.ContactDetailsPage;
import org.testng.annotations.Test;

public class ContactDetailsTests extends DriverBaseTest {
    ContactDetailsPage contactDetailsPage;

    @Test
    public void contactDetailsFillingAndSaving() throws InterruptedException {
        contactDetailsPage = new ContactDetailsPage(driver, wait);
        contactDetailsPage.loadHomePage();
        contactDetailsPage.loginWhitValidUsernameAndValidPwd();
        contactDetailsPage.contactDetailsFillingAndSaving();

    }


}
