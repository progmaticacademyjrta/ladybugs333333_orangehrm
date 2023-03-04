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

    @Test(description = "Navigate to Reports page and make tests on it.")
    public void navigateToReportsPage() throws InterruptedException {
        employeeListPage = new EmployeeListPage(driver, wait);
        addEmployeePage = new AddEmployeePage(driver, wait);
        reportsPage = new ReportsPage(driver,wait);
        reportsPage.login();
        reportsPage.navigateToPIMMenu();
        reportsPage.navigateToReportsMenuPoint();
        reportsPage.searchEmployeeReport();
        reportsPage.useAddButtonInReportsPage();
        reportsPage.saveANewReport();
        reportsPage.theEmployeeReportsSearchingCanBeReset();
        reportsPage.clearTheAddReportDataWithCancelButton();
    }
}
