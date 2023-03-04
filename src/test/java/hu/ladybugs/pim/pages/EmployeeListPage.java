package hu.ladybugs.pim.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmployeeListPage {
    WebDriver driver;

    WebDriverWait wait;

    public EmployeeListPage(WebDriver driver, WebDriverWait wait){

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
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");

    }

    public void employeeInformationSearch() {
        //login();
        //WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        //pimMenu.click();
        //System.out.println("Clicked on PIM menu point");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        //navigateToPIMMenu();
        WebElement employeeNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        employeeNameField.sendKeys("David Morris");
        WebElement employeeIdField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        employeeIdField.sendKeys("0066");
        WebElement selectArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i"));
        selectArrow.click();
        WebElement selectEmploymentStatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.RETURN);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchButton.click();
        System.out.println("Clicked on Search button");
        WebElement recordFoundTable = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recordFoundTable);
        //recordFoundScroll.sendKeys(Keys.PAGE_DOWN);
        System.out.println("Scrolled down in the page");
        Assert.assertEquals("Morris", driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]")).getText());
        System.out.println("The searched item is same as the found item.");
    }

    public void clickOnAddButton(){
        login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
        addButton.click();
        System.out.println("Clicked on the +Add button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
        System.out.println("The Add Employee page is loaded successfully");
    }

    public void clearTheSearchInformations() throws InterruptedException {
        WebElement employeeNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        employeeNameField.sendKeys("David Morris");
        WebElement employeeIdField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        employeeIdField.sendKeys("0066");
        WebElement selectArrow = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i"));
        selectArrow.click();
        WebElement selectEmploymentStatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.DOWN);
        selectEmploymentStatus.sendKeys(Keys.RETURN);

        WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]"));
        resetButton.click();
        Thread.sleep(5000);
        System.out.println("Clicked on the Reset button");
        employeeIdField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        System.out.println(employeeIdField);
        Thread.sleep(5000);
        Assert.assertEquals(employeeIdField.getText(), "");
        System.out.println("Deleted the informations.");
    }

    public void deleteRecord(){
        navigateToPIMMenu();
        WebElement recordsFoundTitle1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        String recordFoundJobTitleString1 = recordsFoundTitle1.getText();
        WebElement tickRecordBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span"));
        tickRecordBox.click();
        WebElement deleteSelectedRecordTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button"));
        deleteSelectedRecordTitle.click();
        WebElement acceptPopUp = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
        acceptPopUp.click();
        WebElement recordsFoundTitle2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        String recordFoundJobTitleString2 = recordsFoundTitle2.getText();
        Assert.assertNotEquals(recordFoundJobTitleString1, recordFoundJobTitleString2);
        System.out.println("Deleting was successful.");
    }

    public void editRecord(){       //!
        navigateToPIMMenu();
        WebElement editIcon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]"));
        editIcon.click();
        System.out.println("Clicked on the edit button.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/37");
        WebElement idField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        while (!idField.getAttribute("value").equals("")) {
            idField.sendKeys(Keys.BACK_SPACE);
        }
        idField.sendKeys("123");
        System.out.println("Filled the field with 123");
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button"));
        saveButton.click();
        System.out.println("Saved");
        WebElement employeeListMenuPoint = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]"));
        employeeListMenuPoint.click();
        WebElement recordsFoundTitle1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        String recordFoundJobTitleString1 = recordsFoundTitle1.getText();
        WebElement employeeIdField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        employeeIdField.sendKeys("123");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchButton.click();
        WebElement recordFoundTable = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recordFoundTable);
        System.out.println("Scrolled down in the page");
        WebElement recordsFoundTitle2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        String recordFoundJobTitleString2 = recordsFoundTitle2.getText();
        Assert.assertNotEquals(recordFoundJobTitleString1, recordFoundJobTitleString2);
        System.out.println("Editing was successful.");
    }
}
