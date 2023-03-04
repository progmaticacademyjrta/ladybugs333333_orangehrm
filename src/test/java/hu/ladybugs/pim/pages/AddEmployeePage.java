package hu.ladybugs.pim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddEmployeePage {

    WebDriver driver;

    WebDriverWait wait;

    public AddEmployeePage(WebDriver driver, WebDriverWait wait){

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
        login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
    }

    public void clickOnAddButton(){
        /*login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        */WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
        addButton.click();
        System.out.println("Clicked on the +Add button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
        System.out.println("The Add Employee page is loaded successfully");
    }

    public void saveANewEmployee(){
        /*login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        //navigateToPIMMenu();
        clickOnAddButton();*/
        WebElement newEmployeeFirstName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
        newEmployeeFirstName.sendKeys("Kate");
        WebElement newEmployeeLastName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
        newEmployeeLastName.sendKeys("House");
        WebElement fileUploadInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button"));
        String path = System.getProperty("user.dir");
        System.out.println("Working Directory = " + path);
        fileUploadInput.sendKeys(path+ "\\C:\\Users\\Kinga\\Documents\\bee.jpeg");
        System.out.println("Photo upload was successfully");
        WebElement createLoginDetailsSwitchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
        createLoginDetailsSwitchButton.click();
        System.out.println("Clicked on the Login Details switch");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        username.sendKeys("kateHouse0123");
        WebElement status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/label/span"));
        status.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", password);
        System.out.println("Scrolled down");
        password.sendKeys("secretPassword-0123");
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
        confirmPassword.sendKeys("secretPassword-0123");
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView();", saveButton);
        saveButton.click();
        System.out.println("Clicked on the Save button");
        WebElement personalDetails = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6"));
        personalDetails.isDisplayed();
        System.out.println("The new employee is saved");
    }

    public void theNewEmployeeIsSearchable(){
        //saveANewEmployee();
        WebElement employeeListMenuPoint = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
        employeeListMenuPoint.click();
        WebElement employeeNameField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        employeeNameField.sendKeys("Kate House");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchButton.click();
        System.out.println("Clicked on Search button");
        WebElement recordFound1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        recordFound1.isDisplayed();
    }

    public void theNewEmployeeCanBeDeleted(){
        //theNewEmployeeIsSearchable();
        WebElement trashBinIcon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]"));
        trashBinIcon.click();
        System.out.println("Clicked on the trash bin icon");
        WebElement popUpWindowDelete = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
        popUpWindowDelete.click();
        System.out.println("The employee has been deleted");
    }

    public void clearTheAddEmployeeDataWithCancelButton(){
        clickOnAddButton();
        WebElement newEmployeeFirstName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
        newEmployeeFirstName.sendKeys("Kate");
        WebElement newEmployeeLastName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
        newEmployeeLastName.sendKeys("House");
        WebElement fileUploadInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button"));
        String path = System.getProperty("user.dir");
        System.out.println("Working Directory = " + path);
        fileUploadInput.sendKeys(path+ "\\C:\\Users\\Kinga\\Documents\\bee.jpeg");
        System.out.println("Photo upload was successfully");
        WebElement createLoginDetailsSwitchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
        createLoginDetailsSwitchButton.click();
        System.out.println("Clicked on the Login Details switch");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        username.sendKeys("kateHouse0123");
        WebElement status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/label/span"));
        status.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", password);
        System.out.println("Scrolled down");
        password.sendKeys("secretPassword-0123");
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
        confirmPassword.sendKeys("secretPassword-0123");
        WebElement cancelButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));
        cancelButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        System.out.println("Navigated to Employee List page successfully");
    }
}
