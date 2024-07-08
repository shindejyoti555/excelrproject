package MySecondProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class ContactUsPage {
	    WebDriver driver;

	    By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
	    By nameField = By.name("name");
	    By emailField = By.name("email");
	    By subjectField = By.name("subject");
	    By messageField = By.name("message");
	    By uploadFileField = By.name("upload_file");
	    By submitButton = By.xpath("//input[@value='Submit']");
	    By successMessage = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
	    By homeButton = By.xpath("//a[text()=' Home']");

	    public ContactUsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isGetInTouchVisible() {
	        return driver.findElement(getInTouchHeader).isDisplayed();
	    }

	    public void enterName(String name) {
	        driver.findElement(nameField).sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterSubject(String subject) {
	        driver.findElement(subjectField).sendKeys(subject);
	    }

	    public void enterMessage(String message) {
	        driver.findElement(messageField).sendKeys(message);
	    }

	    public void uploadFile(String filePath) {
	        driver.findElement(uploadFileField).sendKeys(filePath);
	    }

	    public void clickSubmit() {
	        driver.findElement(submitButton).click();
	    }

	    public boolean isSuccessMessageVisible() {
	        return driver.findElement(successMessage).isDisplayed();
	    }

	    public void clickHome() {
	        driver.findElement(homeButton).click();
	    }
	}

