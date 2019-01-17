package thrymr.msi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTestseriesQuotation {

	public CreateTestseriesQuotation(TestSeriesObjectData obj, WebDriver driver) throws Exception {
		this.teamDetails(obj, driver);
		this.carDetails(obj, driver);
		this.addTestSeries(obj, driver);
		this.addDriver(obj, driver);

	}

	public  void teamDetails(TestSeriesObjectData ob, WebDriver driver) throws Exception {
		boolean flag = false;
		String quotationButton = "(//a[@type='button'])[1]";
		WaitForElementVisible(driver, By.xpath(quotationButton));
		driver.findElement(By.xpath(quotationButton)).click();
		String racingDropdown = "//span[contains(text(),'Select Racing Name')]";
		WaitForElementVisible(driver, By.xpath(racingDropdown));
		driver.findElement(By.xpath(racingDropdown)).click();
		String searchField = "(//input)[1]";
		driver.findElement(By.xpath(searchField)).sendKeys(ob.getTestSeriesRaceTeamName());
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().contains(ob.getTestSeriesRaceTeamName())) {
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

	public void carDetails(TestSeriesObjectData obj, WebDriver driver) throws Exception {
		boolean flag = false;
		String vinDropdown = "//span[contains(text(),'Select VIN')]";
		WaitForElementVisible(driver, By.xpath(vinDropdown));
		driver.findElement(By.xpath(vinDropdown)).click();
		String searchField = "(//input)[1]";
		driver.findElement(By.xpath(searchField)).sendKeys(obj.getTestSeriesVIN());
		Thread.sleep(3000);
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(3000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j < li.size(); j++) {
				if (li.get(j).getText().contains(obj.getTestSeriesVIN())) {
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

	// Adding Test Series data

	public void addTestSeries(TestSeriesObjectData ob, WebDriver driver) throws Exception {
		boolean flag = false;
		WaitForElementVisible(driver, By.xpath("//span[contains(text(),'Test Series')]"));
		driver.findElement(By.xpath("//span[contains(text(),'Test Series')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Select')])[6]")).click();
		String searchBox = "(//input[@placeholder = 'Search'])[4]";
		driver.findElement(By.xpath(searchBox)).sendKeys(ob.getKindofTrack());

		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[4]"));
		Thread.sleep(2000);
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j < li.size(); j++) {
				if (li.get(j).getText().contains(ob.getKindofTrack())) {
					li.get(j).click();
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@formcontrolname='noOfDays']")).sendKeys(ob.getNoOfDays());
		driver.findElement(By.xpath("(//button[contains(text(),'Add')])[2]")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
		driver.findElement(By.xpath("//div[@class='add-new-inner-cards']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(text(),'Select')])[7]")).click();
		String searchracename = "(//input[@placeholder = 'Search'])[5]";
		// String raceTrackname = "Nürburgring - Grand Prix";
		Thread.sleep(1000);
		driver.findElement(By.xpath(searchracename)).sendKeys(ob.getNameofRaceTrack());
		WebElement racelist = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[5]"));
		Thread.sleep(2000);
		List<WebElement> raceUl = racelist.findElements(By.tagName("ul"));
		for (int i = 0; i <= raceUl.size(); i++) {
			List<WebElement> raceLi = raceUl.get(i).findElements(By.tagName("li"));
			for (int j = 0; j < raceLi.size(); j++) {

				System.out.println(raceLi.get(j).getText());
				if (raceLi.get(j).getText().contains(ob.getNameofRaceTrack())) {
					raceLi.get(j).click();
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;
			}
		}

		String date = ob.getStartDate().concat(" - " + ob.getEnddate());
		driver.findElement(By.xpath("//input[@placeholder='Please select Date']")).sendKeys(date);
		driver.findElement(By.xpath("(//button[contains(text(),'Add Race Track')])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),'Next')])[2]")).click();

	}

	// Add Driver Details
	public void addDriver(TestSeriesObjectData obj, WebDriver driver) throws Exception {

		boolean flag = false;
		WaitForElementVisible(driver, By.xpath("//i[@class='fa fa-chevron-down']"));
		driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Driver')]")).click();
		WaitForElementVisible(driver, By.xpath("//span[contains(text(),'Select Driver Name')]"));
		driver.findElement(By.xpath("//span[contains(text(),'Select Driver Name')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Driver Name']"))
				.sendKeys(obj.getTestSeriesDriverName());
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
		Thread.sleep(2000);
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().equalsIgnoreCase(obj.getTestSeriesDriverName())) {
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
