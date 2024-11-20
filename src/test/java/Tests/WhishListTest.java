package Tests;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.Login;
import Pages.WhishPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WhishListTest extends TestBase {
    Login loginPage;
    HomePage homePage;
    WhishPage whishPage;
    ComparePage comparePage;

    @BeforeMethod
    public void setup() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage = new Login(driver);
        homePage = new HomePage(driver);
        whishPage = new WhishPage(driver);
        comparePage = new ComparePage(driver);
    }

    @Test
    public void assertEmptyWishlist() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        whishPage.navigateToWhishList();
        whishPage.emptywishlist();
    }

    @Test
    public void assertAddTowWHISHListWithLogin() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        int numOfElems = homePage.addItemsToWishlist();
        int assertnum = whishPage.numberofelements();
        Assert.assertEquals(numOfElems, assertnum);
    }

    @Test
    public void assertAddTowWHISHList() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        homePage.addItemsToWishlist();
        whishPage.assertelement();
    }
}
