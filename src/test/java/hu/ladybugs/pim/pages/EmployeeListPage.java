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
        login();
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();
        System.out.println("Clicked on PIM menu point");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");

    }

    public void employeeInformationSearch() {
        login();
        //WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        //pimMenu.click();
        //System.out.println("Clicked on PIM menu point");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        navigateToPIMMenu();
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
}
