package thrymr.msi;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellfile {

	public static XSSFWorkbook book;

	public static XSSFSheet sht;

	// Getting data form excel
	public static Map getDataFromExcel(File path) throws Exception {
		checkfile(path);
		Map<Integer, Map> map = new HashMap<Integer, Map>();
		FileInputStream excelFile = new FileInputStream(path);
		DataFormatter formatter = new DataFormatter();
		List<RaceSeriesObjectData> rsList = new ArrayList<RaceSeriesObjectData>();
		List<TestSeriesObjectData> tsList = new ArrayList<TestSeriesObjectData>();
		List<LoginObjectData> loginList = new ArrayList<LoginObjectData>();
		Map<Integer, List<RaceSeriesObjectData>> RsData = new HashMap<Integer, List<RaceSeriesObjectData>>();
		Map<Integer, List<TestSeriesObjectData>> TsData = new HashMap<Integer, List<TestSeriesObjectData>>();
		Map<Integer, List<LoginObjectData>> loginData = new HashMap<Integer, List<LoginObjectData>>();

		book = new XSSFWorkbook(excelFile);
			if (book.getNumberOfSheets() != 0) {

			for (int i = 0; i < book.getNumberOfSheets(); i++) {
				String sheetame = book.getSheetName(i);
				sht = book.getSheet(sheetame);
				// Getting Login Data From Excel

				if (book.getSheetName(i).equalsIgnoreCase("login")) {
					
					for (int rownum = 1; rownum <= sht.getLastRowNum(); rownum++) {
					LoginObjectData lgn = new LoginObjectData();
					lgn.setRole(formatter.formatCellValue(sht.getRow(rownum).getCell(0)));
					lgn.setUsername(formatter.formatCellValue(sht.getRow(rownum).getCell(1)));
					lgn.setPassword(formatter.formatCellValue(sht.getRow(rownum).getCell(2)));
					loginList.add(lgn);
					loginData.put(rownum, loginList);
					}
					map.put(i, loginData);

				}

				// Getting Race Series Data From Excel

				else if (book.getSheetName(i).equalsIgnoreCase("Raceseries")) {

					for (int rownum = 1; rownum <= sht.getLastRowNum(); rownum++) {
						RaceSeriesObjectData ob = new RaceSeriesObjectData();
						ob.setRaceSeriesRaceTeamName(formatter.formatCellValue(sht.getRow(rownum).getCell(0)));
						ob.setRaceseriesVIN(formatter.formatCellValue(sht.getRow(rownum).getCell(1)));
						ob.setRacingSeries(formatter.formatCellValue(sht.getRow(rownum).getCell(2)));
						ob.setRacingSeriesSeason(formatter.formatCellValue(sht.getRow(rownum).getCell(3)));
						ob.setRaceEvent(formatter.formatCellValue(sht.getRow(rownum).getCell(4)));
						ob.setRaceSeriesDriverName(formatter.formatCellValue(sht.getRow(rownum).getCell(5)));
						rsList.add(ob);
						RsData.put(rownum, rsList);
					}
					map.put(i, RsData);
				}

				// Getting Test Series Data From Excel

				else if (book.getSheetName(i).equalsIgnoreCase("testseries")) {
					for (int rownum = 1; rownum <= sht.getLastRowNum(); rownum++) {
						TestSeriesObjectData Td = new TestSeriesObjectData();
						Td.setTestSeriesRaceTeamName(formatter.formatCellValue(sht.getRow(rownum).getCell(0)));
						Td.setTestSeriesVIN(formatter.formatCellValue(sht.getRow(rownum).getCell(1)));
						Td.setKindofTrack(formatter.formatCellValue(sht.getRow(rownum).getCell(2)));
						Td.setNoOfDays(formatter.formatCellValue(sht.getRow(rownum).getCell(3)));
						Td.setNameofRaceTrack(formatter.formatCellValue(sht.getRow(rownum).getCell(4)));
						Td.setStartDate(formatter.formatCellValue(sht.getRow(rownum).getCell(5)));
						Td.setEnddate(formatter.formatCellValue(sht.getRow(rownum).getCell(6)));
						Td.setTestSeriesDriverName(formatter.formatCellValue(sht.getRow(rownum).getCell(7)));
						tsList.add(Td);
						TsData.put(rownum, tsList);
					}
					map.put(i, TsData);
				}

				else {
					System.out.println("");
				}

			}

		}

		return map;

	}

	
	
	
	// Check the Excel file exists or not
	public static void checkfile(File path) throws Exception {

		File file = path;
		try {
			if (!file.exists()) {
			} else {
//				System.out.println("fileexists");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
