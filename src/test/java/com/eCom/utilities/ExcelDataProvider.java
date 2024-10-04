package com.eCom.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {

    public  XSSFWorkbook workbook;
    public  XSSFSheet excelSheet;
    public  XSSFRow row;
    public  XSSFCell cell;



    public ExcelDataProvider(String fileName, String sheetName){
        File file = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheet(sheetName);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public ExcelDataProvider(String fileName, int sheetIndex){
        File file = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            excelSheet = workbook.getSheetAt(sheetIndex);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    public static int getRowCount(String fileName, String sheetName){
        try {
            ExcelDataProvider excelDataProvider = new ExcelDataProvider(fileName, sheetName);
            int rowCount = excelDataProvider.getExcelSheet().getLastRowNum() + 1;
            excelDataProvider.getWorkbook().close();
            return rowCount;
        } catch (IOException e) {
            e.printStackTrace();
            return  -1;
        }
    }

    public static int getColumnCount(String fileName, String sheetName){
        try {
            ExcelDataProvider excelDataProvider = new ExcelDataProvider(fileName, sheetName);
            int colCount = excelDataProvider.getExcelSheet().getRow(0).getLastCellNum();
            excelDataProvider.getWorkbook().close();
            return colCount;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getCellValue(String filename, String sheetName, int row, int col) {

        try {
            ExcelDataProvider excelDataProvider = new ExcelDataProvider(filename, sheetName);
            excelDataProvider.setCell(excelDataProvider.getExcelSheet().getRow(row).getCell(col));
            FileInputStream fis = new FileInputStream(filename);
            excelDataProvider.getWorkbook().close();
            return excelDataProvider.getCell().getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static String getStringData(String fileName, int sheetIndex, int row, int col){
        ExcelDataProvider excelDataProvider = new ExcelDataProvider(fileName, sheetIndex);
        return excelDataProvider.getWorkbook().getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
    }

    public static String getStringData(String fileName, String sheetName, int row, int col){
        ExcelDataProvider excelDataProvider = new ExcelDataProvider(fileName, sheetName);
        return excelDataProvider.getWorkbook().getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public static double getNumericData(String fileName, String sheetName, int row, int col){
        ExcelDataProvider excelDataProvider = new ExcelDataProvider(fileName, sheetName);
        return excelDataProvider.getWorkbook().getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }

    public XSSFCell getCell() {
        return cell;
    }

    public void setCell(XSSFCell cell) {
        this.cell = cell;
    }

    public XSSFSheet getExcelSheet() {
        return excelSheet;
    }

    public void setExcelSheet(XSSFSheet excelSheet) {
        this.excelSheet = excelSheet;
    }

    public XSSFRow getRow() {
        return row;
    }

    public void setRow(XSSFRow row) {
        this.row = row;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }
}