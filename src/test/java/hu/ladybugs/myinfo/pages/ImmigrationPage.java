package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImmigrationPage {
    WebDriver driver;
    WebDriverWait wait;

    public ImmigrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
