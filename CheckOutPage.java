package MySecondProject;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	

	public class CheckOutPage extends LoginPage{
	    //WebDriver driver;

	    By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	    By addressDetails = By.xpath("//h2[contains(text(),'Address Details')]");
	    By reviewYourOrder = By.xpath("//h2[contains(text(),'Review Your Order')]");
	    By commentTextArea = By.name("message");
	    By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
	    By nameOnCardInput = By.name("name_on_card");
	    By cardNumberInput = By.name("card_number");
	    By cvcInput = By.name("cvc");
	    By expirationDateInput = By.name("expiry_month");
	    By expirationYearInput = By.name("expiry_year");
	    By payAndConfirmOrderButton = By.xpath("//button[contains(text(),'Pay and Confirm Order')]");
	    By successMessage = By.xpath("/html/body/section/div/div/div/h2/b");
	    By downloadInvoiceButton = By.xpath("/html/body/section/div/div/div/a");
	    By clickonContinue = By.xpath("/html/body/section/div/div/div/div/a");
	    //By deliveryAddress = By.xpath("//ul[@id='address_delivery']//li");
	    //By billingAddress = By.xpath("//ul[@id='address_invoice']//li");
	    By deliveryAddress = By.xpath("//*[@id=\"address_delivery\"]");
	  By billingAddress = By.xpath("//*[@id=\"address_invoice\"]");
	    

	    public CheckOutPage(WebDriver driver) {
	    	super(driver);
	    }

	    public void clickProceedToCheckout() {
	        driver.findElement(proceedToCheckoutButton).click();
	    }

	    public boolean isAddressDetailsVisible() {
	        return driver.findElement(addressDetails).isDisplayed();
	    }

	    public boolean isReviewYourOrderVisible() {
	        return driver.findElement(reviewYourOrder).isDisplayed();
	    }

	    public void enterComment(String comment) {
	        driver.findElement(commentTextArea).sendKeys(comment);
	    }

	    public void clickPlaceOrder() {
	        driver.findElement(placeOrderButton).click();
	    }

	    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String Year) {
	        driver.findElement(nameOnCardInput).sendKeys(nameOnCard);
	        driver.findElement(cardNumberInput).sendKeys(cardNumber);
	        driver.findElement(cvcInput).sendKeys(cvc);
	        driver.findElement(expirationDateInput).sendKeys(expirationMonth);
	        driver.findElement(expirationYearInput).sendKeys(Year);
	    }

	    public void clickPayAndConfirmOrder() {
	        driver.findElement(payAndConfirmOrderButton).click();
	    }

	    public boolean isSuccessMessageVisible() {
	        return driver.findElement(successMessage).isDisplayed();
	    }

	    public void clickDownloadInvoiceButton() {
	        driver.findElement(downloadInvoiceButton).click();
	    }
	    
	    public void clickContinue() {
	        driver.findElement(clickonContinue).click();
	    }
	    
	    public boolean isDeliveryAddressCorrect(String address1, String address2, String city, String state, String zipcode, String country, String mobileNumber) {
	        String fullAddress = address1 + " " + address2 + " " + city + " " + state + " " + zipcode + " " + country + " " + mobileNumber;
	        return driver.findElement(deliveryAddress).getText().contains(fullAddress);
	    }

	    public boolean isBillingAddressCorrect(String address1, String address2, String city, String state, String zipcode, String country, String mobileNumber) {
	        String fullAddress = address1 + " " + address2 + " " + city + " " + state + " " + zipcode + " " + country + " " + mobileNumber;
	        return driver.findElement(billingAddress).getText().contains(fullAddress);
	    }
}
