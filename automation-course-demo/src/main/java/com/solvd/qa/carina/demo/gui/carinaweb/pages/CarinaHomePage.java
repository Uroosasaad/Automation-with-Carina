package com.solvd.qa.carina.demo.gui.carinaweb.pages;

import com.solvd.qa.carina.demo.gui.carinaweb.components.footer.CarinaFooterMenu;
import com.solvd.qa.carina.demo.gui.carinaweb.components.header.CarinaHeaderMenu;
import com.solvd.qa.carina.demo.gui.carinaweb.components.navigation.CarinaNavigationPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CarinaHomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//header")
    private CarinaHeaderMenu Header;

    @FindBy(xpath = "//footer")
    private CarinaFooterMenu FooterMenu;
    @FindBy(xpath = "//div[@class='md-sidebar md-sidebar--primary']")
    private CarinaNavigationPage Navigation;

    @FindBy(xpath = "")
    private ExtendedWebElement OverviewHeader;

    public CarinaHomePage(WebDriver driver) {
        super(driver);
    }

    public CarinaHeaderMenu getHeader() {
        return Header;
    }

    public CarinaFooterMenu getFooterMenu() {
        return FooterMenu;
    }

    public CarinaNavigationPage getNavigationPage() {
        return Navigation;
    }

    public boolean checkIfOverviewHeaderPresent() {
        Navigation.clickMigrationGuideLink();
        Header.clickOnZebrunnerLogo();
        return OverviewHeader.isVisible();
    }

    public boolean checkIfHeaderAttachedToTopOfPage() {
            return Header.getHeaderPanel().isElementPresent();
    }
}
