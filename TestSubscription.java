package MySecondProject;

//Test Subscription and Scroll-down-up function with and without arrow button

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestSubscription {
	    WebDriver driver;
	    HomePage homePage;
	    SubscriptionPage subscriptionPage;
	    ContactUsPage contactUsPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        subscriptionPage =new SubscriptionPage(driver);
	        contactUsPage = new ContactUsPage(driver);
	    }

	//Verify Subscription in home Page
	    
	    @Test
	    public void testSubscription() throws InterruptedException {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        // Scroll to subscription section
	        subscriptionPage.scrollToSubscriptionSection();

	        // Enter email address in subscription input
	        subscriptionPage.enterSubscriptionEmail("test@example.com");

	        // Click subscription button
	        subscriptionPage.clickSubscriptionButton();

	        // Verify the success message is visible
	        Assert.assertTrue(subscriptionPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible");
	    }
	
 //Verify Subscription in Cart Page
	    
	    @Test
	    public void testCartSubscription() {

	        // Navigate to cart page
	        homePage.clickCartButton();

	        // Scroll to subscription section
	        subscriptionPage.scrollToSubscriptionSection();

	        // Enter email address in subscription input
	        subscriptionPage.enterSubscriptionEmail("abcd@msn.com");

	        // Click subscription button
	        subscriptionPage.clickSubscriptionButton();

	        // Verify the success message is visible
	        Assert.assertTrue(subscriptionPage.isSubscriptionSuccessMessageVisible(), "Subscription success message is not visible");
	   }
	   
//Verify Scroll-down and up using arrow button and verify element
	    
	    	@Test
	        public void testScrollAndVerifyElements() throws InterruptedException {
 
	        
	     // Click 'Home' button
	        contactUsPage.clickHome();
	        
	     // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
	        
	     // Scroll down page to bottom
	        subscriptionPage.scrollToBottom();
            Thread.sleep(2000);
	        // Verify 'SUBSCRIPTION' is visible
	        Assert.assertTrue(subscriptionPage.isSubscriptionVisible(), "'SUBSCRIPTION' is not visible");
	        
	        Thread.sleep(2000);
	        // Click on arrow at bottom right side to move upward
	        subscriptionPage.clickScrollUpArrow();
	        Thread.sleep(1000);
	        // Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
	        Assert.assertTrue(subscriptionPage.isTopTextVisible(), "'Full-Fledged practice website for Automation Engineers' text is not visible");
	    	}
	
//Verify Scroll-down and up without arrow button and verify element
	    	
	    	@Test
	    	public void testScrollwithoutArrowAndVerifyElements() throws InterruptedException {
	    		
	     // Click 'Home' button
	        contactUsPage.clickHome();
	        
	     // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
	        
	     // Scroll down page to bottom
	        subscriptionPage.scrollToBottom();

	        Thread.sleep(2000);
	        // Verify 'SUBSCRIPTION' is visible
	        Assert.assertTrue(subscriptionPage.isSubscriptionVisible(), "'SUBSCRIPTION' is not visible");
	        Thread.sleep(2000);
	        // Scroll up to the top of the page
	        subscriptionPage.scrollToTop();

	        // Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
	        Assert.assertTrue(subscriptionPage.isTopTextVisible(), "'Full-Fledged practice website for Automation Engineers' text is not visible");
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	}
	
