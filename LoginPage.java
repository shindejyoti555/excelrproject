package MySecondProject;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class LoginPage extends MySecProj {
	    //WebDriver driver;

	    By loginSection = By.xpath("//h2[text()='Login to your account']");
	    By emailField = By.name("email");
	    By passwordField = By.name("password");
	    By loginButton = By.xpath("//button[text()='Login']");
	    By loggedInAs = By.xpath("//a[contains(text(), 'Logged in as')]");
	    By deleteAccountButton = By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a");
	    By accountDeletedMessage = By.xpath("//b[text()='Account Deleted!']");
	    By continueButton = By.xpath("/html/body/section/div/div/div/div/a");
	    By loginError = By.xpath("/html/body/section/div/div/div[1]/div/form/p");
	    By logoutButton = By.xpath("//a[text()=' Logout']");
	    
	    public LoginPage(WebDriver driver) {
	    	super(driver);
	    }

	    public boolean isLoginSectionVisible() {
	        return driver.findElement(loginSection).isDisplayed();
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	    
	    public boolean isLoginErrorVisible() {
	        return driver.findElement(loginError).isDisplayed();
	    }

	    public boolean isLoggedInAsVisible() {
	        return driver.findElement(loggedInAs).isDisplayed();
	    }

	    public void clickLogout() {
	        driver.findElement(logoutButton).click();
	    }
	    
	    public void clickDeleteAccount() {
	        driver.findElement(deleteAccountButton).click();
	    }

	    public boolean isAccountDeletedMessageVisible() {
	        return driver.findElement(accountDeletedMessage).isDisplayed();
	    }

	    public void clickContinue() {
	        driver.findElement(continueButton).click();
	    }
	}

