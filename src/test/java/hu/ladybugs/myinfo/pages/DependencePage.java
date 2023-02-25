package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DependencePage {
    WebDriver driver;
    WebDriverWait wait;

    public DependencePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
