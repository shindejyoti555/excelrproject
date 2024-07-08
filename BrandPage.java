package MySecondProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class BrandPage extends MySecProj {
	    //WebDriver driver;

	    By brandPageTitle = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
	    By secondBrand = By.xpath("//div[@class='brands_products']//li[2]//a");
	    By secondBrandName = By.xpath("//div[@class='brands_products']//li[2]//a");

	    By brandsSidebar = By.xpath("//div[@class='brands_products']");
	    By firstBrand = By.xpath("//div[@class='brands_products']//li[1]//a");
	    By firstBrandName = By.xpath("//div[@class='brands_products']//li[1]//a");
	    
	    public BrandPage(WebDriver driver) {
	    	super(driver);
	    }

	    public boolean isBrandPageVisible() {
	        return driver.findElement(brandPageTitle).isDisplayed();
	    }

	    public void clickSecondBrand() {
	    	WebElement clicksecondbrandElement = driver.findElement(secondBrand);
	        scrollToElement(clicksecondbrandElement);
	        waitForElementToBeClickable(secondBrand);
	        clicksecondbrandElement.click();
	        //driver.findElement(secondBrand).click();
	    }

	    public String getSecondBrandName() {
	        return driver.findElement(secondBrandName).getText();
	    }
	
	    public boolean areBrandsVisible() {
	        return driver.findElement(brandsSidebar).isDisplayed();
	    }

	    public void clickFirstBrand() {
	    	WebElement clickfirstbrandElement = driver.findElement(firstBrand);
	        scrollToElement(clickfirstbrandElement);
	        waitForElementToBeClickable(firstBrand);
	        clickfirstbrandElement.click();
	        
	    }

	    public String getFirstBrandName() {
	        return driver.findElement(firstBrandName).getText();
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
