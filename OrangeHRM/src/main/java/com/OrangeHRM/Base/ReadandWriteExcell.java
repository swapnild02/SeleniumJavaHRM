package com.OrangeHRM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadandWriteExcell {
	WebDriver driver;
	
	 File file=null;
	 FileInputStream fis=null;
	 XSSFWorkbook wb=null;
	 XSSFSheet sheet=null;
	 XSSFRow row;
	 XSSFCell cell;
	 int lastrow;
	 int lastcolumn;
	 Object[][] data;
	 Workbook book;
	 Sheet sheet1;
	 Base baseclass;
	
	 //String filepath="D:\\TestNG\\OrangeHRM\\src\\main\\java\\ExcellFileTestData\\TestData.xlsx";

//	public  Object[][] readDataFromExcell(String sheetname){
//		
//		try {
//			file=new File(filepath);
//			fis=new FileInputStream(file);
//			wb=new XSSFWorkbook(fis);
//			sheet=wb.getSheet("Login");
//			row=sheet.getRow(0);
//			 lastrow=sheet.getLastRowNum();
//			 lastcolumn=row.getLastCellNum();
//			 data=new Object[lastrow][lastcolumn];
//			for(int i=0;i<lastrow;i++){
//				row = sheet.getRow(i);
//				for(int j=0;j<lastcolumn;j++){
//					cell=row.getCell(j);
//					if(cell.getCellType()==CellType.STRING){
//						data[i][j]=cell;
//					}
//					else if(cell.getCellType()==CellType.NUMERIC){
//						data[i][j]=cell;
//					}
//					else if(cell.getCellType()==CellType.BLANK){
//						data[i][j]=cell;
//					}
//					else if(cell.getCellType()==CellType.BOOLEAN){
//						data[i][j]=cell;
//					}
//				}
//				//System.out.println();
//			}
//			for(int i=0;i<lastrow;i++){
//				for(int j=0 ;j<lastcolumn;j++){
//					//data[i][j];
//					//System.out.print("----"+data[i][j]);
//				//System.out.println();
//				}
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return data;
//		
//	}
//	public static void main(String[] args) {
//		ReadandWriteExcell rw=new ReadandWriteExcell();
//		rw.readDataFromExcell("Login");
//		
//	}
	
	public Object[][] readFromExcellFile(String sheetName){
		
		try 
		{
			baseclass=new Base();
			file=new File(baseclass.prop.getProperty("TestDataExcell"));
			fis=new FileInputStream(file);
			book=WorkbookFactory.create(fis);
			sheet1=book.getSheet(sheetName);
			int lastRow=sheet1.getLastRowNum();
			int lastCol=sheet1.getRow(0).getLastCellNum();
			data=new Object[lastRow][lastCol];
			for(int i=0;i<lastRow;i++){
				for(int j=0;j<lastCol;j++){
					data[i][j]=sheet1.getRow(i+1).getCell(j).toString();
					System.err.println(data[i][j]);
				}
			}
			
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
		
		
	}
	
	
}
