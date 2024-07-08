package MySecondProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class CategoryPage extends MySecProj {
	    //WebDriver driver;
		
		By categoriesSidebar = By.xpath("//div[@class='left-sidebar']");
	    By womenCategory = By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/h4/a");
	    By womenDressLink = By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[1]/a");
	    By categoryPageTitle = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
	    By MenCategory = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/h4/a");

	    public CategoryPage(WebDriver driver) {
	        super(driver);
	    }

	    public boolean areCategoriesVisible() {
	        return driver.findElement(categoriesSidebar).isDisplayed();
	    }

	    public void clickWomenCategory() {
	        driver.findElement(womenCategory).click();
	    }

	    public void clickWomenCategoryLink(String linkText) {
	        driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'" + linkText + "')]")).click();
	    }
	    public boolean isCategoryPageDisplayed(String expectedText) {
	        return driver.findElement(categoryPageTitle).getText().contains(expectedText);
	    }

	    public void clickMenCategory() {
	        driver.findElement(MenCategory).click();
	    }
	    public void clickMenSubCategory(String linkText) {
	    	
	    	WebElement clickMenElement = driver.findElement(By.xpath("//div[@id='Men']//a[contains(text(),'" + linkText + "')]"));
	        scrollToElement(clickMenElement);
	        waitForElementToBeClickable(By.xpath("//div[@id='Men']//a[contains(text(),'" + linkText + "')]"));
	        clickMenElement.click();
	       // driver.findElement(By.xpath("//div[@id='Men']//a[contains(text(),'" + linkText + "')]")).click();
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
