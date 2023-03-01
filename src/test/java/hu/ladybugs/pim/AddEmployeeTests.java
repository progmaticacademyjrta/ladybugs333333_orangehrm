package hu.ladybugs.pim;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.pim.pages.AddEmployeePage;
import hu.ladybugs.pim.pages.EmployeeListPage;
import org.testng.annotations.Test;

public class AddEmployeeTests extends DriverBaseTest {

    AddEmployeePage addEmployeePage;
    EmployeeListPage employeeListPage;

    @Test(description = "")
    public void navigateToAddEmployeePage(){
        employeeListPage = new EmployeeListPage(driver,wait);
        addEmployeePage = new AddEmployeePage(driver,wait);
        employeeListPage.clickOnAddButton();
        addEmployeePage.saveANewEmployee();
        addEmployeePage.theNewEmployeeIsSearchable(); //felhasználónevet megváltoztatni minden futtatásnál, vagy törölni.
        addEmployeePage.theNewEmployeeCanBeDeleted();
        addEmployeePage.clearTheAddEmployeeDataWithCancelButton();
    }
}
