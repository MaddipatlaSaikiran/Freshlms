package com.freshlms.ui.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Selenium_Utils {
    public static WebDriver driver=null;
    private static final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public Selenium_Utils(){
        try{

            if (driver == null) {
                driver = DriverFactory.createAndGetDeviceDriver("chrome");
                driver.manage().window().maximize();
                //driver.navigate().to("https://www.google.com/");
                driver.navigate().to("https://softwaretestingboard.com/contact/");

                PageFactory.initElements(driver, this);
            }

        }catch (Exception e){
            // Something went wrong during driver creation, return a failure
            e.printStackTrace();
            Assert.fail("Exception occurred instantiating PageObjectBase.driver [" + e.getMessage() + "]");

        }
    }

    public static int  status_code_url(){
        int response_code = 0;
        try {
            // establish, open connection with URL
            HttpURLConnection cn = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            // set HEADER request
            cn.setRequestMethod("HEAD");
            // connection initiate
            cn.connect();
            response_code = cn.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response_code;

    }
    public static StringJoiner extract_email_web_page(List<WebElement> array_list){
        StringJoiner return_value=new StringJoiner(" , ");
//        ArrayList<String> ele=new ArrayList<>();
//        ele.add("Saikiran");
//        ele.add("sai@gmail.com");
//        ele.add("kiran@outlook.com");
        //initialize the Pattern object
        Pattern pattern = Pattern.compile(regex);

        for (WebElement value:array_list){
            Matcher matcher = pattern.matcher(value.getText());
            if(matcher.matches()){
                return_value.add(value.getText());
                System.out.print("Match Value is :"+return_value);

            }
            System.out.println("Email " + value + " is " + (matcher.matches() ? "valid" : "invalid"));
        }
        return return_value;
    }

    public static void closeBrowser(){
        try{
            DriverFactory.closeDriver();

        }catch (Exception e){

        }
    }

}
