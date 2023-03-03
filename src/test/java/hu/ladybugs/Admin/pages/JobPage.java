package hu.ladybugs.Admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class JobPage {
    WebDriver driver;
    WebDriverWait wait;

    public JobPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By jobMenuBy = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span");
    By jobTitlesSubmenuBy = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a");
    By jobTitleAddButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button");
    By jobTitleFieldBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    By jobTitleSaveButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]");
    By jobTitleCancelButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[1]");
    By pencilIconJobTitleBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i");
    By noteEditJobTitleBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea");
    By editJobTitleSaveButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]");
    By editJobTitleCancelButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[1]");
    By tickJobTitleBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i");
    By deleteSelectedJobTitleBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button");
    By deletePopUpJobTitleBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    By cancelPopUpJobTitleBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]");
    By recordsFoundJobTitleBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/span");

    public void navigateToJobJobTitleSubmenu() {
        WebElement jobMenu = driver.findElement(jobMenuBy);
        jobMenu.click();

        WebElement jobTitlesSubmenu = driver.findElement(jobTitlesSubmenuBy);
        jobTitlesSubmenu.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
        System.out.println("Navigating to Job menu Job Titles submenu was successful");
    }

    public void addNewJobTitle() throws InterruptedException {
        WebElement jobTitleAddButton = driver.findElement(jobTitleAddButtonBy);
        jobTitleAddButton.click();

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(499)+1;

        WebElement jobTitleField = driver.findElement(jobTitleFieldBy);
        jobTitleField.sendKeys(randomNumber + ". member of the council");

        WebElement jobTitleSaveButton = driver.findElement(jobTitleSaveButtonBy);
        jobTitleSaveButton.click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
        System.out.println("Adding new job title was successful.");
    }

    public void addNewJobTitleWithCancel() throws InterruptedException {
        WebElement jobTitleAddButton = driver.findElement(jobTitleAddButtonBy);
        jobTitleAddButton.click();

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(499)+1;

        WebElement jobTitleField = driver.findElement(jobTitleFieldBy);
        jobTitleField.sendKeys(randomNumber + ". member of the council");

        WebElement jobTitleCancelButton = driver.findElement(jobTitleCancelButtonBy);
        jobTitleCancelButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
        System.out.println("Cancel adding new job title was successful.");
    }

    public void editJobTitle() throws InterruptedException {
        WebElement pencilIconJobTitle = driver.findElement(pencilIconJobTitleBy);
        pencilIconJobTitle.click();

        WebElement noteEditJobTitle = driver.findElement(noteEditJobTitleBy);
        while (!noteEditJobTitle.getAttribute("value").equals("")) {
            noteEditJobTitle.sendKeys(Keys.BACK_SPACE);
        }
        Random randomGenerator = new Random();
        int percent = randomGenerator.nextInt(101);
        noteEditJobTitle.sendKeys("This type of job is very very important, he does " + percent + "% of the whole project.");

        WebElement editJobTitleSaveButton = driver.findElement(editJobTitleSaveButtonBy);
        Thread.sleep(3000);
        editJobTitleSaveButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
        System.out.println("Editing a job title was successful.");
    }

    public void editJobTitleWithCancel() throws InterruptedException {
        WebElement pencilIconJobTitle = driver.findElement(pencilIconJobTitleBy);
        pencilIconJobTitle.click();

        WebElement noteEditJobTitle = driver.findElement(noteEditJobTitleBy);

        Random randomGenerator = new Random();
        int percent = randomGenerator.nextInt(101);
        noteEditJobTitle.sendKeys("This type of job is very very important, he does " + percent + "% of the whole project.");

        WebElement editJobTitleCancelButton = driver.findElement(editJobTitleCancelButtonBy);
        Thread.sleep(10000);
        editJobTitleCancelButton.click();
        Thread.sleep(10000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");
        System.out.println("Cancel editing a job title was successful.");
    }

    public void deleteJobTitle() throws InterruptedException {
        WebElement recordsFoundJobTitle1 = driver.findElement(recordsFoundJobTitleBy);
        String recordFoundJobTitleString1 = recordsFoundJobTitle1.getText();

        WebElement tickJobTitle = driver.findElement(tickJobTitleBy);
        tickJobTitle.click();

        WebElement deleteSelectedJobTitle = driver.findElement(deleteSelectedJobTitleBy);
        deleteSelectedJobTitle.click();

        WebElement deletePopUpJobTitle = driver.findElement(deletePopUpJobTitleBy);
        deletePopUpJobTitle.click();

        WebElement recordFoundJobTitle2 = driver.findElement(recordsFoundJobTitleBy);
        String recordFoundJobTitleString2 = recordFoundJobTitle2.getText();
        Thread.sleep(5000);

        Assert.assertNotEquals(recordFoundJobTitleString1, recordFoundJobTitleString2);
        System.out.println("Deleting existing job title was successful.");
    }

    public void deleteJobTitleWithCancel() throws InterruptedException {
        WebElement recordsFoundJobTitle1 = driver.findElement(recordsFoundJobTitleBy);
        String recordFoundJobTitleString1 = recordsFoundJobTitle1.getText();

        WebElement tickJobTitle = driver.findElement(tickJobTitleBy);
        tickJobTitle.click();

        WebElement deleteSelectedJobTitle = driver.findElement(deleteSelectedJobTitleBy);
        deleteSelectedJobTitle.click();

        WebElement cancelPopUpJobTitle = driver.findElement(cancelPopUpJobTitleBy);
        cancelPopUpJobTitle.click();

        tickJobTitle.click();

        WebElement recordFoundJobTitle2 = driver.findElement(recordsFoundJobTitleBy);
        String recordFoundJobTitleString2 = recordFoundJobTitle2.getText();

        Thread.sleep(5000);
        Assert.assertEquals(recordFoundJobTitleString1, recordFoundJobTitleString2);
        System.out.println("Cancel deleting existing job title was successful.");
    }

}
