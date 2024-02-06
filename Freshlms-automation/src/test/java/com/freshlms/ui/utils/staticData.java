package com.freshlms.ui.utils;

import org.openqa.selenium.WebDriver;

public class staticData {

    public static WebDriver driver = null;
    public static String project_directory = System.getProperty("user.dir");
    public static long DEFAULT_WAIT = 20;
    public static String driver_path= project_directory + "\\src\\test\\java\\com\\freshlms\\drivers\\chromedriver.exe";
    public static String urls_excel_path=project_directory + "\\src\\test\\java\\com\\freshlms\\files\\Demo.xlsx";
}
