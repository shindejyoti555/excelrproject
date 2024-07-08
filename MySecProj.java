package MySecondProject;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class MySecProj {

		protected WebDriver driver;
		protected WebDriverWait wait;
		 JavascriptExecutor js;

	   public MySecProj(WebDriver driver) {
		   
		   this.driver=driver;
	   	this.js = (JavascriptExecutor) driver; // Casting WebDriver to JavascriptExecutor
	       PageFactory.initElements(driver, this);
	       
	   }
		
	}
