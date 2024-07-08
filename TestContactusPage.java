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

	public class TestContactusPage {
	    WebDriver driver;
	    HomePage homePage;
	    WebDriverWait wait;
	    ContactUsPage contactUsPage;

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        contactUsPage = new ContactUsPage(driver);
	    }

	    @Test
	    public void testContactUs() {
	        // Click on 'Contact Us' button
	        homePage.clickContactUs();

	        // Verify 'GET IN TOUCH' is visible
	        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "GET IN TOUCH is not visible");

	        // Enter name, email, subject, and message
	        contactUsPage.enterName("TestUser");
	        contactUsPage.enterEmail("testuser@gmail.com");
	        contactUsPage.enterSubject("Testing");
	        contactUsPage.enterMessage("This is a testing website");

	        // Upload file
	        contactUsPage.uploadFile("C:\\Users\\Digambar\\Desktop\\photo.jpg");

	        // Click 'Submit' button
	        contactUsPage.clickSubmit();

	        // Handle alert
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();

	        // Verify success message 'Success! Your details have been submitted successfully.' is visible
	        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message is not visible");
	        
	        // Click 'Home' button
	        contactUsPage.clickHome();

	        // Verify that landed to home page successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible after clicking Home button");
	    }

	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	}

