package hu.ladybugs.pim.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReportsPage {
    WebDriver driver;

    WebDriverWait wait;

    public ReportsPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }
    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5"));
        //Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Login page loaded properly.");
    }

    public void login() {
        loadLoginPage();
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        System.out.println("Clicked on login button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    public void navigateToPIMMenu(){
        //login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    public void navigateToReportsMenuPoint(){
        navigateToPIMMenu();
        WebElement reportsMenuPoint = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]"));
        reportsMenuPoint.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewDefinedPredefinedReports");
        System.out.println("Reports page is loaded successfully");
    }

    public void searchEmployeeReport() {
        WebElement reportName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/div[2]/div/div/input"));
        reportName.sendKeys("Employee");
        reportName.sendKeys(Keys.DOWN);
        reportName.sendKeys(Keys.DOWN);
        reportName.sendKeys(Keys.DOWN);
        reportName.sendKeys(Keys.RETURN);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchButton.click();
        System.out.println("The report was searched");
        WebElement recordFound = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div"));
        recordFound.isDisplayed();
        System.out.println("The record was found");
    }

    public void useAddButtonInReportsPage(){
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
        addButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/definePredefinedReport");
        System.out.println("Add report page is loaded successfully");
    }

    public void saveANewReport(){
        WebElement reportNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"));
        reportNameField.sendKeys("Example Report");
        WebElement selectionCriteriaDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/i"));
        selectionCriteriaDropDownArrow.click();
        WebElement selectionCriteriaDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]"));
        selectionCriteriaDropDown.sendKeys(Keys.DOWN);
        selectionCriteriaDropDown.sendKeys(Keys.DOWN);
        selectionCriteriaDropDown.sendKeys(Keys.RETURN);
        WebElement includeDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[2]/i"));
        includeDropDownArrow.click();
        WebElement includeDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]"));
        includeDropDown.sendKeys(Keys.DOWN);
        includeDropDown.sendKeys(Keys.DOWN);
        includeDropDown.sendKeys(Keys.RETURN);
        WebElement selectDisplayFieldGroupDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/div[2]/i"));
        selectDisplayFieldGroupDropDownArrow.click();
        WebElement selectDisplayFieldGroupDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/div[1]"));
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.RETURN);
        WebElement selectDisplayFieldDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div[1]/div[2]/div/div/div[2]/i"));
        selectDisplayFieldDropDownArrow.click();
        WebElement selectDisplayFieldDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div[1]/div[2]/div/div/div[1]"));
        selectDisplayFieldDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldDropDown.sendKeys(Keys.RETURN);
        WebElement displayFieldsAddButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div[2]/div[2]/button"));
        displayFieldsAddButton.click();
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", saveButton);
        saveButton.click();
        System.out.println("The new report has been saved");
    }

    public void theEmployeeReportsSearchingCanBeReset(){
        navigateToReportsMenuPoint();
        WebElement reportNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input"));
        reportNameField.sendKeys("E");
        reportNameField.sendKeys(Keys.DOWN);
        reportNameField.sendKeys(Keys.DOWN);
        reportNameField.sendKeys(Keys.RETURN);
        System.out.println("Report name field has been filled with "+reportNameField);
        WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]"));
        resetButton.click();
        resetButton.click();
        System.out.println("Clicked on the Reset button");
        Assert.assertEquals(reportNameField.getText(), "Type for hints...");
        System.out.println("Reseted the searching informations.");
    }

    public void clearTheAddReportDataWithCancelButton(){
        useAddButtonInReportsPage();
        WebElement reportNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div/div/div[2]/div/div/input"));
        reportNameField.sendKeys("Example Report");
        WebElement selectionCriteriaDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/i"));
        selectionCriteriaDropDownArrow.click();
        WebElement selectionCriteriaDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]"));
        selectionCriteriaDropDown.sendKeys(Keys.DOWN);
        selectionCriteriaDropDown.sendKeys(Keys.DOWN);
        selectionCriteriaDropDown.sendKeys(Keys.RETURN);
        WebElement includeDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[2]/i"));
        includeDropDownArrow.click();
        WebElement includeDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]"));
        includeDropDown.sendKeys(Keys.DOWN);
        includeDropDown.sendKeys(Keys.DOWN);
        includeDropDown.sendKeys(Keys.RETURN);
        WebElement selectDisplayFieldGroupDropDownArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/div[2]/i"));
        selectDisplayFieldGroupDropDownArrow.click();
        WebElement selectDisplayFieldGroupDropDown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/div/div/div[1]"));
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.DOWN);
        selectDisplayFieldGroupDropDown.sendKeys(Keys.RETURN);
        WebElement cancelButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[1]"));
        cancelButton.click();
        System.out.println("Clicked on the Cancel button");
        Assert.assertEquals(selectionCriteriaDropDown.getText(), "-- Select --");
        System.out.println("Canceled the informations.");
    }
}
