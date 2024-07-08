package MySecondProject;



	import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class CartPage extends MySecProj {
	    //WebDriver driver;

	    By firstProductInCart = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[2]");
	    By secondProductInCart = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[2]/td[2]");
	    By firstProductPrice = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[3]");
	    By secondProductPrice = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[2]/td[3]");
	    By firstProductQuantity = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[4]");
	    By secondProductQuantity = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[2]/td[4]");
	    By totalPrice = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[2]/td[5]");
	//increase quantity of product    
	    By productInCart = By.xpath("//table[@id='cart_info_table']//tr");
	    By productQuantity = By.xpath("//table[@id='cart_info_table']//tr//td[@class='cart_quantity']/button");
//Checkout cart    
	    By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	    By cartPage = By.xpath("/html/body/section/div/div[1]/ol/li[2]");
	    By registerLoginButton = By.xpath("/html/body/section/div/section/div[2]/div/div/div[2]/p[2]/a");
	    
	    By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");
	    By viewCartButton = By.xpath("//a[contains(text(),'View Cart')]");
//remove product from cart	    
	    By removeProductButton = By.xpath("//a[@class='cart_quantity_delete']");
	    By cartProducts = By.xpath("//*[@id=\"product-1\"]");
	    
	//Recommended Cart product
	    By recommendedcartProduct = By.xpath("//*[@id=\"product-1\"]");

	    public CartPage(WebDriver driver) {
	    	super(driver);
	    }

	    public By getCartProductsLocator() {
	        return cartProducts;
	    }
	    public boolean isFirstProductInCart() {
	        return driver.findElement(firstProductInCart).isDisplayed();
	    }

	    public boolean isSecondProductInCart() {
	        return driver.findElement(secondProductInCart).isDisplayed();
	    }

	    public String getFirstProductPrice() {
	        return driver.findElement(firstProductPrice).getText();
	    }

	    public String getSecondProductPrice() {
	        return driver.findElement(secondProductPrice).getText();
	    }

	    public int getFirstProductQuantity() {
	        return Integer.parseInt(driver.findElement(firstProductQuantity).getAttribute("value"));
	    }

	    public int getSecondProductQuantity() {
	        return Integer.parseInt(driver.findElement(secondProductQuantity).getAttribute("value"));
	    }

	    public String getTotalPrice() {
	        return driver.findElement(totalPrice).getText();
	    }
 //view & add any product in cart from home page and increase quantity to 4  	
	    
	    public boolean isProductInCart() {
	        //return driver.findElement(productInCart).isDisplayed();
	        List<WebElement> products = driver.findElements(cartProducts);
	        return products.size() > 0;
	    }

	    public int getProductQuantity() {
	        String quantity = driver.findElement(productQuantity).getText();
	        return Integer.parseInt(quantity);
	    }
	    
//Checkout process
	    public boolean isCartPageVisible() {
	        return driver.findElement(cartPage).isDisplayed();
	    }

	    public void clickProceedToCheckoutButton() {
	        driver.findElement(proceedToCheckoutButton).click();
	    }
	    
	    public void clickContinueShopping() {
	        driver.findElement(continueShoppingButton).click();
	    }

	    public void clickViewCart() {
	        driver.findElement(viewCartButton).click();
	    }
//Register while checkout	    
	    public void clickRegisterLoginButton() {
	        driver.findElement(registerLoginButton).click();
	    }
//remove product from cart
	    public void removeProductFromCart() {
	        driver.findElement(removeProductButton).click();
	    }

	    public boolean areProductsInCart() {
	        List<WebElement> products = driver.findElements(cartProducts);
	        return products.size() > 0;
	    }
//Add recommended product in cart
	    public boolean isRecommendedProductInCart() {
	        return driver.findElement(recommendedcartProduct).isDisplayed();
	    }
	    
}
