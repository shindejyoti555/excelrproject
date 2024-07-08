package MySecondProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class SignupPage extends MySecProj {
	    //WebDriver driver;

	    @FindBy(name = "name")
	    WebElement nameField;

	    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/form/input[3]")
	    WebElement emailField;
	    
	    
	    @FindBy(xpath = "//button[text()='Signup']")
	    WebElement signupButton;
	    
	    @FindBy(xpath = "//h2[text()='New User Signup!']")
	    WebElement newUserSignupText;
	    
	    @FindBy(id = "id_gender1")
	    WebElement titleMr;

	    @FindBy(id = "id_gender2")
	    WebElement titleMrs;

	    @FindBy(id = "password")
	    WebElement passwordField;

	    @FindBy(id = "days")
	    WebElement daysDropdown;

	    @FindBy(id = "months")
	    WebElement monthsDropdown;

	    @FindBy(id = "years")
	    WebElement yearsDropdown;

	    @FindBy(id = "newsletter")
	    WebElement newsletterCheckbox;

	    @FindBy(id = "optin")
	    WebElement specialOffersCheckbox;

	    @FindBy(id = "first_name")
	    WebElement firstNameField;

	    @FindBy(id = "last_name")
	    WebElement lastNameField;

	    @FindBy(id = "address1")
	    WebElement addressField;
	    
	    @FindBy(id = "country")
	    WebElement countryDropdown;
	    
	    @FindBy(id = "state")
	    WebElement stateField;
	    
	    @FindBy(id = "city")
	    WebElement cityField;
	    
	    @FindBy(id = "zipcode")
	    WebElement zipcodeField;
	    
	    @FindBy(id = "mobile_number")
	    WebElement MobileNoField;
	    
	    @FindBy(xpath = "//button[text()='Create Account']")
	    WebElement createAccountButton;

	    @FindBy(xpath = "//b[text()='Account Created!']")
	    WebElement accountCreatedText;

	    @FindBy(xpath = "/html/body/section/div/div/div/div/a")
	    WebElement continueButton;

	    @FindBy(xpath = "//a[text()=' Logged in as ']")
	    WebElement loggedInAsText;

	    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[5]/a")
	    WebElement deleteAccountButton;

	    @FindBy(xpath = "//b[text()='Account Deleted!']")
	    WebElement accountDeletedText;
	    
	    @FindBy(xpath = "//p[text()='Email Address already exist!']")
	    WebElement emailAddressExistsError;


	    public SignupPage(WebDriver driver) {
	    	super(driver);
	        PageFactory.initElements(driver, this);
	    }

	    public void enterName(String name) {
	        nameField.sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void clickSignup() {
	        signupButton.click();
	    }

	    public boolean isNewUserSignupVisible() {
	        return newUserSignupText.isDisplayed();
	    }
	    
	    public void selectTitle(String title) {
	        if (title.equalsIgnoreCase("Mr")) {
	            titleMr.click();
	        } else if (title.equalsIgnoreCase("Mrs")) {
	            titleMrs.click();
	        }
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void selectDateOfBirth(String day, String month, String year) {
	        daysDropdown.sendKeys(day);
	        monthsDropdown.sendKeys(month);
	        yearsDropdown.sendKeys(year);
	    }

	    public void subscribeNewsletter() {
	        if (!newsletterCheckbox.isSelected()) {
	            newsletterCheckbox.click();
	        }
	    }

	    public void receiveSpecialOffers() {
	        if (!specialOffersCheckbox.isSelected()) {
	            specialOffersCheckbox.click();
	        }
	    }

	    public void enterFirstName(String firstName) {
	        firstNameField.sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        lastNameField.sendKeys(lastName);
	    }

	    public void enterAddress(String address) {
	        addressField.sendKeys(address);
	    }

	    public void selectCountry(String country) {
	        Select select = new Select(countryDropdown);
	        select.selectByVisibleText(country);
	    }

	    public void enterState(String state) {
	        stateField.sendKeys(state);
	    }
	    
	    public void enterCity(String city) {
	        cityField.sendKeys(city);
	    }
	    
	    public void enterZipcode(String zipcode) {
	        zipcodeField.sendKeys(zipcode);
	    }
	    
	    public void enterMobileNumber(String Mobile) {
	        MobileNoField.sendKeys(Mobile);
	    }
	    
	    public void clickCreateAccount() {
	        createAccountButton.click();
	    }
	    public boolean isAccountCreatedVisible() {
	        return accountCreatedText.isDisplayed();
	    }

	    public void clickContinue() {
	        continueButton.click();
	    }

	    public boolean isLoggedInAsVisible() {
	        return loggedInAsText.isDisplayed();
	    }

	    public void clickDeleteAccount() {
	        deleteAccountButton.click();
	    }

	    public boolean isAccountDeletedVisible() {
	        return accountDeletedText.isDisplayed();
	    }
	    
	    public boolean isEmailAddressExistsErrorVisible() {
	        return emailAddressExistsError.isDisplayed();
	    }
}	

