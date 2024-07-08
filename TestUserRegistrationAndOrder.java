package MySecondProject;

//Test Case : Place Order: Register before Checkout

import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	public class TestUserRegistrationAndOrder {
	    WebDriver driver;
	    HomePage homePage;
	    LoginPage loginPage;
	    SignupPage signupPage;
	    ProductDetailPage productDetailPage;
	    CartPage cartPage;
	    CheckOutPage checkoutPage;
	    

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("http://automationexercise.com");

	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	        signupPage = new SignupPage(driver);
	        productDetailPage = new ProductDetailPage(driver);
	        cartPage = new CartPage(driver);
	        checkoutPage = new CheckOutPage(driver);
	        
	    }

	    @Test
	    public void testRegisterAndOrderPlacement() throws InterruptedException {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Click 'Signup / Login' button on home page
	        homePage.clickSignupLogin();

	        Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup! section is not visible");
	        
	        // put data for sign up
	        signupPage.enterName("hari");
	        signupPage.enterEmail("hari111@gmail.com");
	        signupPage.clickSignup();
	        
	     // Fill in the additional account information
	        signupPage.selectTitle("Mr");
	        signupPage.enterPassword("abcd123");
	        signupPage.selectDateOfBirth("20", "February", "2020");
	        signupPage.subscribeNewsletter();
	        signupPage.receiveSpecialOffers();
	        signupPage.enterFirstName("hari");
	        signupPage.enterLastName("shinde");
	        signupPage.enterAddress("pune");
	        signupPage.selectCountry("India");
	        signupPage.enterState("Maharashtra");
	        signupPage.enterCity("Pune");
	        signupPage.enterZipcode("442122");
	        signupPage.enterMobileNumber("1234567890");
	        signupPage.clickCreateAccount();

	        

	        // Verify 'ACCOUNT CREATED!' and click 'Continue' button
	        Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created! section is not visible");

	        signupPage.clickContinue();
	        
	        // Verify 'Logged in as username' at top
	        Assert.assertTrue(signupPage.isLoggedInAsVisible(), "Logged in as username is not visible");

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
