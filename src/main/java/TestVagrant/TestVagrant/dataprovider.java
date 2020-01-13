package TestVagrant.TestVagrant;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataprovider {

	public String path = System.getProperty("user.dir")+ "\\src\\main\\resources\\household.xlsx";
	public FileInputStream fis =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	String cellValue;
	public String getDataByColName(String sheetName, String colName, String rowName) {
		try {
			 FileInputStream fis =new FileInputStream(path);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet(sheetName);
			 for(int j=1;j<sheet.getPhysicalNumberOfRows();j++)
			 {
				 if(sheet.getRow(j).getCell(0).getStringCellValue().equalsIgnoreCase(rowName))
				 {
					 for(int i=1;i<sheet.getRow(0).getLastCellNum();i++)
						{
							if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(colName))
							{
								cell=sheet.getRow(j).getCell(i);
								break;
							}
						}
					 break;
				 }
			 }
			
		}catch(Exception e) {
			System.out.println("Unable to read file");
		}
		cellValue=cell.toString();
		if(cellValue==null ||cellValue.isEmpty())
		{ return "";
		}else
		return cellValue;
}
}
		

