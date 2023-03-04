package hu.ladybugs.pim;

import hu.ladybugs.driverfactory.DriverBaseTest;
import hu.ladybugs.pim.pages.AddEmployeePage;
import hu.ladybugs.pim.pages.ConfigurationPage;
import hu.ladybugs.pim.pages.EmployeeListPage;
import hu.ladybugs.pim.pages.ReportsPage;
import org.testng.annotations.Test;

public class ConfigurationTests extends DriverBaseTest {

    ConfigurationPage configurationPage;

    @Test(description = "Try 3 menu point of the Configuration dropdown.")
    public void configurationsDropDownMenuIsUsable(){
        configurationPage = new ConfigurationPage(driver,wait);
        configurationPage.login();
        configurationPage.navigateToPIMMenu();
        configurationPage.navigateToOptionalFieldsPage();
        configurationPage.navigateToCustomFieldsPage();
        configurationPage.navigateToReportingMethodsPage();

    }
}
