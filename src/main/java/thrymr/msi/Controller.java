package thrymr.msi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

public class Controller {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("test-type");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://staging.tdis.co/");
		helper(file, driver);
		Controller ct = new Controller();
	
	}

	public static void helper(File file, WebDriver driver) throws Exception {
		// Extracting Data from Excel
		Map<Integer, Map> map = Excellfile.getDataFromExcel(file);
		Map<Integer, List<LoginObjectData>> loginData = map.get(0);
		Map<Integer, List<RaceSeriesObjectData>> RsData = map.get(1);
		Map<Integer, List<TestSeriesObjectData>> TsData = map.get(2);

		// sheetlist
		Set<Integer> keys = map.keySet();

		// RowsCount
		Set<Integer> rskeys = RsData.keySet();
		Set<Integer> tskeys = TsData.keySet();
		Set<Integer> loginkeys = loginData.keySet();

		for (Integer key : keys) {

			System.out.println(key);

			if (key == 0) {

				for (Integer loginkey : loginkeys) {
					List<LoginObjectData> loginList = loginData.get(loginkey);
					LoginObjectData loginObject = loginList.get(loginkey - 1);
					if (loginObject.getRole().contains("producing_broker")) {

						Login.login(loginObject, driver);
						ManualRaceseriesQuotation.Teamdetails(driver);
						ManualRaceseriesQuotation.CarDetails(driver);
						ManualRaceseriesQuotation.raceDetails(driver);
					}
				}
			}

			// if (key == 1) {
			// for (Integer rskey : rskeys) {
			// List<RaceSeriesObjectData> rsList = RsData.get(rskey);
			// RaceSeriesObjectData rsObject = rsList.get(rskey - 1);
			// CreateraceseriesQuotation crQ = new CreateraceseriesQuotation(rsObject,
			// driver);
			// }
			// }

//			if (key == 2) {
//				for (Integer tskey : tskeys) {
//					List<TestSeriesObjectData> tsList = TsData.get(tskey);
//					TestSeriesObjectData tsObject = tsList.get(tskey - 1);
//					CreateTestseriesQuotation ctq = new CreateTestseriesQuotation(tsObject, driver);
//
//				}
//			}

		}
	}

	public static void WaitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void WaitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.alertIsPresent());
	}
}