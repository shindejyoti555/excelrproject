package MySecondProject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.util.concurrent.TimeUnit;

	public class TestRegistration {
	    WebDriver driver;
	    HomePage homePage;
	    SignupPage signupPage;
	    ExcelUtil excelUtil;
	    
	    @BeforeClass
	    public void setupClass() {
	        excelUtil = new ExcelUtil("D:\\Jyoti\\Selenium\\Projects\\MySecondProject\\ExcelData.xlsx", "SignupData"); // Initialize excelUtil
	    }

	    @BeforeMethod
	    public void setUp() {
	
	    	driver = new FirefoxDriver();
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        signupPage = new SignupPage(driver);
	        //excelUtil = new ExcelUtil("D:\\Jyoti\\Selenium\\Projects\\MySecondProject\\ExcelData.xlsx", "SignupData");
	    }

	    @DataProvider(name = "registrationData")
	    public Object[][] getRegistrationData() {
	        int rowCount = excelUtil.getRowCount("SignupData");
	        Object[][] data = new Object[rowCount - 1][3]; // Assuming the first row is the header
	        for (int i = 1; i < rowCount; i++) {
	            data[i - 1][0] = excelUtil.getCellData(i, 0); // name
	            data[i - 1][1] = excelUtil.getCellData(i, 1); // email address
	            data[i - 1][2] = excelUtil.getCellData( i, 2); // Scenario
	        }
	        return data;
	    }
	    
	    @Test(dataProvider = "registrationData")
	    public void testUserRegistration(String name, String email, String scenario) {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        homePage.clickSignupLogin();
	        Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup! section is not visible");

	        signupPage.enterName(name);
	        signupPage.enterEmail(email);
	        signupPage.clickSignup();
	    
	        if (scenario.equals("existing_email")) {
	            
	            // Verify 'Email Address already exist!' is visible
	            Assert.assertTrue(signupPage.isEmailAddressExistsErrorVisible(), "Email Address already exist! error message is not visible");
	            
	        } else if (scenario.equals("create_account")) {
	        
	         // Fill in the additional account information
	        signupPage.selectTitle("Mrs");
	        signupPage.enterPassword("abcd123");
	        signupPage.selectDateOfBirth("20", "February", "2020");
	        signupPage.subscribeNewsletter();
	        signupPage.receiveSpecialOffers();
	        signupPage.enterFirstName("Vedu");
	        signupPage.enterLastName("Dhumal");
	        signupPage.enterAddress("pune");
	        signupPage.selectCountry("India");
	        signupPage.enterState("Maharashtra");
	        signupPage.enterCity("Pune");
	        signupPage.enterZipcode("442122");
	        signupPage.enterMobileNumber("1234567890");
	        signupPage.clickCreateAccount();
	        
	     // Verify that 'ACCOUNT CREATED!' is visible
	        Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created! section is not visible");

	        signupPage.clickContinue();

	        // Verify that 'Logged in as username' is visible
	        Assert.assertTrue(signupPage.isLoggedInAsVisible(), "Logged in as username section is not visible");

	        signupPage.clickDeleteAccount();

	        // Verify that 'ACCOUNT DELETED!' is visible
	        Assert.assertTrue(signupPage.isAccountDeletedVisible(), "Account Deleted! section is not visible");

	        signupPage.clickContinue();
	        }	        
	    }
	 

	    @AfterMethod
	    public void tearDown() {
	    	// Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}