package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Baseclass.Library;



public class Excelutility extends Library{
	
	public Excelutility() {
		logger = Logger.getLogger(Excelutility.class.getName());
	}
	
	public String ExcelRead(String sheet, int RowNumber, int CellNumber) throws IOException  {
		File path = new File("src/test/resources/TestData/FlipkartTestData.xlsx");
		FileInputStream read = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(read);
		
		Sheet sh= book.getSheet(sheet);
		
		Row row = sh.getRow(RowNumber);
		
		Cell c = row.getCell(CellNumber);
		logger.info("====== Read Excel Sheet =======");

		
		return c.getStringCellValue();
	}
	
	public void ExcelWrite(String sheet, int RowNumber, int CellNumber, String text) throws IOException {
		File path1 = new File("src/test/resources/TestData/FlipkartTestData.xlsx");
		FileInputStream read = new FileInputStream(path1);
		XSSFWorkbook book = new XSSFWorkbook(read);
		
		Sheet sh= book.getSheet(sheet);
		
		Row row = sh.getRow(RowNumber);
		
		Cell c = row.createCell(CellNumber);
		c.setCellValue(text);
		
		FileOutputStream write = new FileOutputStream(path1);
		
		book.write(write);
		logger.info("====== Write Excel Sheet =======");
	}
}
