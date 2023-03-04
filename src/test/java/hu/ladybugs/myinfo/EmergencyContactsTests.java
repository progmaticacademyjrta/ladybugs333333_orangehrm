package hu.ladybugs.myinfo;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.myinfo.pages.EmergencyContactsPage;
import org.testng.annotations.Test;

public class EmergencyContactsTests extends DriverBaseTest {
    EmergencyContactsPage emergencyContactsPage;

    @Test
    public void assignedEmergencyContactsAdd() throws InterruptedException {
        emergencyContactsPage = new EmergencyContactsPage(driver, wait);
        emergencyContactsPage.loadHomePage();
        emergencyContactsPage.loginWhitValidUsernameAndValidPwd();
        emergencyContactsPage.addNewEmergencyContacts();
    }

    @Test
    public void emergencyContactsRecordsDeleteFunction() throws InterruptedException {
        emergencyContactsPage = new EmergencyContactsPage(driver, wait);
        emergencyContactsPage.loadHomePage();
        emergencyContactsPage.loginWhitValidUsernameAndValidPwd();
        emergencyContactsPage.RecordsDeleteFunction();

    }

    @Test
    public void emergencyContactsRecordsDeleteFunctionCancel() throws InterruptedException {
        emergencyContactsPage = new EmergencyContactsPage(driver, wait);
        emergencyContactsPage.loadHomePage();
        emergencyContactsPage.loginWhitValidUsernameAndValidPwd();
        emergencyContactsPage.RecordsDeleteFunctionCancel();

    }

    @Test
    public void emergencyContactsRecordsFoundEditingFunction() throws InterruptedException {
        emergencyContactsPage = new EmergencyContactsPage(driver, wait);
        emergencyContactsPage.loadHomePage();
        emergencyContactsPage.loginWhitValidUsernameAndValidPwd();
        emergencyContactsPage.recordsFoundEditingFunction();

    }
}
