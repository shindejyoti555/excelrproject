package MySecondProject;

	import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestCartPage {
	    WebDriver driver;
	    HomePage homePage;
	    ProductsPage productsPage;
	    CartPage cartPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        productsPage = new ProductsPage(driver);
	        cartPage = new CartPage(driver);
	    }

	    @Test
	    public void testAddProductsToCart() {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click 'Products' button
	        homePage.clickProducts();

	        // Hover over first product and click 'Add to cart'
	        productsPage.hoverOverFirstProduct();
	        productsPage.clickAddToCartFirstProduct();

	        // Click 'Continue Shopping' button
	        productsPage.clickContinueShoppingButton();

	        // Hover over second product and click 'Add to cart'
	        productsPage.hoverOverSecondProduct();
	        productsPage.clickAddToCartSecondProduct();

	        // Click 'View Cart' button
	        productsPage.clickViewCartButton();

	        // Verify both products are added to Cart
	        Assert.assertTrue(cartPage.isFirstProductInCart(), "First product is not in the cart");
	        Assert.assertTrue(cartPage.isSecondProductInCart(), "Second product is not in the cart");

	        // Verify their prices, quantity, and total price
	        Assert.assertEquals(cartPage.getFirstProductPrice(), "Expected Price 1", "First product price is incorrect");
	        Assert.assertEquals(cartPage.getSecondProductPrice(), "Expected Price 2", "Second product price is incorrect");
	        Assert.assertEquals(cartPage.getFirstProductQuantity(), 1, "First product quantity is incorrect");
	        Assert.assertEquals(cartPage.getSecondProductQuantity(), 1, "Second product quantity is incorrect");
	        Assert.assertEquals(cartPage.getTotalPrice(), "Expected Total Price", "Total price is incorrect");
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	
}
