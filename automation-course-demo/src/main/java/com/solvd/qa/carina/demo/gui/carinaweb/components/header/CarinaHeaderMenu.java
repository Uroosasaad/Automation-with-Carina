package com.solvd.qa.carina.demo.gui.carinaweb.components.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class CarinaHeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//header//img[@alt='logo']")
    private ExtendedWebElement ZebrunnerLogo;

    @FindBy(xpath = "//span[@class='md-header-nav__topic md-ellipsis'][1]")
    private ExtendedWebElement CarinaTitle;

    @FindBy(xpath = "//div[@data-md-component='search']")
    private ExtendedWebElement SearchBox;

    @FindBy(xpath = "//div[@data-md-component='search']")
    private ExtendedWebElement SearchIcon;

    @FindBy(xpath = "//div[@data-md-component='search']//input[@placeholder='Search']")
    private ExtendedWebElement SearchText;

    @FindBy(xpath = "//header//a[@title='Go to repository']")
    private ExtendedWebElement GitHubLink;

    @FindBy(xpath = "//nav[@class='md-header-nav md-grid']")
    private ExtendedWebElement HeaderPanel;


    public CarinaHeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean checkIfLogoExists() {
        return ZebrunnerLogo.isElementPresent();
    }

    public boolean clickOnZebrunnerLogo() {
         ZebrunnerLogo.click();
        return true;
    }

    public boolean checkSearchComponentExists() {
        return SearchBox.isPresent();
    }


    public boolean checkIfCarinaTitlePresentOnHeader() {
        return CarinaTitle.getText().equalsIgnoreCase("Carina");
    }

    public boolean CheckSearchComponentOnHeader() {
        boolean CheckSearchBox = SearchBox.isElementPresent();
        boolean CheckSearchIcon = SearchIcon.isElementPresent();
        boolean CheckSearchText = SearchText.isElementPresent();

        return CheckSearchBox && CheckSearchIcon && CheckSearchText;
    }

    public String getSearchText() {
        return SearchText.getAttribute("PlaceHolder");
    }

    public boolean getGitHubLink() {
        return GitHubLink.isPresent();
    }

    public boolean checkIfLinkRedirectsToGitHubLink() {
        return GitHubLink.getAttribute("href").equalsIgnoreCase("https://github.com/zebrunner/carina/");
    }


    public ExtendedWebElement getHeaderPanel() {
        return HeaderPanel;
    }
}
