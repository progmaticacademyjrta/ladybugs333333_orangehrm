package hu.ladybugs.pim;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.pim.pages.EmployeeListPage;
import org.testng.annotations.Test;

public class EmployeeListTests extends DriverBaseTest {

    EmployeeListPage employeeListPage;

    @Test(description = "")
    public void navigateToPIMPageAndSearchEmployeeInformationTest() {
        employeeListPage = new EmployeeListPage(driver,wait);
        //employeeListPage.loadLoginPage();
        employeeListPage.login();
        employeeListPage.navigateToPIMMenu();
        employeeListPage.employeeInformationSearch();
    }

    @Test (description = "")
    public void navigateToAddEmployeePageAndMakeTestsOnIt(){

        employeeListPage.clickOnAddButton();
    }

}
