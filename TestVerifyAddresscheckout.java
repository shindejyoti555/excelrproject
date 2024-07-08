package MySecondProject;

import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

public class TestVerifyAddresscheckout {

	WebDriver driver;
	HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    CheckOutPage checkoutPage;
    ProductsPage productsPage;

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
        productsPage= new ProductsPage(driver);
    }

    @Test
    public void testRegisterAndOrderPlacement() throws InterruptedException {
    	// Verify that home page is visible successfully
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Add products to cart
        homePage.clickAnyViewProductButton();
        
        // Click 'Add to cart' button
        productDetailPage.clickAddToCart();
        
     // Click 'View Cart' button
        productDetailPage.clickViewCart();
        
        // Verify that cart page is displayed
        Assert.assertTrue(cartPage.isCartPageVisible(), "Cart page is not visible");

        // Click 'Proceed To Checkout'
        cartPage.clickProceedToCheckoutButton();

        // Click 'Register / Login' button
        cartPage.clickRegisterLoginButton();
        

        // Define registration data
        String name = "Test User";
        String email = "testing@msn.com";
        String password = "password123";
        String day = "10";
        String month = "May";
        String year = "1990";
        String firstName = "Test";
        String lastName = "User";
        String company = "Test";
        String address1 = "12 Test St";
        String address2 = "Apt 000";
        String country = "India";
        String state = "MH";
        String city = "Pune";
        String zipcode = "100010";
        String mobileNumber = "1234567890";

        Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup! section is not visible");
        
     // put data for sign up
        signupPage.enterName(name);
        signupPage.enterEmail(email);
        signupPage.clickSignup();
        
     // Fill in the additional account information
        signupPage.selectTitle("Mr");
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth(day, month, year);
        signupPage.subscribeNewsletter();
        signupPage.receiveSpecialOffers();
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
        signupPage.enterAddress(address1);
        signupPage.enterAddress(address2);
        signupPage.selectCountry(country);
        signupPage.enterState(state);
        signupPage.enterCity(city);
        signupPage.enterZipcode(zipcode);
        signupPage.enterMobileNumber(mobileNumber);
        signupPage.clickCreateAccount();
        
     // Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created! section is not visible");

        signupPage.clickContinue();
        
        // Verify 'Logged in as username' at top
        Assert.assertTrue(signupPage.isLoggedInAsVisible(), "Logged in as username is not visible");

     // Click 'Cart' button
        homePage.clickCartButton();

        // Verify that cart page is displayed
        Assert.assertTrue(cartPage.isCartPageVisible(), "Cart page is not visible");

        // Click 'Proceed To Checkout'
        cartPage.clickProceedToCheckoutButton();

        // Verify Address Details and Review Your Order
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details are not visible");
        Assert.assertTrue(checkoutPage.isReviewYourOrderVisible(), "Review your order is not visible");
        

        // Verify delivery and billing addresses
        Assert.assertTrue(checkoutPage.isDeliveryAddressCorrect(address1, address2, city, state, zipcode, country, mobileNumber),
                "Delivery address is not correct");
        Assert.assertTrue(checkoutPage.isBillingAddressCorrect(address1, address2, city, state, zipcode, country, mobileNumber),
                "Billing address is not correct");

     // Enter description in comment text area and click 'Place Order'
        checkoutPage.enterComment("Please deliver my order on weekends");
        checkoutPage.clickPlaceOrder();

        // Enter payment details
        checkoutPage.enterPaymentDetails("Joyti dig", "2111111211111111", "123", "12", "24");

        // Click 'Pay and Confirm Order' button
        checkoutPage.clickPayAndConfirmOrder();

        // Verify success message
        Assert.assertTrue(checkoutPage.isSuccessMessageVisible(), "Success message is not visible");
              
        checkoutPage.clickContinue();

        // Click 'Delete Account' button
        signupPage.clickDeleteAccount();

     // Verify that 'ACCOUNT DELETED!' is visible
    	Assert.assertTrue(loginPage.isAccountDeletedMessageVisible(), "Account Deleted! section is not visible");

    	signupPage.clickContinue();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}