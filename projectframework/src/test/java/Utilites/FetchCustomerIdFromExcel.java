package Utilites;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConstantsData.Constants;

public class FetchCustomerIdFromExcel {
	
	public static String writeCustomerId(int row, int col) throws Exception {

	    FileInputStream fis = new FileInputStream(Constants.Customer_Id);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    DataFormatter formatter = new DataFormatter();

	    String custId = formatter.formatCellValue(sheet.getRow(row).getCell(col));

	    return custId;

	}

}
