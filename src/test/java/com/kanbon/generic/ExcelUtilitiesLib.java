package com.kanbon.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilitiesLib
{
	public static String readData(String filepath,String sheetname,int row, int col)
	{
		String value=null;
		try 
		{
			Workbook wf = WorkbookFactory.create(new FileInputStream(new File(filepath)));
			value=wf.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		catch (EncryptedDocumentException e)
		{

			e.printStackTrace();
		} 
		catch (InvalidFormatException e) 
		{

			e.printStackTrace();
		} 
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		} 
		catch (IOException e)
		{

			e.printStackTrace();
		}
		return value;

	}

}
