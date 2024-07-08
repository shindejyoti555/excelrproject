package MySecondProject;

//Test all products add to cart and product remove from cart
//Add Review on product

import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	

	public class TestAllProducts {
	    WebDriver driver;
	    HomePage homePage;
	    ProductsPage productsPage;
	    CartPage cartPage;
	    LoginPage loginPage;
	    WebDriverWait wait;
	    
	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");

	        homePage = new HomePage(driver);
	        productsPage = new ProductsPage(driver);
	        cartPage = new CartPage(driver);
	        loginPage = new LoginPage(driver);
	    }
	    
	//Test for adding review on product   
	    
	    @Test
	    public void testSubmitProductReview() {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click on 'Products' button
	        homePage.clickProducts();

	        // Verify user is navigated to ALL PRODUCTS page successfully
	        Assert.assertTrue(productsPage.isProductsPageVisible(), "All Products page is not visible");

	        // Click on 'View Product' button
	        productsPage.clickFirstProduct();

	        // Verify 'Write Your Review' is visible
	        Assert.assertTrue(productsPage.isWriteYourReviewVisible(), "'Write Your Review' is not visible");

	        // Enter name, email, and review
	        productsPage.submitReview("vedika", "joyti@gmail.com", "Good product!");

	        // Verify success message 'Thank you for your review.'
	        Assert.assertTrue(productsPage.isSuccessMessageVisible(), "'Thank you for your review.' message is not visible");
	    }
 
//Test Case : Search Products and Verify Cart After Login
	    @Test
	    public void testProductSearchAndAddToCart() throws InterruptedException {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click on 'Products' button
	        homePage.clickProducts();

	        // Verify user is navigated to ALL PRODUCTS page successfully
	        Assert.assertTrue(productsPage.isProductsPageVisible(), "All Products page is not visible");

	        // Enter product name in search input and click search button
	        productsPage.enterProductNameInSearch("Dress");

	     // Click the search button
	        productsPage.clickSearchButton();

	        // Verify 'SEARCHED PRODUCTS' is visible
	        Assert.assertTrue(productsPage.isSearchedProductsVisible(), "'SEARCHED PRODUCTS' is not visible");

	        // Verify all the products related to search are visible
	        Assert.assertTrue(productsPage.areSearchedProductsVisible(), "Searched products are not visible");

	        // Add those products to cart
	        //productsPage.addAllSearchedProductsToCart();
	        productsPage.clickaddtocartButton();
	        productsPage.clickViewCartButton();

	        // Click 'Cart' button and verify that products are visible in cart
	        homePage.clickCartButton();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.getCartProductsLocator()));
	        //Thread.sleep(1000);
	        
	        Assert.assertTrue(cartPage.isProductInCart(), "Products are not visible in the cart");

	        homePage.clickSignupLogin();

	        // Verify 'Login to your account' is visible
	        Assert.assertTrue(loginPage.isLoginSectionVisible(), "Login to your account section is not visible");

	        // Enter email address and password
	        loginPage.enterEmail("hari11@gmail.com");
	        loginPage.enterPassword("abcd123");

	        // Click 'login' button
	        loginPage.clickLogin();

	        // Again, go to Cart page
	        homePage.clickCartButton();

	        // Verify that those products are visible in cart after login as well
	        Assert.assertTrue(cartPage.isProductInCart(), "Products are not visible in the cart after login");
	        
	        // Click 'X' button corresponding to a particular product
	        cartPage.removeProductFromCart();

	        // Verify that product is removed from the cart
	        Assert.assertFalse(cartPage.areProductsInCart(), "Product is still visible in the cart");
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	
}
