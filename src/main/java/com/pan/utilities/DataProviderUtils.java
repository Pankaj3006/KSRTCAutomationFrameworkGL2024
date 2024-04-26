package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

    @DataProvider(name = "KsrtcData")
    Object[][] getData() throws IOException {
        Object[][] data = new Object[][] {
                {"Mysore", "Bangalore", "25 January 2024"},
                {"Mysore", "Bangalore", "27 January 2024"},
        };

//        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH);
//        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = workbook.getSheet("KSRTCData");
//
//        int rowNum = sheet.getLastRowNum();
//        int colNum = sheet.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[rowNum][colNum];
//
//        for(int i=1; i<=rowNum; i++) {
//
//            for (int j = 0; j < colNum; j++) {
//                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
//            }
//        }
        return data;
    }
}
