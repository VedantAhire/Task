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

	static XSSFWorkbook wb; //class implements Workbook interface

	static XSSFSheet sheet;//class implements Sheet interface
	

	

	
	public Object[][] getStudData() {
		
		File f = new File(".//ExcelData//Data.xlsx");// load path
		try {
			fis = new FileInputStream(f);// load file
			wb = new XSSFWorkbook(fis);// read the excel file 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheet("StData");// get sheetname 

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) // for Excel sheet row
			{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)// for excel sheet column
			{
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();// fetching all data (i+1) is for the fetching from second row because first row contains title
			}// toString() is used for alphanumeric i.e. your email id ex. ab123@gmail.com
		}
		return data;
	}
		public void sendMail(String Name, String email)
		{
           System.out.println("Hi "+Name+" your email is "+email+" and your class will starts from tomorrow ");			
		}
}