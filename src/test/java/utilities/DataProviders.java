package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {


    //DataProvider 1

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        String path = "C:\\Automation Testing Documents\\IHP-master\\testData\\TC_001.xlsx";//taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path);//creating an object for XLUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for (int i = 1; i <= totalrows; i++)  //1   //read the data from xl storing in two deminsional array
        {
            for (int j = 0; j < totalcols; j++)  //0    i is rows j is col
            {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array

    }


    public static Object[][] readExcelData(String excelfileName) throws IOException{
        XSSFWorkbook wbook =
                new XSSFWorkbook("./testData/"+excelfileName+".xlsx");
        XSSFSheet sheet = wbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                String stringCellValue = cell.getStringCellValue();
                data[i-1][j] = stringCellValue;
            }
        }
        wbook.close();
        return data;
    }



    //DataProvider 2

    //DataProvider 3

    //DataProvider 4
}
