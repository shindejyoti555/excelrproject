package MySecondProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MySecProj {

	 //WebDriver driver;

	    @FindBy(xpath = "//a[text()=' Signup / Login']")
	    WebElement signupLoginButton;
	    
	    By homePageLogo = By.cssSelector("div.logo");
	    
	    By cartButton = By.xpath("//a[text()=' Cart']");
	    
	    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[8]/a")
	    WebElement clickcontactus;
	    
	    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[5]/a")
	    WebElement clickTestCasespage;
	    
	    By testCasesHeader = By.xpath("/html/body/section/div/div[1]/div/h2/b");

	    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
	    WebElement homePageBanner;
	    
	    By productsButton = By.xpath("//a[text()=' Products']");
	    
	    By viewProductButtons = By.xpath("//a[contains(text(),'View Product')]");
	    
//Add recommended product in cart
	    By recommendedItems = By.xpath("//h2[text()='recommended items']");
	    By addToCartButton = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
	    
	    public HomePage(WebDriver driver) {
	    	super(driver);
	        PageFactory.initElements(driver, this);
	    }

//click on sign up/login page
	    public void clickSignupLogin() {
	        signupLoginButton.click();
	    }
	    
	    public boolean isHomePageVisible() {
	        return homePageBanner.isDisplayed();
	    }
	    
	    public boolean isHomePageLogoVisible() {
	        return driver.findElement(homePageLogo).isDisplayed();
	    }
	    
//click on Contact us page
	    public void clickContactUs() {
	    	clickcontactus.click();
	    }
	    
//click on TestCases page
	    public void clickTestCases() {
	    	clickTestCasespage.click();
	    }
	    
	    public boolean isTestCasesVisible() {
	        return driver.findElement(testCasesHeader).isDisplayed();
	    }
//click on product page	    
	    public void clickProducts() {
	        driver.findElement(productsButton).click();
	    }
//click on cart page
	    public void clickCartButton() {
	        driver.findElement(cartButton).click();
	    }
//click on any product view button
	    public void clickAnyViewProductButton() {
	        driver.findElement(viewProductButtons).click();
	    }
//methods for adding recommended product in cart
	    public boolean isRecommendedItemsVisible() {
	        return driver.findElement(recommendedItems).isDisplayed();
	    }

	    public void addToCartRecommendedItem() {
	        driver.findElement(addToCartButton).click();
	    }

}
