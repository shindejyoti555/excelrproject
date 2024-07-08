package MySecondProject;

    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import org.testng.Assert;
		import org.testng.annotations.AfterMethod;
		import org.testng.annotations.BeforeMethod;
		import org.testng.annotations.Test;
		import io.github.bonigarcia.wdm.WebDriverManager;

		import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	public class TestHomepage {
		    WebDriver driver;
		    HomePage homePage;
		    WebDriverWait wait;
		    ProductsPage productsPage;
		    SubscriptionPage subscriptionPage;
		    CartPage cartPage;

		    @BeforeMethod
		    public void setUp() {
		    	driver = new FirefoxDriver();
		    	driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        driver.get("http://automationexercise.com");
		        homePage = new HomePage(driver);
		        productsPage = new ProductsPage(driver);
		        subscriptionPage =new SubscriptionPage(driver);
		        cartPage = new CartPage(driver);
		    }

		    //Test to verify Test Cases Page
		    
		    @Test
		    public void testContactUs() {
	    	
		    	// Click on 'Test Cases' button
		        homePage.clickTestCases();
		        
		        // Verify 'Test Cases' are visible
		        Assert.assertTrue(homePage.isTestCasesVisible(), "Test Cases are not visible");
	        
	//verify search field in product page
		        
		     // Click on 'Products' button
		        homePage.clickProducts();
		        
		     // Enter product name in search input
		        productsPage.enterProductNameInSearch("dress");

		        // Click the search button
		        productsPage.clickSearchButton();

		        // Verify 'SEARCHED PRODUCTS' is visible
		        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' is not visible");

		        // Verify all the products related to search are visible
		        Assert.assertTrue(productsPage.areSearchedProductsVisible(), "Searched products are not visible");
		    }
		    
	//Test case to verify recommended product add in cart and then remove from cart
		    
		    @Test
		    public void testAddRecommendedItemToCart() throws InterruptedException {
		        // Verify that home page is visible successfully
		        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

		        // Scroll to bottom of the home page
		        subscriptionPage.scrollToBottom();

		        // Verify 'RECOMMENDED ITEMS' are visible
		        Assert.assertTrue(homePage.isRecommendedItemsVisible(), "'RECOMMENDED ITEMS' are not visible");

		        // Click on 'Add To Cart' on Recommended product
		        homePage.addToCartRecommendedItem();

		        // Click on 'View Cart' button
		        productsPage.clickViewCartButton();

		        // Verify that product is displayed in cart page
		        Assert.assertTrue(cartPage.isRecommendedProductInCart(), "Product is not displayed in cart page");
		        Thread.sleep(2000);
		        
		     // Click 'X' button corresponding to a particular product to remove product from cart
		        cartPage.removeProductFromCart();

		        // Verify that product is removed from the cart
		        Assert.assertFalse(cartPage.areProductsInCart(), "Product is still visible in the cart");
		    }

		    @AfterMethod
		    public void tearDown() {
		       // driver.quit();
		    }    	    
}
