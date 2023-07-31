package com.solvd.qa.carina.demo.gui.carinaweb.pages;

import com.solvd.qa.carina.demo.gui.carinaweb.components.footer.CarinaFooterMenu;
import com.solvd.qa.carina.demo.gui.carinaweb.components.header.CarinaHeaderMenu;
import com.solvd.qa.carina.demo.gui.carinaweb.components.navigation.CarinaNavigationPage;
import com.solvd.qa.carina.demo.gui.carinaweb.pages.commons.CarinaHomePageBase;
import com.solvd.qa.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.CarinaDriver;
import com.zebrunner.carina.webdriver.TestPhase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.device.Device;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

//@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CarinaHomePageBase.class)
public class CarinaHomePage extends CarinaHomePageBase {

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

//    @Override
//    public CarinaNavigationPage getNavigation() {
//        return Navigation;
//    }

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
