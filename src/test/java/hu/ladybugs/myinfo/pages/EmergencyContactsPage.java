package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmergencyContactsPage {
    WebDriver driver;
    WebDriverWait wait;

    public EmergencyContactsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
