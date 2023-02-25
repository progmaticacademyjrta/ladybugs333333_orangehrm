package hu.ladybugs.Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobPage {
    WebDriver driver;
    WebDriverWait wait;

    public JobPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
