package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderMapUtils {

    @DataProvider(name = "KsrtcData")
    Object[][] getData() throws IOException {
        Object[][] data = new Object[][] {
                {"Mysore", "Bangalore", "3 December 2023"},
                {"Mysore", "Bangalore", "5 December 2023"},
        };

//        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH);
//        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = workbook.getSheet("KSRTCData");
//
//        int rowNum = sheet.getLastRowNum();
//        int colNum = sheet.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[rowNum][1];
//        Map<String, String> map;
//
//        for(int i=1; i<=rowNum; i++) {
//            map =  new HashMap<>();
//            for (int j = 0; j < colNum; j++) {
//                String key = sheet.getRow(0).getCell(j).getStringCellValue();
//                String value = sheet.getRow(i).getCell(j).getStringCellValue();
//                map.put(key, value);
//            }
//            data[i - 1][0] = map;
//        }
        return data;
    }
}
