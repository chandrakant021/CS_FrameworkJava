package com.Mycard.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	

  public static String getCellValue(String filename, String sheetname, int rowno, int cellno)
   {
		
	try {
			fis = new FileInputStream(filename);
			
			workbook = new XSSFWorkbook(fis);
			excelsheet =workbook.getSheet(sheetname);
			
			cell = workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
			
			workbook.close();
			
			return cell.getStringCellValue();
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
	        return "";
		}
		
		
	}
	
	public static int getRowCount (String filename, String sheetname) 
	{
		
	try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
			excelsheet = workbook.getSheet(sheetname);
			
			int totalrow = excelsheet.getLastRowNum()+1;
			
			workbook.close();
			
			return totalrow;
			
		} 
	catch (Exception e) 
	    {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	public static int getCellCount(String filename, String sheetname) 
	{
		
	try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
			excelsheet =workbook.getSheet(sheetname);
			int totalcell = excelsheet.getRow(0).getLastCellNum();
			
			workbook.close();
			
			return totalcell;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
}
