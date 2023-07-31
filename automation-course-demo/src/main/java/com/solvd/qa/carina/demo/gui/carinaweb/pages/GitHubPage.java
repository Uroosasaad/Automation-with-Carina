package com.solvd.qa.carina.demo.gui.carinaweb.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GitHubPage extends AbstractPage {

    protected GitHubPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

}
