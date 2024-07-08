package MySecondProject;

//Test Subscription and Scroll-down-up function with and without arrow button

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;

	public class SubscriptionPage extends MySecProj{
	    
//HomePage Subscription
		
	    By homePageHeader = By.xpath("//h2[text()='Home']");
	    By subscriptionSection = By.xpath("/html/body/footer/div[1]/div/div/div[2]/div");
	    By subscriptionInput = By.id("susbscribe_email");
	    By subscriptionButton = By.id("subscribe");
	    By subscriptionSuccessMessage = By.xpath("/html/body/footer/div[1]/div/div/div[1]/div/div");

//cart page subscription
	    
	    By subscriptionCartSection = By.id("subscription");
	    By subscriptionCartInput = By.id("susbscribe_email");
	    By subscriptionCartButton = By.id("subscribe");
	    By CartsubscriptionSuccessMessage = By.xpath("//div[@class='alert-success' and contains(text(), 'You have been successfully subscribed!')]");

//Scroll-Down and Scroll- up 
	    
	    By scrollUpArrow = By.id("scrollUp");
	    By topText = By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");
	    
	    public SubscriptionPage(WebDriver driver) {
	    	super(driver);
	    }

	    public boolean isHomePageVisible() {
	        return driver.findElement(homePageHeader).isDisplayed();
	    }
//home page subscription methods
	    public void scrollToSubscriptionSection() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(subscriptionSection));
	    }

	    public void enterSubscriptionEmail(String email) {
	        driver.findElement(subscriptionInput).sendKeys(email);
	    }

	    public void clickSubscriptionButton() {
	        driver.findElement(subscriptionButton).click();
	    }

	    public boolean isSubscriptionSuccessMessageVisible() {
	        return driver.findElement(subscriptionSuccessMessage).isDisplayed();
	    }
	    
//Cart page Subscription methods
	    
	    public void scrollToSubscriptionCartSection() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(subscriptionSection));
	    }

	    public void enterSubscriptionCartEmail(String email) {
	        driver.findElement(subscriptionInput).sendKeys(email);
	    }

	    public void clickSubscriptionCartButton() {
	        driver.findElement(subscriptionButton).click();
	    }

	    public boolean isCartSubscriptionSuccessMessageVisible() {
	        return driver.findElement(subscriptionSuccessMessage).isDisplayed();
	    }
	    
//Scroll-Down and Scroll- up methods
	    
	    public void scrollToBottom() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }

	    public boolean isSubscriptionVisible() {
	        return driver.findElement(subscriptionSection).isDisplayed();
	    }
	    
	 // method to scroll up using arrow button
	    public void clickScrollUpArrow() {
	        driver.findElement(scrollUpArrow).click();
	    }
	    
	// method to scroll up without arrow button
	    public void scrollToTop() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0)");
	    }

	    public boolean isTopTextVisible() {
	        return driver.findElement(topText).isDisplayed();
	    }
}

