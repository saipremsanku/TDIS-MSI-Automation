package thrymr.msi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public static void login(LoginObjectData ln,WebDriver driver) {
		
		String email = "//input[@type='email']";
		String password = "//input[@type='password']";
		String loginButoon = "//button[@type='submit']";
		WaitForElementVisible(driver, By.xpath(email));
		if(ln.getRole().contains("producing_broker")) {
			
			driver.findElement(By.xpath(password)).sendKeys(ln.getPassword());
			driver.findElement(By.xpath(email)).sendKeys(ln.getUsername());
			driver.findElement(By.xpath(loginButoon)).click();
			System.out.println(ln.getUsername());
			System.out.println(ln.getPassword());
			
		}
		

	}
	
	
	public static void WaitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
}
