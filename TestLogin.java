package MySecondProject;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

	public class TestLogin {
	    WebDriver driver;
	    HomePage homePage;
	    LoginPage loginPage;
	    WebDriverWait wait;
	    static ExcelUtilforLogin excelUtilforlogin;

	    @BeforeClass
	    public void setupClass() {
	    	excelUtilforlogin = new ExcelUtilforLogin("D:\\Jyoti\\Selenium\\Projects\\MySecondProject\\ExcelData.xlsx", "LoginData");
	    }

	    @BeforeMethod
	    public void setUp() {
	    	driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://automationexercise.com");
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        int rowCount = excelUtilforlogin.getRowCount("LoginData");
	        Object[][] data = new Object[rowCount - 1][3]; // Assuming the first row is the header
	        for (int i = 1; i < rowCount; i++) {
	            data[i - 1][0] = excelUtilforlogin.getCellData(i, 0); // Email
	            data[i - 1][1] = excelUtilforlogin.getCellData(i, 1); // Password
	            data[i - 1][2] = excelUtilforlogin.getCellData( i, 2); // Scenario
	        }
	        return data;
	    }

	    @Test(dataProvider = "loginData")
	    public void testUserActions(String email, String password, String scenario) {
	        // Verify that home page is visible successfully
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        homePage.clickSignupLogin();

	        // Verify 'Login to your account' is visible
	        Assert.assertTrue(loginPage.isLoginSectionVisible(), "Login to your account section is not visible");

	        // Enter email address and password
	        loginPage.enterEmail(email);
	        loginPage.enterPassword(password);

	        // Click 'login' button
	        loginPage.clickLogin();

	        if (scenario.equals("login_error")) {
	            // Verify 'Your email or password is incorrect!' is visible
	            Assert.assertTrue(loginPage.isLoginErrorVisible(), "Login error message is not visible");
	        } else {
	            // Verify that 'Logged in as username' is visible
	            Assert.assertTrue(loginPage.isLoggedInAsVisible(), "Logged in as username section is not visible");

	            if (scenario.equals("login_logout")) {
	                // Click 'Logout' button
	                loginPage.clickLogout();
	                // Verify that user is navigated to login page
	                Assert.assertTrue(loginPage.isLoginSectionVisible(), "User is not navigated to login page after logout");
	            } else if (scenario.equals("login_delete")) {
	                // Click 'Delete Account' button
	            	loginPage.clickDeleteAccount();

	                // Verify that 'ACCOUNT DELETED!' is visible
	            	Assert.assertTrue(loginPage.isAccountDeletedMessageVisible(), "Account Deleted! section is not visible");

	                loginPage.clickContinue();
	            }
	        }
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        //driver.quit();
	    }
	}

