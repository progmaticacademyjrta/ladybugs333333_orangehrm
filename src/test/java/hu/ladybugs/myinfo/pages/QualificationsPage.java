package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualificationsPage {
    WebDriver driver;
    WebDriverWait wait;

    public QualificationsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
