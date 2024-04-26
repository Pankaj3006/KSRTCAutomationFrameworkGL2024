package com.pan.utilities;

import com.pan.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReaderUtils {

    public static List<Map<String, String>> readData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("KSRTCData");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        List<Map<String, String>> list = new ArrayList<>();

        for(int i=1; i<=rowNum; i++) {
            Map map = new HashMap();
            for(int j=0; j<colNum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
            }
            list.add(map);
        }
        return list;
        }
    }
