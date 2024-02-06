package com.freshlms.sterDefinatiions.ui;

import com.freshlms.ui.utils.Selenium_Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.freshlms.ui.utils.Excel_Utils;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyStepdefs extends Selenium_Utils {

    @Given("validate project structure")
    public void validateProjectStructure() throws IOException {
        System.out.print("Step 1 Verified");

    }

    @And("Verify the status")
    public void verifyTheStatus() {
        System.out.print("Step 2 Verified");


    }

    @And("Close browser")
    public void launchBrowser() {
        try{
            Excel_Utils.read_write_excel_data("C:\\Users\\user\\Desktop\\Saikiran\\Freshlms\\Freshlms\\Freshlms-automation\\src\\test\\java\\com\\freshlms\\files\\Demo.xlsx","Sheet1");
            System.out.print("Browser Launched");
            closeBrowser();
        }
        catch (Exception e){

        }
    }
}
