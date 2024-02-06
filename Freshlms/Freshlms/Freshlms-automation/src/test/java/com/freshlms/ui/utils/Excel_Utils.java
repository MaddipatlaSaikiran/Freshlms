package com.freshlms.ui.utils;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  com.freshlms.ui.utils.Selenium_Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Excel_Utils extends staticData{

    public static void read_write_excel_data(String excel_path,String sheet_name) throws IOException {
        XSSFWorkbook wb;
        CellType cell_Type;
        try{
            FileInputStream inputStream=new FileInputStream(excel_path);

            wb=new XSSFWorkbook(inputStream);
            XSSFSheet sheet=wb.getSheet(sheet_name);
//            //Getting no.of columns
//            XSSFRow row=sheet.getRow(0);
//            int colum_count=row.getLastCellNum();
//            //System.out.println(colum_count);
//            XSSFCell cell=null;
//            //Getting Column Names
//            for (int i=0;i<colum_count;i++){
//                cell=row.getCell(i);
//                String column_name=cell.getStringCellValue();
//
//                System.out.print("Column Name is "+column_name);

            XSSFRow row=null;
            XSSFCell cell=null;
            String col1=null;
            String col2=null;
            String col2_Value="Write to Excel pass";
            for (int i=1;i<=sheet.getLastRowNum();i++) {
                row=sheet.getRow(i);

                for (int j=0;j<row.getLastCellNum();j++) {
                    cell=row.getCell(j);
                    if(j==0) {
                        col1=cell.getStringCellValue();
                        //opening Urls
                        driver.navigate().to(col1);
                    List<WebElement> link_count= driver.findElements(By.tagName("a"));
                    System.out.print("The Number of links available on the web page :"+link_count.size());


                       //Writing Cell values
                        //Setting Response code
                        cell=row.createCell(1);
                        cell_Type=cell.getCellType();
                        int response_code=Selenium_Utils.status_code_url();
                        cell.setCellValue((int) response_code);

                        //Extract email from web page and writing to excel file

                        cell=row.createCell(2);
                        cell_Type=cell.getCellType();
                       StringJoiner joiner=Selenium_Utils.extract_email_web_page(link_count);
                        cell.setCellValue(joiner.toString());

                    }
//                        if(j==1) {
//                            col2=cell.getStringCellValue();
//                        }
                }
                System.out.print("Col1"+col1);
                FileOutputStream os=new FileOutputStream(excel_path);
                wb.write(os);
                os.close();

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
    public  ArrayList<String> read_excel_data(String excel_path,String sheet_name) throws IOException {
        XSSFWorkbook wb;
        try{
            FileInputStream inputStream=new FileInputStream(excel_path);

            wb=new XSSFWorkbook(inputStream);
            XSSFSheet sheet=wb.getSheet(sheet_name);
//            //Getting no.of columns
//            XSSFRow row=sheet.getRow(0);
//            int colum_count=row.getLastCellNum();
//            //System.out.println(colum_count);
//            XSSFCell cell=null;
//            //Getting Column Names
//            for (int i=0;i<colum_count;i++){
//                cell=row.getCell(i);
//                String column_name=cell.getStringCellValue();
//
//                System.out.print("Column Name is "+column_name);

            XSSFRow row=null;
            XSSFCell cell=null;
            String col1=null;
            String col2=null;
            String col2_Value="Write to Excel";
            for (int i=1;i<=sheet.getLastRowNum();i++) {
                row=sheet.getRow(i);

                for (int j=0;j<row.getLastCellNum();j++) {
                    cell=row.getCell(j);
                    if(j==0) {
                        col1=cell.getStringCellValue();
                        List<String> lst=new ArrayList<String>();
                        lst.add(col1);

                        cell=row.createCell(1);
                        CellType cell_Type=cell.getCellType();
                        System.out.print("CellTyepe"+cell_Type);
                        //cell.setCellType(cell_Type);
                        cell.setCellValue((String) col2_Value);
                    }
//                        if(j==1) {
//                            col2=cell.getStringCellValue();
//                        }
                }
                System.out.print("Col1"+col1);
                FileOutputStream os=new FileOutputStream(excel_path);
                wb.write(os);
                os.close();

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return  null;
    }


}
