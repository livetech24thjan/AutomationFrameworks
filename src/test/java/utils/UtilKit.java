package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	static FileInputStream fis;
	
	public static HashMap<String,String> getTestDataFromExcel(String testCase)
	{
		
		try {
			fis=new FileInputStream("src\\test\\resources\\testdata\\excels\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb=null;
		
		try {
			 wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet  ws=wb.getSheet("com.adactin");
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws, testCase);
		
		HashMap<String, String> dataMap=new HashMap<String, String>();
		
		for(int i=0;i<testCaseRows.size();i++)
		{
			for(int j=1;j<testCaseRows.get(0).getLastCellNum();j++)
			{
				dataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
			}
		}
		
		return dataMap;
		
	}
	
	public static ArrayList<Row> getTestCaseRows(Sheet ws,String testCase)
	{
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
		}
		
		System.out.println("allRows   "+allRows.size());
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCase))
			{
				testCaseRows.add(allRows.get(i));
			}
		}
		
		System.out.println("testCaseRows   "+testCaseRows.size());
		
		return testCaseRows;
		
	}

}
