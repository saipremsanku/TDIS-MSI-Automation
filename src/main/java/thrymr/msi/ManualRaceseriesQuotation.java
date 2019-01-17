package thrymr.msi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManualRaceseriesQuotation {

	public static void Teamdetails(WebDriver driver) throws InterruptedException {
		boolean flag = false;
		String quotationButton = "(//a[@type='button'])[1]";
		String racingDropdown = "//span[contains(text(),'Select Racing Name')]";
		String searchField = "(//input)[1]";
		String zip = "//input[@formcontrolname='zip']";
		String phoneNumber = "//input[@formcontrolname='phoneNumber']";
		String ContactPersonname = "//input[@formcontrolname='contactPersonName']";
		String contactPersonPhoneNo = "//input[@formcontrolname='contactPersonPhoneNo']";
		String contactPersonsaluation = "(//select[@formcontrolname='contactPersonSalutation']//option)[1]";
		String city = "//input[@formcontrolname='city']";
		String companyname = "//input[@formcontrolname='companyName']";
		String email = "//input[@formcontrolname='email']";
		String adress = "//input[@formcontrolname='adress']";
		String state = "//input[@formcontrolname='state']";
		String Country = "//span[contains(text(),'Select Country')]";
		String CountrySearch = "//input[@placeholder='Search']";

		WaitForElementVisible(driver, By.xpath(quotationButton));
		driver.findElement(By.xpath(quotationButton)).click();
		WaitForElementVisible(driver, By.xpath(racingDropdown));
		driver.findElement(By.xpath(racingDropdown)).click();
		driver.findElement(By.xpath(searchField)).sendKeys("SHUB");
		Thread.sleep(1000);
		driver.findElement(By.xpath(zip)).sendKeys("S238");
		driver.findElement(By.xpath(companyname)).sendKeys("thrymr");
		driver.findElement(By.xpath(contactPersonsaluation)).click();
		driver.findElement(By.xpath(ContactPersonname)).sendKeys("ContactPersonname");
		driver.findElement(By.xpath(contactPersonPhoneNo)).sendKeys("7984654");
		driver.findElement(By.xpath(city)).sendKeys("Hyder");
		driver.findElement(By.xpath(phoneNumber)).sendKeys("9848022338");
		driver.findElement(By.xpath(email)).sendKeys("thrymr@gmail.com");
		driver.findElement(By.xpath(adress)).sendKeys("T building kapil towers hyd");
		driver.findElement(By.xpath(state)).sendKeys("TS");
		driver.findElement(By.xpath(Country)).click();
		driver.findElement(By.xpath(CountrySearch)).sendKeys("Germany");
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[2]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().contains("Germany")) {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();
	}

	public static void CarDetails(WebDriver driver) throws InterruptedException {
		String vin = "//span[contains(text(),'Select VIN')]";
		String yearOfBuilt = "//span[contains(text(),'Select Year')]";
		String Manufacturer = "//span[contains(text(),'Select Manufacturer')]";
		String Model = "//span[contains(text(),'Select Model')]";
		String racingCarType = "//span[contains(text(),'Racing Car Type')]";
		String currencyType = "//span[contains(text(),'Select Currency')]";
		String sumInsuredAccident = "//input[@formcontrolname='sumInsuredAccident']";
		String sumInsuredFire = "//input[@formcontrolname='sumInsuredFire']";
		String nextButton = "//button[@type='submit']";
		
		driver.findElement(By.xpath(vin)).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Car VIN Number']")).sendKeys("456789");
		driver.findElement(By.xpath(yearOfBuilt)).click();
		SearchFunctionality(driver, "(//input[@placeholder='Search'])[1]", "2018",2);
		driver.findElement(By.xpath(Manufacturer)).click();
		SearchFunctionality(driver, "(//input[@placeholder='Search'])[2]", "Audi",3);
		
		driver.findElement(By.xpath(Model)).click();
		SearchFunctionality(driver, "(//input[@placeholder='Search'])[3]", "R8",4);
		driver.findElement(By.xpath(racingCarType)).click();
		Thread.sleep(1000);
		SearchFunctionality(driver, "(//input[@placeholder='Search'])[4]", "gt3",5);
//		driver.findElement(By.xpath(currencyType)).click();
//		SearchFunctionality(driver, "(//input[@placeholder='Search'])[5]", "eur",6);
		driver.findElement(By.xpath("//span[@class='label-text mandatory']")).click();
		driver.findElement(By.xpath(sumInsuredAccident)).sendKeys("95444555");
		driver.findElement(By.xpath(sumInsuredFire)).sendKeys("95444555");
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();
		
		
	}

	public static void SearchFunctionality(WebDriver driver, String xpath, String inputkeyword, int index) throws InterruptedException {
		
		Boolean flag = false;
		driver.findElement(By.xpath(xpath)).sendKeys(inputkeyword);
		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])["+index+"]"));
		List<WebElement> ul = Table.findElements(By.tagName("ul"));
		for (int i = 0; i <= ul.size(); i++) {
			Thread.sleep(2000);
			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
			for (int j = 0; j <= li.size(); j++) {
				if (li.get(j).getText().equalsIgnoreCase(inputkeyword)) {
					li.get(j).click();
					flag = true;
					break;
				}
			}

			if (flag == true) {
				break;
			}
		}
		
	}

	public static void raceDetails(WebDriver driver) throws Exception {
		boolean flag = false;
		String racingSeries = "(//div[@class='c-btn'])[1]";
		String search = "(//input[@placeholder='Search'])[1]";
		String racingyear = "(//div[@class='c-btn'])[2]";
		String YearSearch = "(//input[@placeholder='Search'])[2]";
		String raceTrack = "(//div[@class='c-btn'])[3]";
		String nextButton = "(//button[@type='submit'])[2]";
		WaitForElementVisible(driver, By.xpath(racingSeries));
		driver.findElement(By.xpath(racingSeries)).click();
		SearchFunctionality(driver, search, "adac 24h", 1);
		WaitForElementVisible(driver, By.xpath(racingyear));
		driver.findElement(By.xpath(racingyear)).click();
		driver.findElement(By.xpath(YearSearch)).sendKeys("2019");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='dropdown-list'])[2]//ul//li")).click();
		driver.findElement(By.xpath(raceTrack)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[contains(text(),'Select All')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextButton)).click();

	}
	
	
	
	public static void WaitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
