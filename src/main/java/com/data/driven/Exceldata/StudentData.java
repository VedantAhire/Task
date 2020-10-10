package com.data.driven.Exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentData {
	
	static FileInputStream fis;

	static XSSFWorkbook wb;

	static XSSFSheet sheet;
	
	String sheetName;
	
	static Properties pro;

	
	public Object[][] getStudData() {
		File f = new File(".//ExcelData//Data.xlsx");
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheet("StData");

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
		public void sendMail(String Name, String email)
		{
           System.out.println("Hi "+Name+" your email is "+email+" and your class will starts from tomorrow ");			
		}
}