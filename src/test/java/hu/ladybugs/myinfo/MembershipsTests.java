package hu.ladybugs.myinfo;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.myinfo.pages.MembershipsPage;
import org.testng.annotations.Test;

public class MembershipsTests extends DriverBaseTest {
    MembershipsPage membershipsPage;

    @Test
    public void membershipsAssignedMembershipsAdd() throws InterruptedException {
        membershipsPage=new MembershipsPage(driver,wait);
        membershipsPage.loadHomePage();
        membershipsPage.loginWhitValidUsernameAndValidPwd();
        membershipsPage.assignedMembershipsAdd();

    }

}
