package MySecondProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	public class TestBrandPage {
	    WebDriver driver;
	    HomePage homePage;
	    ProductsPage productsPage;
	    BrandPage brandPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");
            homePage = new HomePage(driver);
	        productsPage = new ProductsPage(driver);
	        brandPage = new BrandPage(driver);
	    }

	    @Test
	    public void testBrandNavigation() throws InterruptedException {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click on 'Products' button
	        homePage.clickProducts();

	        // Verify that Brands are visible on left side bar
	        Assert.assertTrue(brandPage.areBrandsVisible(), "Brands are not visible on left side bar");

	        // Click on any brand name
	        String firstBrand = brandPage.getFirstBrandName();
	        
	        brandPage.clickFirstBrand();

	        // Verify that user is navigated to brand page and brand products are displayed
	        Assert.assertTrue(brandPage.isBrandPageVisible(), "User is not navigated to brand page or brand products are not displayed");

	        // On left side bar, click on any other brand link
	        String secondBrand = brandPage.getSecondBrandName();
	        brandPage.clickSecondBrand();

	        // Verify that user is navigated to that brand page and can see products
	        Assert.assertTrue(brandPage.isBrandPageVisible(), "User is not navigated to second brand page or brand products are not displayed");
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
}
