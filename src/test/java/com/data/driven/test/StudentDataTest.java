package com.data.driven.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.data.driven.Exceldata.StudentData;

public class StudentDataTest extends StudentData{
	
	StudentData data;
	
	@DataProvider
	public Object[][] getStudentData()
	{
		data= new StudentData();
		Object[][] data1 = data.getStudData();
		return data1;
	}
	
	@Test(dataProvider="getStudentData")
	public void sendEmailTest(String name, String email)
	{
		data.sendMail(name, email);
	}
	
	

}
