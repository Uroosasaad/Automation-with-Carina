package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.gui.carinaweb.pages.CarinaHomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarinaDocsWebTest implements IAbstractTest {

    private CarinaHomePage OpenCarinaPage() {
        CarinaHomePage homePage = new CarinaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Carina Home page is not opened");
        return homePage;
    }

    @Test
    public void testZebRunnerLogo(){
        CarinaHomePage homePage = OpenCarinaPage();
        Assert.assertTrue(homePage.getHeader().checkIfLogoExists(),"ZebRunner logo does not exist!");
        Assert.assertTrue(homePage.getHeader().clickOnZebrunnerLogo(), "Clicking on Logo Redirects to different page");
    }

    @Test
    public void testCarinaBrand() {
        Assert.assertTrue(OpenCarinaPage().getHeader().checkIfCarinaTextPresentOnHeader(), "Carina title is not present on header");
    }

    @Test
    public void testSearchComponent() {
        CarinaHomePage homePage = OpenCarinaPage();
        Assert.assertTrue(homePage.getHeader().CheckSearchComponentOnHeader(),"Search component not present");
        Assert.assertTrue(homePage.getHeader().getSearchText(), "'Search' text is not place holder!");
    }

    @Test
    public void testGitHubLink() {
        CarinaHomePage homePage = OpenCarinaPage();
        Assert.assertTrue(homePage.getHeader().getGitHubLink(),"Git hub Link not present");
        Assert.assertTrue(homePage.getHeader().checkIfLinkRedirectsToGitHubLink(), "GitHub link does not point to carina github page");
    }

    @Test
    public void testIfHeaderIsSticky() {
        CarinaHomePage homePage = OpenCarinaPage();
        boolean isPageScrolled = homePage.getFooterMenu().ScrollDownToFooterMenu();
        boolean isHeaderPresent = homePage.checkIfHeaderAttachedToTopOfPage();
        Assert.assertTrue(isPageScrolled && isHeaderPresent, "Header is not attached to top of the page");
    }

    @Test
    public void testNavigationHiddenComponents() {
        CarinaHomePage homePage = OpenCarinaPage();
        Assert.assertTrue(homePage.getNavigationPage().ClickOnParentRevealsChildElements(),"Clicking On Parent Does Not Reveals Child Element");
        Assert.assertTrue(homePage.getNavigationPage().CheckIfSomeElementsAreHidden(),"All Elements Are Visible ");
    }

    @Test
    public void testNavigationValidation() {
        CarinaHomePage homePage = OpenCarinaPage();
        Assert.assertTrue(homePage.getNavigationPage().checkIfCarinaHeadingIsFirstElement(),"Carina Tag is not the first element in navigation menu");
        Assert.assertTrue(homePage.getNavigationPage().checkIfListOfNavigationLinkPresent(),"List of navigation menu does not exist!");
        Assert.assertTrue(homePage.getNavigationPage().checkCurrentPageLinkHighlighted(),"Currently selected page is not highlighted");

    }

}
