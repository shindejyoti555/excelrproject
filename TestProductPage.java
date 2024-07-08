package MySecondProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestProductPage {
	    WebDriver driver;
	    HomePage homePage;
	    ProductsPage productsPage;
	    ProductDetailPage productDetailPage;
	    CartPage cartPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        productsPage = new ProductsPage(driver);
	        productDetailPage = new ProductDetailPage(driver);
	        cartPage = new CartPage(driver);
	    }

	    @Test
	    public void testNavigationToProducts() {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click on 'Products' button
	        homePage.clickProducts();

	        // Verify user is navigated to ALL PRODUCTS page successfully
	        Assert.assertTrue(productsPage.isProductsPageVisible(), "Products page is not visible");

	        // Verify the products list is visible
	        Assert.assertTrue(productsPage.isProductsListVisible(), "Products list is not visible");

	        // Click on 'View Product' of first product
	        productsPage.clickFirstProduct();

	        // Verify user is landed to product detail page
	        Assert.assertTrue(productDetailPage.isProductDetailPageVisible(), "Product detail page is not visible");

	        // Verify that product details are visible: product name, category, price, availability, condition, brand
	        Assert.assertTrue(productDetailPage.isProductNameVisible(), "Product name is not visible");
	        Assert.assertTrue(productDetailPage.isProductCategoryVisible(), "Product category is not visible");
	        Assert.assertTrue(productDetailPage.isProductPriceVisible(), "Product price is not visible");
	        Assert.assertTrue(productDetailPage.isProductAvailabilityVisible(), "Product availability is not visible");
	        Assert.assertTrue(productDetailPage.isProductConditionVisible(), "Product condition is not visible");
	        Assert.assertTrue(productDetailPage.isProductBrandVisible(), "Product brand is not visible");
	    }

// view first product details increase quantity by 4 and add to cart and view
	    
	    @Test
	    
	    public void testProductDetailsAndCart() {
	    	// Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click 'View Product' for any product on home page
	        homePage.clickAnyViewProductButton();

	        // Verify product detail is opened
	        Assert.assertTrue(productDetailPage.isProductDetailPageVisible(), "Product detail page is not visible");

	        // Increase quantity to 4
	        productDetailPage.setQuantity(4);

	        // Click 'Add to cart' button
	        productDetailPage.clickAddToCart();

	        // Click 'View Cart' button
	        productDetailPage.clickViewCart();

	        // Verify that product is displayed in cart page with exact quantity
	        Assert.assertTrue(cartPage.isProductInCart(), "Product is not in the cart");
	        Assert.assertEquals(cartPage.getProductQuantity(), 4, "Product quantity is incorrect");
	    }
	    	
	    	
	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}

