package org.ss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Apiprojects\\testdata\\Book1.xlsx");
		
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook wb =new XSSFWorkbook(stream);
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);
		
		System.out.println("sujith");
		System.out.println("kumar");
		
		
		
		
		
		
		
		
		
		
	}

}
