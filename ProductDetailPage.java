package MySecondProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ProductDetailPage extends MySecProj{
	    //WebDriver driver;

	    By productDetailHeader = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
	    By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
	    By productCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
	    By productPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
	    By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]");
	    By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]");
	    By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]");
	    By quantityInput = By.id("quantity");
	    By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	    By viewCartButton = By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div/div[2]/p[2]/a");

	    public ProductDetailPage(WebDriver driver) {
	    	super(driver);
	    }

	    public boolean isProductDetailPageVisible() {
	        return driver.findElement(productDetailHeader).isDisplayed();
	    }

	    public boolean isProductNameVisible() {
	        return driver.findElement(productName).isDisplayed();
	    }

	    public boolean isProductCategoryVisible() {
	        return driver.findElement(productCategory).isDisplayed();
	    }

	    public boolean isProductPriceVisible() {
	        return driver.findElement(productPrice).isDisplayed();
	    }

	    public boolean isProductAvailabilityVisible() {
	        return driver.findElement(productAvailability).isDisplayed();
	    }

	    public boolean isProductConditionVisible() {
	        return driver.findElement(productCondition).isDisplayed();
	    }

	    public boolean isProductBrandVisible() {
	        return driver.findElement(productBrand).isDisplayed();
	    }
	    
// view first product details increase quantity by 4 and add to cart and view
	    
	    public void setQuantity(int quantity) {
	        WebElement quantityElement = driver.findElement(quantityInput);
	        quantityElement.clear();
	        quantityElement.sendKeys(String.valueOf(quantity));
	    }
	    
	    public void clickAddToCart() {
	        WebElement addToCartElement = driver.findElement(addToCartButton);
	        scrollToElement(addToCartElement);
	        waitForElementToBeClickable(addToCartButton);
	        addToCartElement.click();
	    }

	    public void clickViewCart() {
	        WebElement viewCartElement = driver.findElement(viewCartButton);
	        scrollToElement(viewCartElement);
	        waitForElementToBeClickable(viewCartButton);
	        viewCartElement.click();
	    }

	    private void scrollToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    private void waitForElementToBeClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	}

