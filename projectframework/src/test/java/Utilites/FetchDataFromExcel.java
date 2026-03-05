package Utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConstantsData.Constants;

public class FetchDataFromExcel {
  
	public static String getURL(int x, int y) throws IOException 
	{
		FileInputStream fs =new FileInputStream(Constants.EXCEL_FILE_PATH);
		XSSFWorkbook workbook =new XSSFWorkbook(fs);
		XSSFSheet sheet =workbook.getSheetAt(0);
		XSSFCell val =sheet.getRow( x).getCell( y);
		String url =val.toString();
		return url;
	}
	
	
}