package framework;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.LinkedHashMap;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelLib extends Baseclass {

		/**
		 * getRequestParametrs to get the http request parametrs from the excel file
		 * 
		 * @param testCaseName
		 * @param excelPath
		 * @param sheetName
		 */

		public static LinkedHashMap getRequestParameters(String testCaseName, String excelPath, String sheetName) {

			LinkedHashMap apiReqData = new LinkedHashMap();
			try {
				FileInputStream fis = new FileInputStream(excelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rows = sh.getPhysicalNumberOfRows();
				for (int i = 0; i < rows; i++) {
					if (sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						for (int j = 2; j < sh.getRow(i).getPhysicalNumberOfCells(); j++) {
							
							
							apiReqData.put(sh.getRow(1).getCell(j).getStringCellValue(),
									sh.getRow(i).getCell(j).getStringCellValue());
						}
						break;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return apiReqData;
	
	
}
	}
		
			

	
