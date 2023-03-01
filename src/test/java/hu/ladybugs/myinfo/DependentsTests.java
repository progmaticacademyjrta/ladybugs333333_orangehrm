package hu.ladybugs.myinfo;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.myinfo.pages.DependencePage;
import org.testng.annotations.Test;

public class DependentsTests extends DriverBaseTest {
    DependencePage dependencePage;


    @Test
    public void dependentEnteringDataAndSave() throws InterruptedException {
        dependencePage=new DependencePage(driver,wait);
        dependencePage.loadHomePage();
        dependencePage.loginWhitValidUsernameAndValidPwd();
        dependencePage.dependentEnteringDataAndSaveIt();



    }
}
