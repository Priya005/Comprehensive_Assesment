package com.utility;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
public ArrayList<String> getData(String testcaseName) throws IOException {

		
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream(".\\testData\\demodata.xlsx");
		
		System.out.println("file found");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("i m in workbook");
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				
			XSSFSheet sheet = workbook.getSheetAt(i);
			
			Iterator<Row> rows = sheet.iterator();
			
			Row firstrow =rows.next();
			
			Iterator<Cell> ce = firstrow.iterator();
			
			int column=0;
			while(ce.hasNext()) {
				
				Cell c1 = ce.next();
				
				if(c1.getStringCellValue().equalsIgnoreCase("Testcases")) {
				  break;
				}
			
				  column++;	
			}
			
			System.out.println("tets cases column pesent at this index :"+column);
			
			int c=0;
			
			while(rows.hasNext()){
				
				Row r = rows.next();
				
				Cell v =r.getCell(column);
				
				if( v.getStringCellValue().equalsIgnoreCase(testcaseName)) {
					
					Iterator<Cell> cv = r.cellIterator();
					
					while(cv.hasNext() ) {
						Cell h = cv.next();
						
						System.out.println("column index :" + c);
						c++;
						
						  a.add(h.getStringCellValue());
					}
					
					break;
				}
			}
		}
			
	}	
		
		return a;
	}
	}
