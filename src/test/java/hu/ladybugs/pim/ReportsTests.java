package hu.ladybugs.pim;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.pim.pages.AddEmployeePage;
import hu.ladybugs.pim.pages.EmployeeListPage;
import hu.ladybugs.pim.pages.ReportsPage;
import org.testng.annotations.Test;

public class ReportsTests extends DriverBaseTest {

    AddEmployeePage addEmployeePage;
    EmployeeListPage employeeListPage;
    ReportsPage reportsPage;

    @Test(description = "")
    public void navigateToReportsPage() {
        employeeListPage = new EmployeeListPage(driver, wait);
        addEmployeePage = new AddEmployeePage(driver, wait);
        reportsPage = new ReportsPage(driver,wait);
        reportsPage.navigateToReportsMenuPoint();
        reportsPage.searchEmployeeReport();
        reportsPage.useAddButtonInReportsPage();
        reportsPage.saveANewReport();
        reportsPage.theNewReportIsSearchable();
    }
}
