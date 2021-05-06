package cn.resico.test.common.utils;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Excel {
    public int numOfRows;
    private String filePath;
    private Workbook workBook;
    private Sheet sheet;

    public Excel(String filePath, String sheetName) {
        this.filePath = filePath;
        this.load(sheetName);
    }

    public Excel(String filePath) {
        this.filePath = filePath;
        this.load(0);
    }

    public Excel(String filePath, Integer sheetIndex) {
        this.filePath = filePath;
        this.load(sheetIndex);
    }

    private void load(String sheetName) {
        try (FileInputStream inStream = new FileInputStream(new File(filePath))) {
            workBook = WorkbookFactory.create(inStream);
            sheet = workBook.getSheet(sheetName);
            numOfRows = sheet.getLastRowNum() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load(Integer sheetIndex) {
        try (FileInputStream inStream = new FileInputStream(new File(filePath))) {
            workBook = WorkbookFactory.create(inStream);
            sheet = workBook.getSheetAt(sheetIndex);
            numOfRows = sheet.getLastRowNum() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getColumnHeaderList() {
        List<String> columnHeaderList = new ArrayList<String>();
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            Cell cell = sheet.getRow(0).getCell(i);
            columnHeaderList.add(this.getCellValue(cell));
        }
        return columnHeaderList;
    }

    public String getCellValue(Cell cell) {
        String cellValue = "";
        DataFormatter formatter = new DataFormatter();
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = formatter.formatCellValue(cell);
                    } else {
                        double value = cell.getNumericCellValue();
                        int intValue = (int) value;
                        cellValue = value - intValue == 0 ?
                                String.valueOf(intValue) : String.valueOf(value);
                    }
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue().replaceAll("\n", "");
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = String.valueOf(cell.getCellFormula());
                    break;
                case _NONE:
                    cellValue = "";
                    break;
                case BLANK:
                    cellValue = "";
                    break;
                case ERROR:
                    cellValue = "";
                    break;
                default:
                    cellValue = cell.toString().trim();
                    break;
            }
        }
        return cellValue.trim();

    }

    public List<List<String>> getAllDataList() {
        List<List<String>> AllDataList = new ArrayList<>();
        for (int i = 1; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            AllDataList.add(getDataList(row));
        }
        return AllDataList;
    }

    public List<String> getDataList(Row row) {
        List<String> list = new ArrayList<String>();
        if (row != null && !this.isRowEmpty(row)) {
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                list.add(this.getCellValue(cell));
            }
        }
        return list;
    }


    public List<Map<String, String>> getAllDataMap() {
        List<Map<String, String>> AllMapData = new ArrayList<>();
        for (int i = 1; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            AllMapData.add(getDataMap(row));
        }
        return AllMapData;
    }

    public Map<String, String> getDataMap(Row row) {
        System.out.println(row.getCell(0).getStringCellValue());
        List<String> columnHeaderList = this.getColumnHeaderList();
        Map<String, String> map = new HashMap<>();
        if (row != null && !this.isRowEmpty(row)) {
            for (int j = 0; j < columnHeaderList.size(); j++) {
                Cell cell = row.getCell(j);
                map.put(columnHeaderList.get(j),
                        this.getCellValue(cell));
            }
        }
        return map;
    }


    private boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            String value = this.getCellValue(cell);
            if (value != "")
                return false;
        }
        return true;
    }

    public Sheet getsheet() {
        return this.sheet;
    }
}
