package hu.ladybugs.pim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigurationPage {
    WebDriver driver;

    WebDriverWait wait;

    public ConfigurationPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }
}
