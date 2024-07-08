package MySecondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	
	public class TestCategoryPage {
	    WebDriver driver;
	    HomePage homePage;
	    CategoryPage categoryPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");

	        homePage = new HomePage(driver);
	        categoryPage = new CategoryPage(driver);
	    }

	    @Test
	    public void testCategoryNavigation() {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Verify that categories are visible on left side bar
	        Assert.assertTrue(categoryPage.areCategoriesVisible(), "Categories are not visible on left side bar");

	        // Click on 'Women' category
	        categoryPage.clickWomenCategory();

	        // Click on any category link under 'Women' category, for example: Dress
	        categoryPage.clickWomenCategoryLink("Dress");

	        // Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
	        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("WOMEN - DRESS PRODUCTS"), "Category page is not displayed or text is incorrect");

	     // Click on 'Men' category
	        categoryPage.clickMenCategory();
	        
	        // On left side bar, click on any sub-category link of 'Men' category
	        categoryPage.clickMenSubCategory("Tshirts");

	        // Verify that user is navigated to that category page
	        Assert.assertTrue(categoryPage.isCategoryPageDisplayed("MEN - TSHIRTS PRODUCTS"), "User is not navigated to the Men category page");
	    }

	    @AfterMethod
	    public void tearDown() {
	       // driver.quit();
	    }
	}

