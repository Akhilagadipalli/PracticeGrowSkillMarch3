package Utilites;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteDataToExcel {
	 public static void writeCustomerId(String filePath, String sheetName, 
             int rowNum, int cellNum, String customerId)
throws IOException {

FileInputStream fis = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheet(sheetName);

if (sheet.getRow(rowNum) == null) {
sheet.createRow(rowNum);
}

sheet.getRow(rowNum).createCell(cellNum).setCellValue(customerId);

fis.close();

FileOutputStream fos = new FileOutputStream(filePath);
workbook.write(fos);
fos.close();
workbook.close();
}
}
