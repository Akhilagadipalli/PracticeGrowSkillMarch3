package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConstantsData.Constants;

public class StoreAccountIdToExcel {
	public static void writeCustomerId(String filePath, String sheetName, String customerId) throws Exception {

        File file = new File(Constants.Store_Account_Id_excel);

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);
        }

        int lastRow = sheet.getLastRowNum();
        int newRow = lastRow + 1;

        sheet.createRow(newRow).createCell(0).setCellValue(customerId);

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        
    }

}
