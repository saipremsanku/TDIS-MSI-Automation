package thrymr.msi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateraceseriesQuotation {
	
	public CreateraceseriesQuotation(RaceSeriesObjectData obj,WebDriver driver) throws Exception {
		
		this.teamDetails(obj, driver);
		this.carDetails(obj, driver);
		this.raceDetails(obj,driver);
		this.addDriverDetails(obj,driver);
	}
	
	
	public static void teamDetails(RaceSeriesObjectData ob, WebDriver driver) throws Exception {
		boolean flag = false;
		String quotationButton = "(//a[@type='button'])[1]";
		WaitForElementVisible(driver, By.xpath(quotationButton));
		driver.findElement(By.xpath(quotationButton)).click();
		String racingDropdown = "//span[contains(text(),'Select Racing Name')]";
		WaitForElementVisible(driver, By.xpath(racingDropdown));
		driver.findElement(By.xpath(racingDropdown)).click();
		String searchField = "(//input)[1]";
		driver.findElement(By.xpath(searchField)).sendKeys(ob.getRaceSeriesRaceTeamName());
	
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().contains(ob.getRaceSeriesRaceTeamName())) {
					li.get(j).click();
					flag = true;
					break;
				}
			}

			if (flag == true) {
				break;
			}
		}
		String nextButton = "//button[@type='submit']";
		// WaitForElementVisible(driver,By.xpath(nextButton));
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();
	}

	public static void carDetails(RaceSeriesObjectData obj, WebDriver driver) throws Exception {
		boolean flag = false;
		String vinDropdown = "//span[contains(text(),'Select VIN')]";
		WaitForElementVisible(driver, By.xpath(vinDropdown));
		driver.findElement(By.xpath(vinDropdown)).click();
		String searchField = "(//input)[1]";
		driver.findElement(By.xpath(searchField)).sendKeys(obj.getRaceseriesVIN());
		Thread.sleep(3000);
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(3000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j < li.size(); j++) {
				if (li.get(j).getText().contains(obj.getRaceseriesVIN())) {
					li.get(j).click();
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}
		}
		driver.findElement(By.xpath("//span[@class='label-text mandatory']")).click();
		String nextButton = "//button[@type='submit']";
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();
	}
	
	public  void raceDetails(RaceSeriesObjectData obj, WebDriver driver) throws Exception {
		boolean flag = false;
		String racingSeries = "(//div[@class='c-btn'])[1]";
		WaitForElementVisible(driver, By.xpath(racingSeries));
		String search = "(//input[@placeholder='Search'])[1]";
		driver.findElement(By.xpath(racingSeries)).click();
		driver.findElement(By.xpath(search)).sendKeys(obj.getRacingSeries());
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		Thread.sleep(2000);
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j < li.size(); j++) {
				if (li.get(j).getText().contains(obj.getRacingSeries())) {
					li.get(j).click();
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}
		}
		String racingyear = "(//div[@class='c-btn'])[2]";
		WaitForElementVisible(driver, By.xpath(racingyear));
		String YearSearch = "(//input[@placeholder='Search'])[2]";
		driver.findElement(By.xpath(racingyear)).click();
		driver.findElement(By.xpath(YearSearch)).sendKeys(obj.getRacingSeriesSeason());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='dropdown-list'])[2]//ul//li")).click();
		String raceTrack = "(//div[@class='c-btn'])[3]";
		driver.findElement(By.xpath(raceTrack)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Select All')])[1]")).click();
		String nextButton = "(//button[@type='submit'])[2]";
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();

	}

	public void addDriverDetails(RaceSeriesObjectData obj, WebDriver driver) throws Exception {
		boolean flag = false;
		String addDriver = "(//a[@type='button'])[1]";
		WaitForElementVisible(driver, By.xpath(addDriver));
		driver.findElement(By.xpath(addDriver)).click();
		driver.findElement(By.xpath("//span[contains(text(),'Select Driver Name')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Driver Name']")).sendKeys(obj.getRaceSeriesDriverName());
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		Thread.sleep(2000);
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().equalsIgnoreCase(obj.getRaceSeriesDriverName())) {
					li.get(j).click();
					flag = true;
					break;
				}
			}

			if (flag == true) {
				break;
			}
		}

		String submitButton = "//button[@type='submit']";
		WaitForelementToBeClickable(driver, By.xpath(submitButton));
		driver.findElement(By.xpath(submitButton)).click();
		Thread.sleep(2000);
			
		driver.findElement(By.xpath("//span[@class='label-text']")).click();
	}

	public static void WaitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void WaitForelementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

}
