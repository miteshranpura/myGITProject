package excelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readWriteExcel {

	public void readExcel (String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}
		
		Sheet ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum()-ws.getFirstRowNum();
		for(int i=0; i<rowCount+1 ; i++) {
			Row row = ws.getRow(i);
			for (int j=0; j<row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		}
		inputStream.close();
		wb.close();
	}
	
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Row newRow = sheet.createRow(rowCount+1);
		for(int j=0; j<dataToWrite.length; j++) {
			Cell cell = newRow.createCell(j);
			System.out.println(dataToWrite[j]);
			cell.setCellValue(dataToWrite[j]);
		}
		inputStream.close();
		
		
		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
		outputStream.close();
		wb.close();
	}
	
	public static void main(String[] args) throws IOException {
		readWriteExcel a = new readWriteExcel();
		String filePath = "C:\\"+"\\Mitesh";
//		a.readExcel(filePath,"frSelAuto.xlsx","Sheet1");
		System.out.println("read Sucessful");
		
		String[] strAr = {"Mr","Mitesh","Automation"};
//		String[] strAr = {"Mr"};
		a.writeExcel(filePath,"frSelAuto.xlsx","Sheet2",strAr);
		System.out.println("write Sucessful");
	}

}
