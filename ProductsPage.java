package MySecondProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ProductsPage extends MySecProj {
	    //WebDriver driver;

	    By productsPageHeader = By.xpath("//h2[text()='All Products']");
	    By productsList = By.cssSelector(".features_items");
	    By firstProductViewButton = By.xpath("(//a[text()='View Product'])[1]");
	    
//Add to Cart products	    
	    By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
	    By secondProduct = By.xpath("(//div[@class='productinfo text-center'])[2]");
	    By addToCartFirstProduct = By.xpath("(//a[text()='Add to cart'])[1]");
	    By addToCartSecondProduct = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
	    By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
	    By viewCartButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[2]/p[2]/a");
	    By addtocartButton= By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
	    
//search field
	    By searchInput = By.xpath("//input[@name='search']");
	    By searchButton = By.cssSelector("#submit_search");
	    
//search results 
	    By searchedProductsHeader = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2");
	    By searchedProductsList = By.cssSelector(".features_items");
	    
//Add Review locators on product
	    
	    By writeYourReview = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li");
	    By nameField = By.id("name");
	    By emailField = By.id("email");
	    By reviewField = By.id("review");
	    By submitButton = By.id("button-review");
	    By successMessage = By.xpath("//div[contains(text(),'Thank you for your review.')]");


	    public ProductsPage(WebDriver driver) {
	    	super(driver);
	    }

	    public boolean isProductsPageVisible() {
	        return driver.findElement(productsPageHeader).isDisplayed();
	    }

	    public boolean isProductsListVisible() {
	        return driver.findElement(productsList).isDisplayed();
	    }

	    public void clickFirstProduct() {
	        driver.findElement(firstProductViewButton).click();
	    }
	    
	    
	    
	//search field methods
	    public void enterProductNameInSearch(String productName) {
	        driver.findElement(searchInput).sendKeys(productName);
	    }

	    public void clickSearchButton() {
	        driver.findElement(searchButton).click();
	    }
 //search result methods
	    public boolean isSearchedProductsVisible() {
	        return driver.findElement(searchedProductsHeader).isDisplayed();
	    }

	    public boolean areSearchedProductsVisible() {
	        return driver.findElement(searchedProductsList).isDisplayed();
	    }
	       
	    public void addAllSearchedProductsToCart() {
	        List<WebElement> products = driver.findElements(searchedProductsList);
	        for (WebElement product : products) {
	            product.findElement(By.xpath(".//a[contains(text(),'Add to cart')]")).click();
	        }
	    }
	    
// Add to Cart first and Second Product
	    
	    public void hoverOverFirstProduct() {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(firstProduct)).perform();
	    }

	    public void clickAddToCartFirstProduct() {
	    	 scrollToElement(driver.findElement(addToCartFirstProduct));
	        driver.findElement(addToCartFirstProduct).click();
	    }

	    public void clickaddtocartButton() {
	    	   scrollToElement(driver.findElement(addtocartButton));
	    	   waitForElementToBeClickable(addtocartButton);
	        driver.findElement(addtocartButton).click();
	    }
	    public void clickContinueShoppingButton() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	WebElement continueShoppingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
	    	scrollToElement(continueShoppingBtn);
	    	continueShoppingBtn.click();
	    }
	    

	    public void hoverOverSecondProduct() {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(driver.findElement(secondProduct)).perform();
	    }

	    public void clickAddToCartSecondProduct() {
	    	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	WebElement addtocartsecondproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartSecondProduct));
	    	scrollToElement(addtocartsecondproduct);
	    	addtocartsecondproduct.click();*/
	    	scrollToElement(driver.findElement(addToCartSecondProduct));
	    	waitForElementToBeClickable(addToCartSecondProduct);
	        driver.findElement(addToCartSecondProduct).click();
	    }

	    public void clickViewCartButton() {
	    	scrollToElement(driver.findElement(viewCartButton));
	    	waitForElementToBeClickable(viewCartButton);
	        driver.findElement(viewCartButton).click();
	    }
	    
	    private void scrollToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	    
	    private void waitForElementToBeClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    
	//Add Review on product methods
	    
	    public boolean isWriteYourReviewVisible() {
	        return driver.findElement(writeYourReview).isDisplayed();
	    }

	    public void submitReview(String name, String email, String review) {
	        driver.findElement(nameField).sendKeys(name);
	        driver.findElement(emailField).sendKeys(email);
	        driver.findElement(reviewField).sendKeys(review);
	        driver.findElement(submitButton).click();
	    }

	    public boolean isSuccessMessageVisible() {
	        return driver.findElement(successMessage).isDisplayed();
	    }
}

