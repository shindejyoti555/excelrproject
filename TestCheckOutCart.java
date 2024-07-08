package MySecondProject;

//Test Case : Place Order: Login before Checkout

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	

	public class TestCheckOutCart {
	    WebDriver driver;
	    HomePage homePage;
	    ProductDetailPage productDetailPage;
	    CartPage cartPage;
	    CheckOutPage checkoutPage;
	    LoginPage loginPage;
	    ProductsPage productsPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        productDetailPage = new ProductDetailPage(driver);
	        cartPage = new CartPage(driver);
	        checkoutPage = new CheckOutPage(driver);
	        loginPage = new LoginPage(driver);
	        productsPage = new ProductsPage(driver);
	    }

	    @Test
	    public void testProductCheckoutAndOrderPlacement() {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
	        
	        homePage.clickSignupLogin();

	        // Verify 'Login to your account' is visible
	        Assert.assertTrue(loginPage.isLoginSectionVisible(), "Login to your account section is not visible");

	        // Enter email address and password
	        loginPage.enterEmail("hari11@gmail.com");
	        loginPage.enterPassword("abcd123");

	        // Click 'login' button
	        loginPage.clickLogin();

	     // Verify that 'Logged in as username' is visible
            Assert.assertTrue(loginPage.isLoggedInAsVisible(), "Logged in as username section is not visible");
            
         // Click 'View Product' for any product on home page
	        homePage.clickAnyViewProductButton();

	     // Click 'Add to cart' button
	        productDetailPage.clickAddToCart();
            
	        // Click 'Cart' button
	        homePage.clickCartButton();

	        // Verify that cart page is displayed
	        Assert.assertTrue(cartPage.isCartPageVisible(), "Cart page is not visible");

	        // Click 'Proceed To Checkout'
	        cartPage.clickProceedToCheckoutButton();

	        // Verify Address Details and Review Your Order
	        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details are not visible");
	        Assert.assertTrue(checkoutPage.isReviewYourOrderVisible(), "Review your order is not visible");

	        // Enter description in comment text area and click 'Place Order'
	        checkoutPage.enterComment("Please deliver my order on weekends");
	        checkoutPage.clickPlaceOrder();

	        // Enter payment details
	        checkoutPage.enterPaymentDetails("Joyti dig", "2111111211111111", "123", "12", "24");

	        // Click 'Pay and Confirm Order' button
	        checkoutPage.clickPayAndConfirmOrder();

	        // Verify success message
	        Assert.assertTrue(checkoutPage.isSuccessMessageVisible(), "Success message is not visible");
	        
	// Test Case:    Click 'Download Invoice' button and verify invoice is downloaded successfully
	        checkoutPage.clickDownloadInvoiceButton();
	        
	        checkoutPage.clickContinue();

	        // Click 'Delete Account' button
	        loginPage.clickDeleteAccount();

	     // Verify that 'ACCOUNT DELETED!' is visible
        	Assert.assertTrue(loginPage.isAccountDeletedMessageVisible(), "Account Deleted! section is not visible");

            loginPage.clickContinue();
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	
}
