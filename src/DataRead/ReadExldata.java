package DataRead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExldata {
	public static String[][] Exlread() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream InptStrm=new FileInputStream(System.getProperty("user.dir")+"\\src\\Data\\DataDriven.xls");
        HSSFWorkbook Workbk=new HSSFWorkbook(InptStrm);
        Sheet sh=Workbk.getSheet("Sheet1");
        int rowsize=sh.getLastRowNum();
        int colmnsize=sh.getRow(0).getLastCellNum();
        //to validate both row and column we r using 2for loops
        String[][] data=new String[rowsize][colmnsize];
        String value="";
        for(int i=0;i<rowsize;i++)
        {
        	Row row=sh.getRow(i);
        	for(int j=0;j<colmnsize;j++)
        	{
        		//row.getcell finds the find cell value(keyword)getcelltype finds what type of data(string/int) if the value is string print the data type
        	        		try{
        	        			if(row.getCell(j).getCellType()==HSSFCell.CELL_TYPE_STRING)
        		{
        	        				value=row.getCell(j).getStringCellValue();
        		}
        		else
        		{
        			value=""+row.getCell(j).getNumericCellValue();
        		}
        	        			data[i][j]=value;
        	}
        	        		catch(NullPointerException e)
        	        		{
        	        			
        	        		}
        	}
        	
        }
        return data;
   
	}

}

