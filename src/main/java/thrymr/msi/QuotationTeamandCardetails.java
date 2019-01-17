//package thrymr.msi;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class QuotationTeamandCardetails {
//
//	public static void teamDetails(RaceSeriesObjectData ob, WebDriver driver, String quotationtype) throws Exception {
//		boolean flag = false;
//		String raceTeamname = null;
//		String quotationButton = "(//a[@type='button'])[1]";
//		WaitForElementVisible(driver, By.xpath(quotationButton));
//		driver.findElement(By.xpath(quotationButton)).click();
//		String racingDropdown = "//span[contains(text(),'Select Racing Name')]";
//		WaitForElementVisible(driver, By.xpath(racingDropdown));
//		driver.findElement(By.xpath(racingDropdown)).click();
//		String searchField = "(//input)[1]";
//		
//		if (quotationtype.contains("Raceseries")) {
//			raceTeamname = ob.getRaceSeriesRaceTeamName();
//			System.out.println(raceTeamname+ "race-----");
//			driver.findElement(By.xpath(searchField)).sendKeys(raceTeamname);
//		}
//		else if (quotationtype.contains("Testseries")) {
//			raceTeamname = ob.getTestSeriesRaceTeamName();
//			driver.findElement(By.xpath(searchField)).sendKeys(raceTeamname);
//		}
//		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
//		List<WebElement> ul = Table.findElements(By.tagName("ul"));
//		for (int i = 0; i <= ul.size(); i++) {
//			Thread.sleep(2000);
//			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
//			for (int j = 0; j <= li.size(); j++) {
//				if (li.get(j).getText().contains(raceTeamname)) {
//					li.get(j).click();
//					flag = true;
//					break;
//				}
//			}
//
//			if (flag == true) {
//				break;
//			}
//		}
//		String nextButton = "//button[@type='submit']";
//		// WaitForElementVisible(driver,By.xpath(nextButton));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(nextButton)).click();
//	}
//
//	public static void carDetails(RaceSeriesObjectData obj, WebDriver driver, String quotationtype) throws Exception {
//		boolean flag = false;
//		String VIN = null;
//		String vinDropdown = "//span[contains(text(),'Select VIN')]";
//		WaitForElementVisible(driver, By.xpath(vinDropdown));
//		driver.findElement(By.xpath(vinDropdown)).click();
//		String searchField = "(//input)[1]";
//		
//		if (quotationtype.contains("Raceseries")) {
//			VIN = obj.getRaceseriesVIN();
//			driver.findElement(By.xpath(searchField)).sendKeys(VIN);
//		}
//		else if (quotationtype.contains("Testseries")) {
//			VIN = obj.getTestSeriesVIN();
//			System.out.println(VIN+"--------");
//			driver.findElement(By.xpath(searchField)).sendKeys(VIN);
//		}
//		
//		Thread.sleep(3000);
//		WebElement Table = driver.findElement(By.xpath("(//div[@class='dropdown-list'])[1]"));
//		List<WebElement> ul = Table.findElements(By.tagName("ul"));
//		for (int i = 0; i <= ul.size(); i++) {
//			Thread.sleep(3000);
//			List<WebElement> li = ul.get(i).findElements(By.tagName("li"));
//			for (int j = 0; j < li.size(); j++) {
//				if (li.get(j).getText().contains(VIN)) {
//					li.get(j).click();
//					flag = true;
//					break;
//				}
//			}
//			if (flag == true) {
//				break;
//			}
//		}
//		driver.findElement(By.xpath("//span[@class='label-text mandatory']")).click();
//		String nextButton = "//button[@type='submit']";
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(nextButton)).click();
//	}
//	
//	public static void WaitForElementVisible(WebDriver driver, By locator) {
//		WebDriverWait wait = new WebDriverWait(driver, 10000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//	}
//	
//	
//}
