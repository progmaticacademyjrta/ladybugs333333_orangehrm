package hu.ladybugs.pim;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.pim.pages.EmployeeListPage;
import org.testng.annotations.Test;

public class EmployeeListTests extends DriverBaseTest {

    EmployeeListPage employeeListPage;

    @Test(description = "Navigate to Employee List page and make tests on it.")
    public void navigateToPIMPageAndSearchEmployeeInformationTest() throws InterruptedException {
        employeeListPage = new EmployeeListPage(driver,wait);
        employeeListPage.login();
        employeeListPage.navigateToPIMMenu();
        employeeListPage.employeeInformationSearch();
        employeeListPage.clearTheSearchInformations();
        employeeListPage.deleteRecord();
        employeeListPage.editAlreadyExsistingRecord();
    }

    @Test (description = "Navigate to Employee List page and use Add button.")
    public void navigateToEmployeeListPageAndUseAddButton(){

        employeeListPage.clickOnAddButton();
    }

}
